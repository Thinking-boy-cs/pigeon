'''
Author: Jecosine
Date: 2020-12-15 18:48:44
LastEditTime: 2020-12-18 01:48:44
LastEditors: Jecosine
Description: utils
'''
import uuid
import mysql.connector
def get_uuid(count):
    if count <= 36:
        return str(uuid.uuid4())[:count]
    return None

class DatabaseConnector:
    def __init__(self, database=None, username='root', password='123456', host='localhost', port=3306):
        self.con = mysql.connector.connect(user=username, password=password, database=database, host=host, port=port, use_unicode=True)
        # self.cursor = self.con.cursor()
    def execute_query(self, query):
        cursor = self.con.cursor()
        try:            
            cursor.execute(query)
        except Exception as e:
            print('executing {} error: '.format(query) + str(e))
            return None
        else:
            return cursor.fetchall()
    def execute_change(self, sql, data=None):
        cursor = self.con.cursor()
        try:            
            if data :
                if type(data) == tuple:
                    cursor.executemany(sql, data)
                else:
                    cursor.execute(sql, data)
            else:
                cursor.execute(sql)
        except Exception as e:
            print('executing {} error: '.format(sql) + str(e))
            cursor.close()
            return False
        else:
            self.con.commit()
            cursor.close()
            return True
            
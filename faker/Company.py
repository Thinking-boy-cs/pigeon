'''
Author: Jecosine
Date: 2020-12-15 18:24:21
LastEditTime: 2020-12-15 20:20:57
LastEditors: Jecosine
Description: company entity
'''
from random import random
from uuid import SafeUUID
from utils import *
from faker import Faker
import random
faker = Faker('zh_CN')
class Company:
    """
    comment
    """
    def __init__(self, _id=None, name=None, userId=None):
        self._id = _id or get_uuid(15)
        self.name = name or faker.company()
        self.userId = userId

    @staticmethod
    def get_insert_sql():
        return '''INSERT INTO company (id, name, userId)
VALUES (%s, %s, %s);
'''
    @staticmethod
    def get_update_sql():
        return """UPDATE company t
                    SET t.name   = '%s',
                        t.userId = '%s'
                    WHERE t.id LIKE '%s' ESCAPE '#'"""

    def get_data_for_insert(self):
        d = list(self.__dict__.items())
        return  tuple([i[-1] for i in d])
        
    def get_data_for_update(self):
        d = list(self.__dict__.items())
        d = [i[-1] for i in d]
        t = d.pop(0)
        d.append(t)
        return tuple(d)

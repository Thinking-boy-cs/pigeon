'''
Author: Jecosine
Date: 2020-12-15 18:25:03
LastEditTime: 2020-12-15 21:45:20
LastEditors: Jecosine
Description: group entity
'''
from random import random
from uuid import SafeUUID
from utils import *

from faker import Faker
import random
faker = Faker('zh_CN')


class Group:
    """
    comment
    """
    def __init__(self, _id=None, name=None, parentId=None, companyId=None):
        self._id = _id or get_uuid(15)
        self.name = name or faker.word()
        self.parentId = parentId
        self.companyId = companyId
    
    def set_parent(self, parent):
        self.parentId = parent

    @staticmethod
    def get_insert_sql():
        return '''INSERT INTO pigeonnest.`group` (id, name, parentId, companyId)
VALUES (%s, %s, %s, %s)'''
    @staticmethod
    def get_update_sql():
        return """UPDATE group t
                    SET t.name   = '%s',
                        t.parentId = '%s'
                        t.companyId = '%s'
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

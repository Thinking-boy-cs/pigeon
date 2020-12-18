'''
Author: Jecosine
Date: 2020-12-15 18:25:14
LastEditTime: 2020-12-18 05:51:28
LastEditors: Jecosine
Description: staff entity
'''
from random import random
from uuid import SafeUUID
from utils import *
from faker import Faker
import random
faker = Faker('zh_CN')


class Staff:
    """
    comment
    """
    def __init__(self, _id=None, username=None, dept=None, password=None, sex=None, homeTown=None, telNumber=None, 
        email=None, icon=None, status=None, statusTime=None, companyId=None, originId=None, registerTime=None, signature=None, salary=None):
        self._id = _id or get_uuid(15)
        self.username = username or faker.name()
        self.dept = dept
        self.password = password or '123456'
        self.sex = sex or random.random() > 0.5 and '男' or '女'
        self.homeTown = homeTown or faker.province()
        self.telNumber = telNumber or faker.phone_number()
        self.email = email or faker.ascii_safe_email()
        self.icon = icon
        self.status = status or '0'
        self.statusTime = statusTime or faker.date(pattern="%Y-%m-%d %H:%M:%S", end_datetime=None)
        self.companyId = companyId
        self.originId = originId
        self.registerTime = registerTime or faker.date(pattern="%Y-%m-%d %H:%M:%S", end_datetime=None)
        self.signature = signature or faker.paragraph(1)
        self.salary = salary or random.randint(1000, 20000)

    @staticmethod
    def get_insert_sql():
        return '''INSERT INTO staff (id, username, dept, password, sex, hometown, telNumber, email, icon, status, statusTime,
                              companyId, originId, registerTime, signature, salary)
VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'''
    @staticmethod
    def get_update_sql():
        return """UPDATE staff t
                    SET t.username     = %s,
                        t.dept         = %s,
                        t.password     = %s,
                        t.sex          = %s,
                        t.hometown     = %s,
                        t.telNumber    = %s,
                        t.email        = %s,
                        t.icon         = %s,
                        t.status       = %s,
                        t.statusTime   = %s,
                        t.companyId    = %s,
                        t.originId     = %s,
                        t.registerTime = %s,
                        t.signature    = %s,
                        t.salary       = %s
                    WHERE t.id = %s"""

    def get_data_for_insert(self):
        d = list(self.__dict__.items())
        return tuple([i[-1] for i in d])
    def get_data_for_update(self):
        d = list(self.__dict__.items())
        d = [i[-1] for i in d]
        t = d.pop(0)
        d.append(t)
        return tuple(d)


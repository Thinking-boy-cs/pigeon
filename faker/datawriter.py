'''
Author: Jecosine
Date: 2020-12-15 19:22:33
LastEditTime: 2020-12-15 20:16:51
LastEditors: Jecosine
Description: write data to mysql
'''
from utils import *
from Staff import Staff
from Company import Company
from Group import Group

database = DatabaseConnector('pigeonnest', 'pigeonnest', 'Y8R6Pps2ZnxkmPxx', '175.24.84.47', 34248)

def generate_company(number):
    bosses = [Staff() for  i in range(number)]
    companies = [Company() for i in range(number)]
    for i in range(number):
        bosses[i].companyId = companies[i]._id # keng??
        companies[i].userId = bosses[i]._id
    boss_data = [i.get_data_for_insert() for i in bosses]
    company_data = [i.get_data_for_insert() for i in companies]
    staff_sql = Staff.get_insert_sql()
    company_sql = Company.get_insert_sql()
    database.execute_change(staff_sql, tuple(boss_data))
    database.execute_change(company_sql, tuple(company_data))
    return True

def generate_company_with_staff(number, staff_number=1000):
    pass

generate_company(10)
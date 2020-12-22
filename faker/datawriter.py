'''
Author: Jecosine
Date: 2020-12-15 19:22:33
LastEditTime: 2020-12-18 05:52:57
LastEditors: Jecosine
Description: write data to mysql
'''
from collections import UserDict
from utils import *
from Staff import Staff
from Company import Company
from Group import Group
import random

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
    return companies

def set_parent(g, p):
    for i in g:
        i.set_parent(p)

def set_parent(g, gi, p):
    for i in gi:
        g[i].set_parent(g[p]._id)

# basic 
def get_companies():
    companies = database.execute_query('select * from company')
    companies = [i[0] for i in companies]
    print(companies)
    return companies

def set_staff_distribution(companyId):
    users = database.execute_query("select * from staff where companyId='{}'".format(companyId))
    l = len(users)
    serial = [i for i in range(l)]
    print(users[0][9])
    random.shuffle(serial)
    a, b = int(l * 0.2), int(l * 0.75)
    c = l - a - b
    for i in range(a):
        users[i] = list(users[i])
        users[i][9] = '-1'
    for i in range(a, a + b):
        users[i] = list(users[i])
        users[i][9] = '0'
    for i in range(a + b, l):
        users[i] = list(users[i])
        users[i][9] = '1'
    sql = Staff.get_update_sql()
    for i in range(len(users)):
        users[i].append(users[i].pop(0))
    user_data = tuple([tuple(i) for i in users])
    database.execute_change(sql, user_data)
    
def generate_company_with_groups(number):
    bosses = [Staff() for  i in range(number)]
    companies = [Company() for i in range(number)]
    groups = []
    # construct company
    gnames = ['董事会', '总经理', '副总经理', '市场总监', '技术总监', '副总经理', '财务部', '行政人事部', '商务部', '市场发展部', '客户服务部', '外部办事部', '产品研发部', '技术服务部', '系统集成部', '副总经理', '采购部', '生产部', '质检部']
    for i in companies: 
        temp_groups = [Group(name=j, companyId=i._id) for j in gnames]
        # set relation
        set_parent(temp_groups, [1], 0)
        set_parent(temp_groups, [2, 3, 4, 5], 1)
        set_parent(temp_groups, [6, 7, 8], 2)
        set_parent(temp_groups, [9, 10, 11], 3)
        set_parent(temp_groups, [12, 13, 14], 4)
        set_parent(temp_groups, [15, 16, 17], 5)
        groups += temp_groups
    
    group_data = [i.get_data_for_insert() for i in groups]
    print(group_data)
    for i in range(number):
        bosses[i].companyId = companies[i]._id # keng??
        companies[i].userId = bosses[i]._id
    boss_data = [i.get_data_for_insert() for i in bosses]
    company_data = [i.get_data_for_insert() for i in companies]
    staff_sql = Staff.get_insert_sql()
    group_sql = Group.get_insert_sql()
    company_sql = Company.get_insert_sql()
    database.execute_change(staff_sql, tuple(boss_data))
    database.execute_change(company_sql, tuple(company_data))
    database.execute_change(group_sql, tuple(group_data))
    return companies, groups

def generate_company_with_groups_and_staff(number, minimum=8, maximum=57):
    bosses = [Staff() for  i in range(number)]
    companies = [Company() for i in range(number)]
    groups = []
    # construct company
    gnames = ['董事会', '总经理', '副总经理', '市场总监', '技术总监', '副总经理', '财务部', '行政人事部', '商务部', '市场发展部', '客户服务部', '外部办事部', '产品研发部', '技术服务部', '系统集成部', '副总经理', '采购部', '生产部', '质检部']
    for i in companies: 
        temp_groups = [Group(name=j, companyId=i._id) for j in gnames]
        # set relation
        set_parent(temp_groups, [1], 0)
        set_parent(temp_groups, [2, 3, 4, 5], 1)
        set_parent(temp_groups, [6, 7, 8], 2)
        set_parent(temp_groups, [9, 10, 11], 3)
        set_parent(temp_groups, [12, 13, 14], 4)
        set_parent(temp_groups, [15, 16, 17], 5)
        groups += temp_groups
    
    group_data = [i.get_data_for_insert() for i in groups]
    # print(group_data)
    for i in range(number):
        bosses[i].companyId = companies[i]._id # keng??
        companies[i].userId = bosses[i]._id
    users_data = []
    for i in groups:
        rd = random.randint(minimum, maximum)
        temp_users = [Staff(companyId=i.companyId, dept=i._id) for j in range(rd)]
        users_data += [j.get_data_for_insert() for j in temp_users]
    staff_sql = Staff.get_insert_sql()
    boss_data = [i.get_data_for_insert() for i in bosses]
    company_data = [i.get_data_for_insert() for i in companies]
    staff_sql = Staff.get_insert_sql()
    group_sql = Group.get_insert_sql()
    company_sql = Company.get_insert_sql()
    # print(users_data)
    database.execute_change(company_sql, tuple(company_data))
    database.execute_change(staff_sql, tuple(boss_data))
    database.execute_change(group_sql, tuple(group_data))
    database.execute_change(staff_sql, tuple(users_data))
    
def set_company_staff_status():
    companies = get_companies()
    for i in companies:
        set_staff_distribution(i)
    
set_company_staff_status()
# get_companies()
# generate_company_with_groups_and_staff(40)
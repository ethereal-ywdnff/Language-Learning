insert into `employee` value(200, 'lll', 'm', '2002-11-27', 'work', 5000, 'study');
select*from employee;

#将所有员工薪水都修改为7000
update employee set salary = 7000;
#更改某一员工的薪水
update employee set salary = 10000 where user_name = 'lkh';
#将某一员工的薪水在原有基础上增加1000元
update employee set salary = salary + 1000 where user_name = 'lkh';
#修改多个列的值
update employee set salary = salary + 1000, sex = 'female' where user_name = 'lll';




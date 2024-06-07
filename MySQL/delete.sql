insert into `employee` value(300, 'kkk', 'male', '2002-11-27', 'work', 5000, 'study');
select*from employee;

#删除某一位员工
delete from employee 
		where user_name = 'kkk';
#删除全部员工
delete from employee;
#delete不能删除某一个值，只能使用update设为null或' '
update employee set job = ' ' where user_name = 'kkk';





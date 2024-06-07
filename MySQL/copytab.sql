select * from my_table;

# 往my_table中插入emp里的数据
insert into my_table 
		(id, `name`, sal, job, deptno)
		select empno, ename, sal, job,deptno from emp;

# 自我复制，1->2->4->8->16...
insert into my_table
		select * from my_table;

# 复制emp的结构到my_table2中
create table my_table2 like emp;
select * from my_table2;

# 删掉my_table里的重复记录
# 先创建一张临时表my_tmp，和my_table结构一样
create table my_tmp like my_table;
# 把my_table的数据通过distinct关键字处理后 复制到my_tmp
insert into my_tmp 
		select distinct * from my_table;
# 清除掉my_table中的数据
delete from my_table;
# 将my_tmp里的数据复制到my_table里
insert into my_table 
		select * from my_tmp;
# 删除my_tmp表
drop table my_tmp;


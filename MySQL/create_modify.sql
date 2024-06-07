CREATE TABLE `emp` (
		id int,
        `name` varchar(32),
        sex char(4),
        birthday date,
        job varchar(32),
        salary double,
        `resume` text) charset utf8 collate utf8_bin engine innodb;
        
insert into `emp` value(100, 'lkh', 'm', '2002-11-27', 'study', 3000, 'work');
        
select*from emp;
desc emp; -- 显示表结构，可以查看表的所有列

#修改emp列表
-- 添加image在resume后面
alter table `emp` add image varchar(32) not null default ' ' after resume;
-- 修改job的长度 (varchar(32) -> varchar(60))
alter table emp modify job varchar(60) not null default ' ';
-- 删除image列
alter table emp drop image;
-- 将表名改为employee
rename table emp to employee;
-- 修改表的字符集
alter table employee character set utf8;
-- 将列名name改为user_name
alter table employee change `name` `user_name` varchar(20) not null default ' ';

select*from employee;
desc employee;

        










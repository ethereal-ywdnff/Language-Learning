create table `goods` (
		id int,
        name varchar(10),
        price double);

insert into `goods` (id, name, price) 
		values (10, 'iphone', 10000);

select*from goods;

#字符和日期型数据应包含在单引号内
#列可以插入空值，前提是该字段允许为空
insert into `goods` (id, name, price) 
		values (20, 'huawei', null);
#inser into tab_name values (),(),() 形式添加多条记录
insert into `goods` (id, name, price) 
		values (20, 'xiaomi', 10000), (30, 'vivo', 10000);
#如果是给表中所有字段添加数据可以不用写前面的字段名称
insert into `goods` 
		values (50,'huawei', null);
#如果某个列没有指定not null，那么添加数据时，没有给定值，就会默认给空
insert into `goods` (id, name, price) 
		values (60, 'samsung', 10000);
        





        

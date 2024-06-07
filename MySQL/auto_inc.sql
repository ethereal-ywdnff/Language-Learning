create table auto 
		( id int primary key auto_increment,
        `name` varchar(32) not null default '',
        number int not null default '');
        
SELECT * FROM auto;

insert into auto values(null, 'tom', 123);
insert into auto (`name`, number) values('jack', 456);
insert into auto values(10, 'tom', 123);# 从10开始自增长了




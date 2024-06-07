select current_date() from dual;
select current_time() from dual;
select current_timestamp() from dual;

create table mes(
		id int,
        content varchar(30),
        send_time datetime);
        
insert into mes values(1, 'Beijing News', current_timestamp());
insert into mes values(2, 'Shanghai News', now());

select * from mes;

-- 显示所有新闻信息，发布日期(只显示日期，不显示时间)
select id, content, date(send_time) from mes;
-- 查询在十分钟内发送的新闻
select * from mes where date_add(send_time, interval 10 minute) >= now();
select * from mes where date_sub(now(), interval 10 minute) <= send_time;
-- 查询两个时间相差的天数
SELECT DATEDIFF('2011-11-11', '1990-01-01') FROM DUAL;
select datediff(now(), '2002-11-27') from dual;
select date_add('2002-11-27', interval 80 year) from dual;

select year(now()) from dual;
select month(now()) from dual;
select day(now()) from dual;






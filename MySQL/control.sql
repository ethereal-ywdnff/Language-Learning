-- if(expr1, expr2, expr3) 如果expr1为true，则返回expr2，否则返回expr3
select if(true, '1', '2');
-- if(expr1, expr2) 如果expr1不为null，则返回expr1，否则返回expr2
select ifnull('lll', 'kkk');
select case
		when false then 'jack'
        when false then 'tom'
        else 'mary' end;
        
        
-- 查询emp表，如果comm是null，显示0.0
-- 判断是否为空用is null，判断是否不为空用is not null
select ename, if(comm is null, 0.0, comm) from group_by.emp;

select ename, (select case
				when job = 'clerk' then '职员'
				when job = 'manager' then '经理'
				when job = 'salesman' then '销售'
				else job end)
		from group_by.emp;






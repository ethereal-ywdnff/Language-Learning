create table tran 
		(id int,
        `name` varchar(32));
select * from tran;

# 开始事务
start transaction;
savepoint a;
insert into tran values(100, 'tom');
savepoint b;
insert into tran values(200, 'jack');

# 回退到b点
rollback to b;
# 回退到a点
rollback to a;
# 直接回退到事务开始的状态
rollback;
# 提交事务，各个savepoint会自动删除
commit






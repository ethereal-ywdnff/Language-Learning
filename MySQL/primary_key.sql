# 主键自带 不能为空
# 不能有两个主键，但可以复合主键

create table t1
		(id int,
        `name` varchar(32),
        score varchar(32),
        primary key (id, `name`)
        );
select * from t1;
insert into t1 values(1, 'tom', 90);
insert into t1 values(1, 'jack', 89);# id和name中有一个不同就执行不了
insert into t1 values(1, 'tom', 98); # id和name都相等就能执行



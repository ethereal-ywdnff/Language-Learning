
select * from emp;
select count(*), avg(sal), job from group_by.emp group by job;

# 没有获得补助的员工
select count(*), count(if(comm is null, 1, null)) from emp;
select count(*), count(*) - count(comm) from emp;
# 显示管理者总数(相同的数字只算一个)
select count(distinct mgr) from emp;


# 统计各个部门平均工资大于1000，并从高到低排序，取出前两行记录
select deptno, avg(sal) as avg_sal 
		from emp 
        group by deptno 
        having avg_sal > 1000 
        order by avg_sal desc
        limit 0, 2





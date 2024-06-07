# database: group_by
select * from emp;
select * from dept;
select * from salary;


# 显示工资员工和他的上级的名字 
select worker.ename, boss.ename
		from emp worker, emp boss-- 别名(worker, boss)，实际上是同一张表
        where worker.mgr = boss.empno;




















# database: group_by
select * from emp;


# 如何显示与smith同一部门的所有员工
select deptno from emp where ename = 'aaa';
select * from emp
		where deptno = (
			select deptno 
            from emp
            where ename = 'aaa'
		);
        
        
# 查询和20号部门的工作相同的名字，岗位，工资，部门号，
# 但不包含10号部门自己的雇员
select distinct job 
	from emp
    where deptno = 20;-- 查询20号部门有哪些岗位
select ename, job, sal, deptno 
	from emp
    where job in (
			select distinct job 
					from emp
					where deptno = 20
	) and deptno != 20;
			
       
# 各个不同的部门号中，工资最高的雇员
# 把子查询当作一张表
select deptno, max(sal) from emp group by deptno;
select emp.deptno, ename, sal from (
			select deptno, max(sal) as max_sal
            from emp 
            group by deptno
		) temp, emp 
        where temp.deptno = emp.deptno and temp.max_sal = emp.sal
        order by emp.deptno;




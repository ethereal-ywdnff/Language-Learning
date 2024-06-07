# database: group_by
select * from emp;

# 查询比30号员工最高工资要高的员工
select ename, sal,deptno from emp
		where sal > all (
				select sal
						from emp
                        where deptno = 30
		);

select ename, sal,deptno from emp
		where sal > (
				select max(sal)
						from emp
                        where deptno = 30
		);
        

# 显示工资比30号部门的其中一个员工的工资高的员工的姓名，工资和部门号
select ename, sal,deptno from emp
		where sal > any (
				select sal
						from emp
                        where deptno = 30
		);
       
select ename, sal,deptno from emp
		where sal > (
				select min(sal)
						from emp
                        where deptno = 30
		);

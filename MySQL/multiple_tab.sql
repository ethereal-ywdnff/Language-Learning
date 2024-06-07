# database: group_by
select * from emp;
select * from dept;
select * from salary;


# 显示雇员名，雇员工资以及所在部门的名字
select ename, sal, dname, emp.deptno 
		from emp, dept 
        where emp.deptno = dept.deptno;-- 一个过滤条件
									   -- 3张表要两个过滤条件，4张表要三个

# 显示部门号为10的部门名，员工名和工资
select emp.deptno, ename, sal, ename
		from emp, dept
        where emp.deptno = dept.deptno and emp.deptno = 10;

# 显示各个员工的名字，工资，及其工资的级别
select ename, sal, grade 
		from emp, salary where sal 
        between losal and hisal
        order by grade desc;


-- database: group_by

select * from dept;
select * from emp;
select * from salary;

-- 查询每个部门的平均工资和最高工资，按照部门来分组
select avg(sal), max(sal), deptno from emp group by deptno;
-- 查询每个部门每个岗位的平均工资和最低工资
select avg(sal), min(sal), deptno, job from emp group by deptno, job;
-- 显示平均工资低于2000的部门号和它的平均工资
select avg(sal) as avg_sal, deptno 
		from emp group by deptno
        having avg_sal < 2000;






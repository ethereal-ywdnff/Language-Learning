select * from group_by.emp;
select * from group_by.dept;
select * from group_by.salary;

-- 查找2000-01-01后入职的员工
select * from group_by.emp where hiredate > '2000-01-01';
-- like 
-- 		% 0到多个字符   : 单个任意字符
-- 显示手字符为s的员工姓名和工资
select ename, sal from group_by.emp where ename like 'A%';
-- 查询第三个字符为b的员工
select ename, sal from group_by.emp where ename like '__b%';
select * from group_by.emp where mgr = '7902';
-- 工资从低到高
select * from group_by.emp order by sal asc;
-- 部门号从低到高，工资从高到低 
select * from group_by.emp order by deptno asc, sal desc;















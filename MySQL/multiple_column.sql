# database: group_by
select * from emp;

# 查询与aaa的部门和岗位完全相同的所有雇员
# (字段1, 字段 2) = (select 字段 1, 字段 2 from....)
select deptno, job from emp
		where ename = 'aaa';
        
select * from emp
		where (deptno, job) = (
				select deptno, job from emp
				where ename = 'aaa'
		) and ename != 'aaa';



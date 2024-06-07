# 合并查询

# 不会去重
select ename, sal, job from emp where sal > 1500
union all
select ename, sal, job from emp where job = 'manager';

# 会去重
select ename, sal, job from emp where sal > 1500
union
select ename, sal, job from emp where job = 'manager';
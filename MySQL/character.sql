-- database: group_by
select * from emp;

select charset(ename) from emp;-- 返回字符串集
select concat(ename, ' job is ', job) from emp;-- 拼接
select instr('lkh', 'k') from dual;-- 返回‘k'在’lkh'中出现的位置
-- 转换大小写
select ucase(ename) from emp;
select lcase(ename) from emp;
select left(ename, 2) from emp;
select right(ename, 2) from emp;
-- 案字节返回
select length('刘康骅') from emp;-- 9
select length('lkh') from emp;-- 3
select ename, replace(job, 'manager', 'mana') from emp;
select strcmp('lkh', 'ljh') from dual;-- 比较两字串大小
select substring(ename, 1, 2) from emp;-- 第一个开始两个字符
select substring(ename, 1) from emp;-- 第一个开始所有字符
-- 去左右两边空格
select ltrim('   lkh') from dual;
select rtrim('lkh    ') from dual;
select trim('    lkh    ') from dual;

-- 让ename第一个字符为小写，其他大写
select concat(lcase(left(ename,1)), ucase(substring(ename,2))) as new_name from emp;
select concat(lcase(substring(ename,1,1)), ucase(substring(ename,2))) as new_name from emp;







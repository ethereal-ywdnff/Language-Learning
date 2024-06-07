select * from student;

-- 统计一个班共有多少个学生
select count(*) from student;
-- 统计数学成绩大于90的有多少个学生
select count(*) from student where math > 90;
-- 统计总分大于190的学生有多少
select count(*) from student where (math + eng) > 190;
-- count(*) 和 count(列) 的区别
-- count*  返回满足条件的记录的多少
-- count(列)  统计满足条件的某列有多少个，但会排除null
select count(*) from student;-- 5
select count(name) from student;-- 4


-- 统计一个班的数学总成绩
select sum(math) from student;
-- 统计一个班各科分别的总成绩
select sum(math) as math_total_score, sum(eng) from student;
-- 统计一个班各科的总成绩之和
select sum(math + eng) from student;
-- 统计一个班数学成绩的平均分
select sum(math)/count(*) from student;


-- 求一个班数学平均分
select avg(math) from student;
-- 求一个班总分的平均分
select avg(math + eng) from student;


-- 求班级最高分最低分
select max(math + eng) as max, min(math + eng) from student;




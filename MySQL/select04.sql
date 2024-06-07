-- order by
select * from student;

-- 按数学成绩升序排列
select * from student 
		order by math desc;
-- 按数学成绩降序排列
select * from student 
		order by math desc;
-- 按总分降序排列
select `name`, (math+eng) as total_score from student 
		order by total_score desc;
-- 对姓刘的同学升序排列
select `name`, (math+eng) as total_score from student 
		where `name` like '刘%' 
        order by total_score;





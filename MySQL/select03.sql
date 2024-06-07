select * from student;

select * from student where eng > 100;
select * from student where (math+eng) > 190;
select * from student where math > 80 and id > 2;
select * from student where eng > math;
select * from student where (math+eng) > 190 and math < eng and `name` like '刘%';
select * from student where math >= 90 and eng <= 100;
-- between and
select * from student where math between 80 and 100; -- 80 <= math <= 100
-- 查询分数为80，90的同学
select * from student where math = 80 or math = 90;
select * from student where math in (80,90);
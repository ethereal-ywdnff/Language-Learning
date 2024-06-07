SELECT * from student;

-- 统计每个学生的总分
select `name` , (math+eng) from student;
-- 在所有学生总分上加10分
select `name` , (math+eng+10) from student;
-- 使用新名称来表示学生分数
select `name` as `student_name`, (math+eng) as total_score from student;



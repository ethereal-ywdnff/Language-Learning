# database: group_by
select * from stu;
select * from exam;


select `name`, stu.id, grade
		from stu, exam
        where stu.id = exam.id;

# 左外连接(显示所有人的成绩，即使没有成绩，也得显示该人的姓名和学号)
select `name`, stu.id, grade
		from stu left join exam
        on stu.id = exam.id;

# 右外连接(显示所有成绩，如果没有名字匹配，则显示空)
select `name`, stu.id, grade
		from stu right join exam
        on stu.id = exam.id;





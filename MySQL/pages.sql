
-- 按雇员升序排序，每页显示第一页，第二页，第三页
-- 第一页
select * from group_by.emp order by empno limit 0, 3;
-- 第二页
select * from group_by.emp order by empno limit 3, 3;
-- 第三页
select * from group_by.emp order by empno limit 6, 3;

/* 公式
select * from group_by.emp 
		order by empno 
        limit 每页显示记录数*（第几页-1）, 每页显示记录数;
*/







SELECT * FROM testdb.student;
-- 单行注释
#单行注释
/*
多行注释
*/

SELECT 2*3;

use testdb;
SELECT * from student;


CREATE DATABASE db01;
DROP DATABASE db01;
#创建一个使用utf8字符集的db02数据库
CREATE DATABASE db02 CHARACTER SET utf8;
-- 创建一个使用utf8字符集，并带校对规则的nsp db03数据库
CREATE DATABASE db03 CHARACTER SET utf8 COLLATE utf8_bin;

#校对规则: utf8_bin区分大小默认utf8_general_ci不区分图标里的大小写(tom Tom)
SELECT * FROM db02.t1;
SELECT * FROM db02.t1 WHERE name = 'tom';

SELECT * FROM db03.t1;
SELECT * FROM db03.t1 WHERE name = 'tom';





















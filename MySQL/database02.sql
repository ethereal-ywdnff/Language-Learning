#查看当前数据库服务器中的所有数据库
SHOW DATABASES;

#查看前面创建的db01数据库的定义信息
SHOW CREATE DATABASE db01;

#在创建数据库，表的时候，为了规避关键字，可以使用反引号解决
CREATE DATABASE `CREATE`;
DROP DATABASE `CREATE`;

CREATE TABLE db01.`users` (
		id INT,
        `name` VARCHAR(255),
        `password` VARCHAR(255))
        CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;
        


















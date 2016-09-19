create table ecs_administrator(
	-- 编码，管理员名称，密码
	id int(10) primary key,
	name varchar(20),
	password varchar(20)
)


create table ecs_user(
	-- 编码，管理员名称，性别，年龄，密码
	id int(10) primary key,
	name varchar(20),
	gender varchar(4),
	age int(4),
	password varchar(20)
)
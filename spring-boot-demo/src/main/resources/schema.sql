-- 创建数据库demo
create database if not exists demo;

-- 使用数据库demo
use demo;

-- 创建数据表students
create table if not exists students (
    id int auto_increment comment '主键',
    name varchar(100) comment '姓名',
    sex varchar(10) comment '性别',
    age TINYINT comment '年龄',
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建数据表teachers
drop table if exists teachers;
create table if not exists teachers (
    id int auto_increment comment '主键',
    name varchar(100) comment '姓名',
    primary key (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 创建数据表password
drop table if exists password;
create table if not exists passwords (
    id int auto_increment comment '主键',
    password varchar(100) comment '密码',
    tid int comment '外键',
    primary key (id),
    constraint s_p_id foreign key (sid) references teachers (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
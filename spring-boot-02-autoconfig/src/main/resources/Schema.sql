DROP TABLE IF EXISTS Reader;

CREATE TABLE Reader
(
    username VARCHAR(100) NOT NULL COMMENT '主键ID',
    fullname VARCHAR(100) NULL DEFAULT NULL COMMENT '姓名',
    password VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    PRIMARY KEY (username)
);
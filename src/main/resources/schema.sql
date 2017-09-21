CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  name varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  password varchar(20) NOT NULL COMMENT '密码',
  product_line int(4) NOT NULL DEFAULT '0' COMMENT '0默认 1okcoin 2okex 3oklink 4bafang',
  created_date timestamp NULL   COMMENT '创建时间',
  modify_date timestamp NULL   COMMENT '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
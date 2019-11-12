drop database exportdata;

Create database exportdata charset utf8;
use exportdata;

DROP TABLE t_admin_user;
create table if not exists t_admin_user(
user_id int(5) primary key auto_increment comment '主键',
customer_code varchar(50) null comment '客户编号',
customer_password varchar(100) null comment '客户登录密码',
sale_code varchar(50) null comment '销售员编号',
sale_password varchar(100) null comment '登录密码',
mobile varchar(15) comment '手机号码',
real_name varchar(50) NULL comment '真实姓名',
idcard varchar(18) comment '身份证号码',
address varchar(150) comment '住址',
create_date timestamp default current_timestamp comment '创建时间',
modify_date timestamp null comment '更新时间',
role_code int(5) not null default 2 comment '角色,1-管理员，2商户',
login_mode int(5) null comment '登录方式,1-客户号登录，2-销售员登录,3-管理员登录'
)charset utf8;

insert into t_admin_user(user_id,customer_code,customer_password,sale_code,sale_password,
mobile,real_name,idcard,address,create_date,modify_date,role_code,login_mode)
values (1,'admin','21232f297a57a5a743894a0e4a801fc3','','','','超级管理员','','','2019-11-11',null,1,null);

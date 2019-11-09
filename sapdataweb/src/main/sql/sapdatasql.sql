drop database exportdata;

Create database exportdata charset utf8;
use exportdata;

create table if not exists t_admin_user(
user_id int(5) primary key auto_increment comment '主键',
sale_name varchar(50) null comment '销售登录名称',
sale_password varchar(100) null comment '销售登录密码',
customer_name varchar(50) null comment '客户登录名称',
customer_password varchar(100) null comment '客户登录密码',
mobile varchar(15) comment '手机号码',
user_code varchar(50) comment '客户编号',
real_name varchar(50) NULL comment '真实姓名',
idcard varchar(18) comment '身份证号码',
address varchar(150) comment '住址',
create_date timestamp default current_timestamp comment '创建时间',
modify_date timestamp null comment '更新时间'
)charset utf8;
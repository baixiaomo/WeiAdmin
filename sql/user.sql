/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/14 14:52:24                           */
/*==============================================================*/


drop table if exists wei_user;

/*==============================================================*/
/* Table: wei_user                                              */
/*==============================================================*/
create table wei_user
(
   id                   int not null auto_increment comment '主键',
   username             char(20) comment '姓名',
   password             char(20) comment '密码',
   email                char(30) comment '邮箱',
   role                 char(22) comment '角色',
   state                int comment '状态（0：离线/1：在线）',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   creater              char(22) comment '创建者',
   updater              char(22) comment '修改者',
   primary key (id)
);

alter table wei_user comment '用户表';


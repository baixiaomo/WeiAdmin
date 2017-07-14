/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/10 15:29:04                           */
/*==============================================================*/


drop table if exists wei_dictionary;

/*==============================================================*/
/* Table: wei_dictionary                                        */
/*==============================================================*/
create table wei_dictionary
(
   id                   int not null auto_increment comment '主键',
   type                 varchar(50) comment '类型',
   type_desc            varchar(50) comment '类型描述',
   code                 varchar(50) comment '编码',
   code_desc            varchar(50) comment '编码描述',
   sorted               int comment '排序',
   state                int comment '启用状态',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   creator              varchar(50) comment '创建人',
   updater              varchar(50) comment '修改人',
   primary key (id)
);

alter table wei_dictionary comment '数据字典表';


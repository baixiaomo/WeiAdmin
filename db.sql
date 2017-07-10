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
   id                   int not null auto_increment comment '����',
   type                 varchar(50) comment '����',
   type_desc            varchar(50) comment '��������',
   code                 varchar(50) comment '����',
   code_desc            varchar(50) comment '��������',
   sorted               int comment '����',
   state                int comment '����״̬',
   create_time          datetime comment '����ʱ��',
   update_time          datetime comment '�޸�ʱ��',
   creator              varchar(50) comment '������',
   updater              varchar(50) comment '�޸���',
   primary key (id)
);

alter table wei_dictionary comment '�����ֵ��';


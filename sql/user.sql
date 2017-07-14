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
   id                   int not null auto_increment comment '����',
   username             char(20) comment '����',
   password             char(20) comment '����',
   email                char(30) comment '����',
   role                 char(22) comment '��ɫ',
   state                int comment '״̬��0������/1�����ߣ�',
   create_time          datetime comment '����ʱ��',
   update_time          datetime comment '�޸�ʱ��',
   creater              char(22) comment '������',
   updater              char(22) comment '�޸���',
   primary key (id)
);

alter table wei_user comment '�û���';


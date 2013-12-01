# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_info (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  admin                     tinyint(1) default 0,
  constraint pk_user_info primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;


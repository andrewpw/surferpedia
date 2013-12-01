# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table surfer_update (
  id                        bigint auto_increment not null,
  date                      varchar(255),
  type                      varchar(255),
  target                    varchar(255),
  constraint pk_surfer_update primary key (id))
;

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

drop table surfer_update;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;


# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table favorite (
  id                        bigint not null,
  surfer_id                 bigint,
  user_info_id              bigint,
  constraint pk_favorite primary key (id))
;

create table rating (
  id                        bigint not null,
  rating                    integer,
  surfer_id                 bigint,
  user_info_id              bigint,
  constraint pk_rating primary key (id))
;

create table surfer (
  id                        bigint not null,
  name                      varchar(255),
  hometown                  varchar(255),
  awards                    varchar(255),
  carousel_url              varchar(255),
  bio_url                   varchar(255),
  bio                       clob,
  slug                      varchar(255),
  type                      varchar(255),
  slug_defined              boolean,
  footstyle                 varchar(255),
  country                   varchar(255),
  constraint pk_surfer primary key (id))
;

create table surfer_update (
  id                        bigint not null,
  date                      varchar(255),
  type                      varchar(255),
  target                    varchar(255),
  constraint pk_surfer_update primary key (id))
;

create table user_info (
  id                        bigint not null,
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  admin                     boolean,
  constraint pk_user_info primary key (id))
;

create sequence favorite_seq;

create sequence rating_seq;

create sequence surfer_seq;

create sequence surfer_update_seq;

create sequence user_info_seq;

alter table favorite add constraint fk_favorite_surfer_1 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_favorite_surfer_1 on favorite (surfer_id);
alter table favorite add constraint fk_favorite_userInfo_2 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_favorite_userInfo_2 on favorite (user_info_id);
alter table rating add constraint fk_rating_surfer_3 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_rating_surfer_3 on rating (surfer_id);
alter table rating add constraint fk_rating_userInfo_4 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_rating_userInfo_4 on rating (user_info_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists favorite;

drop table if exists rating;

drop table if exists surfer;

drop table if exists surfer_update;

drop table if exists user_info;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists favorite_seq;

drop sequence if exists rating_seq;

drop sequence if exists surfer_seq;

drop sequence if exists surfer_update_seq;

drop sequence if exists user_info_seq;


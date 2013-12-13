# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table rating (
  user_info_id              bigint,
  surfer_id                 bigint)
;

create table surfer (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  hometown                  varchar(255),
  awards                    varchar(255),
  carousel_url              varchar(255),
  bio_url                   varchar(255),
  bio                       longtext,
  slug                      varchar(255),
  type                      varchar(255),
  slug_defined              tinyint(1) default 0,
  footstyle                 varchar(255),
  country                   varchar(255),
  rating                    integer,
  constraint pk_surfer primary key (id))
;

create table surfer_update (
  id                        bigint auto_increment not null,
  date                      varchar(255),
  type                      varchar(255),
  target                    varchar(255),
  surfer_id                 bigint,
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

alter table rating add constraint fk_rating_userInfo_1 foreign key (user_info_id) references user_info (id) on delete restrict on update restrict;
create index ix_rating_userInfo_1 on rating (user_info_id);
alter table rating add constraint fk_rating_surfer_2 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_rating_surfer_2 on rating (surfer_id);
alter table surfer_update add constraint fk_surfer_update_surfer_3 foreign key (surfer_id) references surfer (id) on delete restrict on update restrict;
create index ix_surfer_update_surfer_3 on surfer_update (surfer_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table rating;

drop table surfer;

drop table surfer_update;

drop table user_info;

SET FOREIGN_KEY_CHECKS=1;


create table users (
  id                        integer auto_increment not null,
  gid                       integer,
  username                  varchar(255),
  password                  varchar(255),
  mail                      varchar(255),
  bereichs_id               integer,
  last_update               datetime not null,
  constraint pk_users primary key (id))
;

create table usergroups (
  id                        integer auto_increment not null,
  gid                       integer,
  uid                       integer,
  last_update               datetime not null,
  constraint pk_usergroups primary key (id))
;

create table gruppen (
  gid                       integer auto_increment not null,
  gruppenname               varchar(255),
  last_update               datetime not null,
  constraint pk_gruppen primary key (gid))
;

create table permissions (
  id                        integer auto_increment not null,
  gid                       integer,
  node                      varchar(255),
  last_update               datetime not null,
  constraint pk_permissions primary key (id))
;




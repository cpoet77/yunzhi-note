-- apply changes
create table spc_article (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_spc_article primary key (id)
);

create table sys_catalog (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_catalog primary key (id)
);

create table spc_category (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_spc_category primary key (id)
);

create table spc_comment (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_spc_comment primary key (id)
);

create table sys_dict (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_dict primary key (id)
);

create table sys_dict_item (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_dict_item primary key (id)
);

create table sys_group (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_group primary key (id)
);

create table sys_login_log (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  constraint pk_sys_login_log primary key (id)
);

create table sys_member (
  id                            bigint not null,
  name                          varchar(255),
  account                       varchar(255),
  password                      varchar(255),
  salt                          varchar(255),
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_member primary key (id)
);

create table sys_note (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_note primary key (id)
);

create table sys_operator_log (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  constraint pk_sys_operator_log primary key (id)
);

create table spc_page (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_spc_page primary key (id)
);

create table sys_permission (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_permission primary key (id)
);

create table sys_role (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_role primary key (id)
);

create table sys_router (
  id                            bigint not null,
  predicates                    json,
  filters                       json,
  uri                           varchar(255),
  metadata                      json,
  sorted                        integer not null,
  status                        varchar(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_router primary key (id)
);

create table sys_setting (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_setting primary key (id)
);

create table sys_todo (
  id                            bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_todo primary key (id)
);

create index ix_sys_router_sorted on sys_router (sorted);

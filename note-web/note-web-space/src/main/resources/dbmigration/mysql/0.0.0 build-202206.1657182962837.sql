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

create table sys_catalog_item (
  id                            bigint not null,
  catalog_id                    bigint not null,
  item_id                       bigint not null,
  item_type                     varchar(7) not null,
  sorted                        integer not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_catalog_item primary key (id)
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
  parent_id                     bigint not null,
  name                          varchar(255) not null,
  description                   varchar(255),
  status                        varchar(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_group primary key (id)
);

create table sys_i18n (
  id                            bigint not null,
  name                          varchar(255),
  scenes                        varchar(255) not null,
  status                        varchar(1) not null,
  is_built_in                   tinyint(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint uq_sys_i18n_name unique (name),
  constraint pk_sys_i18n primary key (id)
);

create table sys_i18n_item (
  id                            bigint not null,
  i18n_id                       bigint,
  content                       varchar(255),
  locale                        varchar(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint pk_sys_i18n_item primary key (id)
);

create table sys_login_log (
  id                            bigint not null,
  member_id                     bigint not null,
  account                       varchar(50) not null,
  login_type                    varchar(15) not null,
  logout_type                   varchar(1),
  ip_addr                       varchar(128),
  user_agent                    varchar(255),
  os                            varchar(255),
  screen                        varchar(255),
  login_time                    datetime(6) not null,
  logout_time                   datetime(6),
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  constraint pk_sys_login_log primary key (id)
);

create table sys_member (
  id                            bigint not null,
  name                          varchar(255),
  nickname                      varchar(255),
  account                       varchar(255),
  password                      varchar(255),
  salt                          varchar(255),
  group_id                      bigint,
  summary                       varchar(512),
  locked                        tinyint(1) not null,
  status                        varchar(1) not null,
  expired_time                  datetime(6) not null,
  is_built_in                   tinyint(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint uq_sys_member_account unique (account),
  constraint pk_sys_member primary key (id)
);

create table sys_member_role (
  id                            bigint not null,
  member_id                     bigint not null,
  role_id                       bigint not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  constraint pk_sys_member_role primary key (id)
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
  parent_id                     bigint not null,
  code                          varchar(255) not null,
  name                          varchar(255) not null,
  path                          longtext,
  icon                          varchar(512),
  description                   longtext,
  bind_i18n                     varchar(255),
  is_built_in                   tinyint(1) not null,
  status                        varchar(1) not null,
  sorted                        integer not null,
  type                          varchar(4) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint uq_sys_permission_code unique (code),
  constraint uq_sys_permission_name unique (name),
  constraint pk_sys_permission primary key (id)
);

create table sys_role (
  id                            bigint not null,
  code                          varchar(255) not null,
  name                          varchar(255) not null,
  sorted                        integer not null,
  description                   longtext,
  status                        varchar(1) not null,
  bind_i18n                     varchar(255),
  is_built_in                   tinyint(1) not null,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  updated_member                bigint not null,
  updated_time                  datetime(6) not null,
  constraint uq_sys_role_code unique (code),
  constraint uq_sys_role_name unique (name),
  constraint pk_sys_role primary key (id)
);

create table sys_role_permission (
  id                            bigint not null,
  role_id                       bigint,
  permission_id                 bigint,
  version                       integer not null,
  deleted                       tinyint(1) default 0 not null,
  created_member                bigint not null,
  created_time                  datetime(6) not null,
  constraint pk_sys_role_permission primary key (id)
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

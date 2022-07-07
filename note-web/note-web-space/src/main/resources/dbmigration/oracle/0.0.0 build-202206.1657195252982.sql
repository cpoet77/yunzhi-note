-- apply changes
create table spc_article (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_spc_article primary key (id)
);

create table sys_catalog (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_catalog primary key (id)
);

create table sys_catalog_item (
  id                            number(19) not null,
  catalog_id                    number(19) not null,
  item_id                       number(19) not null,
  item_type                     varchar2(7) not null,
  sorted                        number(10) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_catalog_item_item_type check ( item_type in ('note','file','todo','unknown')),
  constraint pk_sys_catalog_item primary key (id)
);

create table spc_category (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_spc_category primary key (id)
);

create table spc_comment (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_spc_comment primary key (id)
);

create table sys_dict (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_dict primary key (id)
);

create table sys_dict_item (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_dict_item primary key (id)
);

create table sys_group (
  id                            number(19) not null,
  parent_id                     number(19) not null,
  name                          varchar2(255) not null,
  description                   varchar2(255),
  status                        varchar2(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_group_status check ( status in ('0','1','2')),
  constraint pk_sys_group primary key (id)
);

create table sys_i18n (
  id                            number(19) not null,
  name                          varchar2(255),
  scenes                        varchar2(255) not null,
  status                        varchar2(1) not null,
  is_built_in                   number(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_i18n_status check ( status in ('0','1','2')),
  constraint uq_sys_i18n_name unique (name),
  constraint pk_sys_i18n primary key (id)
);

create table sys_i18n_item (
  id                            number(19) not null,
  i18n_id                       number(19),
  content                       varchar2(255),
  locale                        varchar2(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_i18n_item_locale check ( locale in ('0','1','2')),
  constraint pk_sys_i18n_item primary key (id)
);

create table sys_login_log (
  id                            number(19) not null,
  member_id                     number(19) not null,
  account                       varchar2(50) not null,
  login_type                    varchar2(15) not null,
  logout_type                   varchar2(1),
  ip_addr                       varchar2(128),
  user_agent                    varchar2(255),
  os                            varchar2(255),
  screen                        varchar2(255),
  login_time                    timestamp not null,
  logout_time                   timestamp,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  constraint ck_sys_login_log_login_type check ( login_type in ('account','mobile','email','qq-auth','wechat','wechat-mini-app','github','gitee','baidu')),
  constraint ck_sys_login_log_logout_type check ( logout_type in ('1','2','3')),
  constraint pk_sys_login_log primary key (id)
);

create table sys_member (
  id                            number(19) not null,
  name                          varchar2(255),
  nickname                      varchar2(255),
  account                       varchar2(255),
  password                      varchar2(255),
  salt                          varchar2(255),
  group_id                      number(19),
  summary                       varchar2(512),
  locked                        number(1) not null,
  status                        varchar2(1) not null,
  expired_time                  timestamp not null,
  is_built_in                   number(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_member_status check ( status in ('0','1','2')),
  constraint uq_sys_member_account unique (account),
  constraint pk_sys_member primary key (id)
);

create table sys_member_role (
  id                            number(19) not null,
  member_id                     number(19) not null,
  role_id                       number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  constraint pk_sys_member_role primary key (id)
);

create table sys_note (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_note primary key (id)
);

create table sys_operator_log (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  constraint pk_sys_operator_log primary key (id)
);

create table spc_page (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_spc_page primary key (id)
);

create table sys_permission (
  id                            number(19) not null,
  parent_id                     number(19) not null,
  code                          varchar2(255) not null,
  name                          varchar2(255) not null,
  path                          clob,
  icon                          varchar2(512),
  description                   clob,
  bind_i18n                     varchar2(255),
  is_built_in                   number(1) not null,
  status                        varchar2(1) not null,
  sorted                        number(10) not null,
  type                          varchar2(4) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_permission_status check ( status in ('0','1','2')),
  constraint ck_sys_permission_type check ( type in ('1','2','4','8','16','1024')),
  constraint uq_sys_permission_code unique (code),
  constraint pk_sys_permission primary key (id)
);

create table sys_role (
  id                            number(19) not null,
  code                          varchar2(255) not null,
  name                          varchar2(255) not null,
  sorted                        number(10) not null,
  description                   clob,
  status                        varchar2(1) not null,
  bind_i18n                     varchar2(255),
  is_built_in                   number(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_role_status check ( status in ('0','1','2')),
  constraint uq_sys_role_code unique (code),
  constraint uq_sys_role_name unique (name),
  constraint pk_sys_role primary key (id)
);

create table sys_role_permission (
  id                            number(19) not null,
  role_id                       number(19),
  permission_id                 number(19),
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  constraint pk_sys_role_permission primary key (id)
);

create table sys_router (
  id                            number(19) not null,
  predicates                    clob,
  filters                       clob,
  uri                           varchar2(255),
  metadata                      clob,
  sorted                        number(10) not null,
  status                        varchar2(1) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint ck_sys_router_status check ( status in ('0','1','2')),
  constraint pk_sys_router primary key (id)
);

create table sys_setting (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_setting primary key (id)
);

create table sys_todo (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_todo primary key (id)
);

create index ix_sys_router_sorted on sys_router (sorted);

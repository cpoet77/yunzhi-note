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
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_group primary key (id)
);

create table sys_login_log (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  constraint pk_sys_login_log primary key (id)
);

create table sys_member (
  id                            number(19) not null,
  name                          varchar2(255),
  account                       varchar2(255),
  password                      varchar2(255),
  salt                          varchar2(255),
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_member primary key (id)
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
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_permission primary key (id)
);

create table sys_role (
  id                            number(19) not null,
  version                       number(10) not null,
  deleted                       number(1) default 0 not null,
  created_member                number(19) not null,
  created_time                  timestamp not null,
  updated_member                number(19) not null,
  updated_time                  timestamp not null,
  constraint pk_sys_role primary key (id)
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

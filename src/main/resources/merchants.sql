create table merchants
(
  `id`           int(10) unsigned              not null auto_increment,
  `name`         varchar(64) collate utf8_bin  not null comment '商户名称',
  `logo_url`     varchar(256) collate utf8_bin not null comment '商户Logo',
  `business_url` varchar(256) collate utf8_bin not null comment '商户营业执照',
  `phone`        varchar(64) collate utf8_bin  not null comment '联系电话',
  `address`      varchar(64) collate utf8_bin  not null comment '地址',
  `is_audit`     boolean                       not null comment '是否通过审核',
  primary key (id)
) engine innodb
  auto_increment = 17
  default charset = utf8;
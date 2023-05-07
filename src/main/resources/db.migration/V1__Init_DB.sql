create table currency
(
    currency_id        bigint not null auto_increment,
    created_at         datetime(6),
    id                 bigint,
    name               varchar(255),
    percent_change_1h  float(53),
    percent_change_24h float(53),
    price_usd          float(53),
    symbol             varchar(255),
    primary key (currency_id)
) engine = InnoDB;
create table user
(
    id         bigint not null auto_increment,
    created_at datetime(6),
    price_usd  float(53),
    symbol     varchar(255),
    username   varchar(255),
    primary key (id)
) engine = InnoDB;

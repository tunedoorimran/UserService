drop table T_USER if exists;
create table T_USER (ID bigint identity primary key, FIRST_NAME varchar(50) not null,
                        LAST_NAME varchar(50) not null);

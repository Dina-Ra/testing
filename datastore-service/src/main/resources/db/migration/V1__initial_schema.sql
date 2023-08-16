
create table usr (
    user_id                     bigserial not null constraint usr_pk primary key,
    username                    varchar(64) not null,
    password                    varchar(64) not null,
    user_role                   varchar(64) not null
);

create table verification (
    verification_id             bigserial not null constraint verification_pk primary key,
    result                      integer,
    user_key                    bigint not null,
    createDate                  timestamp not null
);
alter table verification add foreign key (user_key) references usr;

create table subject (
    subject_id                  bigserial not null constraint subject_pk primary key,
    name                        varchar(64) not null
);

create table test (
    test_id                     bigserial not null constraint test_pk primary key,
    text                        varchar(512) not null,
    subject_key                 bigint not null
);
alter table test add foreign key (subject_key) references subject;

create table answer (
    answerId_id                 bigserial not null constraint answer_pk primary key,
    text                        varchar(512) not null ,
    point                       integer not null,
    is_true                     boolean not null,
    test_key                    bigint not null
);
alter table answer add foreign key (test_key) references test;


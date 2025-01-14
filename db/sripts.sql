CREATE SEQUENCE REQUEST_ID_SEQ AS INT MAXVALUE 999999 CYCLE;

-- drop table request_template;
create table request_template (
    REQUEST_TEMPLATE_ID int not null,
    REQUEST_TYPE varchar(255) not null,
    CREATED_BY varchar(255) not null,
    CREATION_DATE TIMESTAMP not null,
    TEMPLATE_STATUS varchar(255) not null,
    ENABLED int,
    PRIMARY KEY (REQUEST_TEMPLATE_ID)
);

-- drop table template_flow;
create table template_flow (
    REQUEST_TYPE varchar(255) not null,
    CURRENT_STATUS varchar(255) not null,
    ACTION varchar(255) not null,
    NEXT_STATUS varchar(255) not null,
    PRIMARY KEY (REQUEST_TYPE, CURRENT_STATUS, ACTION)
);



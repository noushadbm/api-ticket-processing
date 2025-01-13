create table flow_template (
    REQUEST_TYPE varchar(255) not null,
    CURRENT_STATUS varchar(255) not null,
    ACTION varchar(255) not null,
    NEXT_STATUS varchar(255) not null,
    PRIMARY KEY (REQUEST_TYPE, CURRENT_STATUS, ACTION)
);
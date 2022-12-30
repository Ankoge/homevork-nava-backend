create table picture
(
    id      bigint       not null
        primary key,
    author  varchar(255) null,
    name    varchar(255) null,
    view_id bigint       null,
    constraint FKn3t2kcypcu7xe9ox3pmib41d
        foreign key (view_id) references view (id)
);
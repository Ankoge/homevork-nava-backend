create table if not exists picture
(
    id bigint not null
    primary key
);

create table if not exists view
(
    id         bigint not null
    primary key,
    views      int    not null,
    picture_id bigint null,
    constraint FK6loqhogmadpn8rov5cxcp6idj
    foreign key (picture_id) references picture (id)
    );


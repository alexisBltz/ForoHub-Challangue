create table topico(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    fechaCreacion date not null,
    estadoTopico varchar(100) not null,
    autor varchar(100) not null unique,
    curso varchar(100) not null,

    primary key(id)
);
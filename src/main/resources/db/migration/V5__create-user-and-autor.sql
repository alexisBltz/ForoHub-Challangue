alter table topicos change autor autor_id bigint not null;

create table usuarios(
    id bigint not null auto_increment,
    user_name varchar(100) not null,
    clave varchar(300) not null unique,
    nombre varchar(100) not null,
    apellidoPaterno varchar(100) not null,
    apellidoMaterno varchar(100) not null,
    documento varchar(100) not null,

    primary key(id)
);

ALTER TABLE topicos ADD CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES usuarios(id);
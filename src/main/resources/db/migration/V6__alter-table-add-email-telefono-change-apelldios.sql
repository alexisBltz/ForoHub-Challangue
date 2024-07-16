alter table usuarios change apellidoPaterno apellido_paterno varchar(100);
alter table usuarios change apellidoMaterno apellido_materno varchar(100);

alter table usuarios add telefono varchar(20) not null;
alter table usuarios add email varchar(100) not null;
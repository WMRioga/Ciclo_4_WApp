create database C4_G21_Banca_Essence;
use C4_G21_Banca_Essence;
# -- show databases; -- sirve para ver cuantas bases de datos hay en mi MySQL
# -- create table -- creamos la tabla rol
create table Clientes(
	id_cliente varchar(15) not null,
    usser_cliente varchar(45) not null,
    passwd_cliente varchar(10) not null,
    constraint Clientes_pk primary key (id_cliente)
);
create table Cuentas(
	idCuenta varchar(15) not null,
	fechaApertura date not null,
	saldoCuenta double not null,
	id_cliente varchar(15) not null,
	constraint Cuentas_pk primary key(idCuenta),
	constraint Cuentas_idCliente_fk foreign key (id_cliente) references Clientes(id_cliente)
);
create table Transacciones(
	idTransaccion int auto_increment not null,
    fechaTransaccion date not null,
    valorTransaccion double not null,
    tipoTransaccion varchar(01) not null,
    idCuenta varchar(15) not null,
    constraint Transacciones_pk primary key (idTransaccion),
    constraint Transacciones_idCuenta_fk foreign key (idCuenta) references Cuentas(idCuenta),
    constraint Transacciones_tipoTransaccion_ch check (tipoTransaccion='D' or tipoTransaccion='R')
);
create table Adminisrtadores(
	idAdmon int auto_increment not null,
    usserAdmon varchar(45) not null,
    passwdAdmon varchar(10) not null,
    constraint Adminisrtadores_pk primary key (idAdmon)
);
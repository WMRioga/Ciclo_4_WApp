create database C4_G21_Banca_Essence;
use C4_G21_Banca_Essence;
# -- show databases; -- sirve para ver cuantas bases de datos hay en mi MySQL
# -- create table -- creamos la tabla rol
create table Clientes(
	idCliente varchar(15) not null,
    usserCliente varchar(45) not null,
    passwdCliente varchar(10) not null,
    constraint Clientes_pk primary key (idCliente)
);
create table Cuentas(
	idCuenta varchar(15) not null,
	fechaApertura date not null,
	saldoCuenta double not null,
	idCliente varchar(15) not null,
	constraint Cuentas_pk primary key(idCuenta),
	constraint Cuentas_idCliente_fk foreign key (idCliente) references Clientes(idCliente)
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
insert into Clientes(idCliente,usserCliente,passwdCliente) values('1','SergioMedina','123456');
insert into Clientes(idCliente,usserCliente,passwdCliente) values('2','LuisaLane','654321');
insert into Cuentas(idCuenta,fechaApertura,saldoCuenta,idCliente) values('01-01','2021-06-10',100000,'1');
insert into Cuentas(idCuenta,fechaApertura,saldoCuenta,idCliente) values('02-02','2022-05-15',500000,'1');
insert into Cuentas(idCuenta,fechaApertura,saldoCuenta,idCliente) values('03-03','2022-01-25',750000,'2');
insert into Transacciones(fechaTransaccion,valorTransaccion,tipoTransaccion,idCuenta) values('2022-02-20',100000,'D','01-01');
insert into Transacciones(fechaTransaccion,valorTransaccion,tipoTransaccion,idCuenta) values('2022-07-20',100000,'R','02-02');
insert into Adminisrtadores(usserAdmon,passwdAdmon) values('AdministradorGeneral','123456');

select * from Clientes;
select * from Cuentas;
select * from Transacciones;
select * from Adminisrtadores;
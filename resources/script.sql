create database crud;

	create table crud(
	
	id int not null auto_increment primary key,
	cpf varchar (11),
	nome varchar (40),
	sexo char,
	idade int,
	hobby varchar (99),
	datanascimento varchar(99))
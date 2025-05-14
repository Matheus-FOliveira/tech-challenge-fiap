create table cliente(
id int NOT NULL AUTO_INCREMENT,
nome varchar(255),
email varchar(255) unique,
login varchar(255) unique,
senha varchar(255),
dataAlteracao date,
endereco varchar(255),
PRIMARY KEY (id)
);

insert into cliente VALUES
(null, 'Matheus', 'matheus@fiap.com', 'aluno123', 'senha_forte', CURRENT_DATE(), 'rua exemplo da silva 123')
;
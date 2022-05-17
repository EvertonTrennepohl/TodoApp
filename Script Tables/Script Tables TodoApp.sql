use todoapp;

DROP TABLE IF EXISTS tarefas;

DROP TABLE IF EXISTS projetos;

CREATE TABLE projetos (
    id_projeto int not null auto_increment,
    nome varchar (100) not null,
    descricao varchar(1000) not null,
    data_criacao datetime not null,
    data_atualizacao datetime not null,   
    constraint projetos_pk primary key (id_projeto)
);

CREATE TABLE tarefas (
    id_tarefa int not null auto_increment,
    id_projeto int not null,
    nome varchar (100) not null,
    descricao varchar (1000) not null,
    status boolean not null,
    observacoes varchar (500),
    prazo datetime not null,
    data_criacao datetime not null,
    data_atualizacao datetime,
    constraint tarefas_pk primary key (id_tarefa)
    );
alter table tarefas add constraint projetos_fk1 foreign key (id_projeto) references projetos (id_projeto) on delete cascade;


'Creazione Database:'
CREATE DATABASE "DBTartarughe"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "DBTartarughe"
    IS 'Questo database è usato per conservare e manipolare i dati di alcune tartarughe marine, monitorarle, rilasciarle e tenere traccia di vari indici statistici sui loro parametri vitali.
Parte del progetto "CARTELLA MEDICA DI TARTARUGHE MARINE" assegnato dall''Università degli Studi di Napoli Federico II';

'smallserial sta ad indicare un auto increment (presente in MySQL)'
create table Tartaruga (
	id BigSerial primary key,
	targa Varchar(50) not null 
	nome VARCHAR(50) not null,
	primoAccesso VARCHAR(50) not null,
	morta VARCHAR(50) not null,
	rilasciata VARCHAR(50) not null
);

alter table tartaruga 
drop constraint tartaruga_pkey cascade;

alter table cartellamedica
drop tartarugatarga;

alter table presaincarico
drop idtartaruga;

alter table tartaruga 
add column id bigserial primary key;

alter table tartaruga 
alter column targa SET DATA TYPE VARCHAR(50);

alter table cartellamedica
add column tartarugaid bigserial,
add constraint fk_id_tartaruga foreign key (tartarugaid) references tartaruga(id);

alter table presaincarico
add column tartarugaid bigserial,
add constraint fk_id_tartaruga foreign key (tartarugaid) references tartaruga(id);

create table Vasca (
	id bigserial primary key,
	grandezza int4 not null,
	capienzaMassima int8 not null,
	piena boolean not null
);

CREATE TYPE tipoCibo AS ENUM ('pesce', 'gamberetti', 'alici', 'vegetali');

create table Cibo (
	id smallserial primary key,
	tipo tipoCibo not null,
	kgDato INT,
	kgMangiati INT,
	vascaid bigserial
);


drop table cibovasca cascade;

alter table cibo
add column vascaid bigserial,
add constraint fk_id_vasca foreign key (vascaid) references vasca(id);

create table Centro (
	id bigserial primary key,
	citta VARCHAR(50) not null,
	nomeCentro VARCHAR(50) not null
);

CREATE TYPE ruolo AS ENUM ('Medico', 'Ricercatore', 'Tecnico', 'Operatore');

create table Personale (
	matricola bigserial primary key,
	nome VARCHAR(50) not null,
	cognome VARCHAR(50) not null,
	professione ruolo not null,
	password VARCHAR(50) not null
);

create type valutazione as enum ('Compromesso', 'Con ferite profonde', 'Con ferite superficiali', 'Buona', 'Perfetta');
//per la funzionalità del programma, è necessario che la prima lettera del valore di valutazione sia maiuscola, controllate
//sia cosi, altrimenti usate il seguente comando con annesso esempi, per ognuno dei valori
ALTER TYPE valutazione RENAME VALUE 'con ferite profonde' TO 'Con ferite profonde';

create table CartellaMedica (
	id bigserial primary key,
	dataApertura DATE not null,
	dataChiusura DATE,
	dataRitrovamento DATE not null,
	peso INT not null,
	larghezza INT not null,
	lunghezza INT not null,
	specie VARCHAR(50) not null,
	sesso VARCHAR(50) not null,
	descrizione VARCHAR(50),
	testa valutazione not null,
	pinne valutazione not null,
	occhi valutazione not null,
	naso valutazione not null, 
	becco valutazione not null,
	collo valutazione not null,
	coda valutazione not null
);

ALTER TABLE tartaruga ADD COLUMN IF NOT EXISTS vascaId bigserial;

ALTER table tartaruga add CONSTRAINT fk_id_vasca FOREIGN KEY (vascaId) REFERENCES vasca (id);


ALTER TABLE tartaruga ADD COLUMN IF NOT EXISTS centroId bigserial;

ALTER table tartaruga add CONSTRAINT fk_id_centro FOREIGN KEY (centroId) REFERENCES centro (id);

ALTER TABLE personale ADD COLUMN IF NOT EXISTS centroId bigserial;

ALTER table personale add CONSTRAINT fk_id_centro FOREIGN KEY (centroId) REFERENCES centro (id);

ALTER TABLE cartellamedica ADD COLUMN IF NOT EXISTS personaleId bigserial;

ALTER table cartellamedica add CONSTRAINT fk_id_personale FOREIGN KEY (personaleId) REFERENCES personale (matricola);

ALter table cartellamedica ADD COLUMN IF NOT EXISTS tartarugaid bigserial;

ALter table cartellamedica add CONSTRAINT fk_id_tartaruga FOREIGN KEY (tartarugaid) REFERENCES tartaruga (id)


create table PresaInCarico(
	idPersonale bigserial ,
	idTartaruga bigserial
);
ALTER table PresaInCarico add CONSTRAINT fk_id_personale FOREIGN KEY (idPersonale) REFERENCES personale (matricola);
ALTER table PresaInCarico add CONSTRAINT fk_id_tartaruga FOREIGN KEY (idTartaruga) REFERENCES tartaruga (id);

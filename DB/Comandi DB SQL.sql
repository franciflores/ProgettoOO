

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
	targa BigSerial primary key,
	nome VARCHAR(50) not null,
	primoAccesso VARCHAR(50) not null,
	morta VARCHAR(50) not null,
	rilasciata VARCHAR(50) not null
);

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
	kgMangiati INT
);

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
	professione ruolo not null
);

create type valutazione as enum ('compromesso', 'con ferite profonde', 'con ferite superficiali', 'buona', 'perfetta');

create table CartellaMedica (
	id bigserial primary key,
	dataApertura DATE not null,
	dataChiusura DATE,
	dataRitrovamento DATE not null,
	peso INT not null,
	larghezza INT not null,
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

ALTER TABLE tartaruga ADD COLUMN IF NOT EXISTS cartellaId bigserial;

ALTER table tartaruga add CONSTRAINT fk_id_cartella FOREIGN KEY (cartellaId) REFERENCES cartellaMedica (id);

ALTER TABLE tartaruga ADD COLUMN IF NOT EXISTS centroId bigserial;

ALTER table tartaruga add CONSTRAINT fk_id_centro FOREIGN KEY (centroId) REFERENCES centro (id);

ALTER TABLE personale ADD COLUMN IF NOT EXISTS centroId bigserial;

ALTER table personale add CONSTRAINT fk_id_centro FOREIGN KEY (centroId) REFERENCES centro (id);

ALTER TABLE cartellamedica ADD COLUMN IF NOT EXISTS personaleId bigserial;

ALTER table cartellamedica add CONSTRAINT fk_id_personale FOREIGN KEY (personaleId) REFERENCES personale (matricola);

create table CiboVasca(
	idVasca bigserial ,
	idTipo smallserial
);

ALTER table cibovasca add CONSTRAINT fk_id_vasca FOREIGN KEY (idvasca) REFERENCES vasca (id);
ALTER table cibovasca add CONSTRAINT fk_id_tipo FOREIGN KEY (idtipo) REFERENCES cibo (id);

create table PresaInCarico(
	idPersonale bigserial ,
	idTartaruga bigserial
);
ALTER table PresaInCarico add CONSTRAINT fk_id_personale FOREIGN KEY (idPersonale) REFERENCES personale (matricola);
ALTER table PresaInCarico add CONSTRAINT fk_id_tartaruga FOREIGN KEY (idTartaruga) REFERENCES tartaruga (targa);
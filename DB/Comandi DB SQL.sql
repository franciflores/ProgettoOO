

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
CREATE TABLE Tartarughe(
	IDTartaruga smallserial primary key not null,
	nomeTartaruga varchar(30) not null
);
--DATABASE Museo
--n.b. potrebbe contenere errori di sintassi (da verificare in oracle db)

--Tabella Museo
CREATE TABLE Museo
(
	CodiceM VARCHAR(10) NOT NULL,
	Denominazione VARCHAR(70) NOT NULL,
	Direttore VARCHAR(30) NOT NULL,
	IndirizzoM VARCHAR(50) NOT NULL,
	CittaM VARCHAR(20) NOT NULL,
	CapM VARCHAR(5) NOT NULL,
	EmailM VARCHAR(50) NOT NULL,
	SitoWeb VARCHAR(50) NOT NULL,
	NoteM VARCHAR(70),
	
	PRIMARY KEY (CodiceM)
) 

--Tabella Evento
CREATE TABLE Evento
(
	CodiceE VARCHAR(10) NOT NULL,
	Tipo VARCHAR(30) NOT NULL,
	TitoloE VARCHAR(70) NOT NULL,
	TariffaO DECIMAL(6,2) NOT NULL,
	DataInizio DATE,
	DataFine DATE,
	DescrizioneEv VARCHAR(70),
	CodiceM1 VARCHAR(10) NOT NULL,
	
	PRIMARY KEY (CodiceE),
	FOREIGN KEY (CodiceM1) REFERENCES Museo (CodiceM)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	CHECK (Tipo IN ('Visita','EsposizioneTematica')), 
	CHECK (TariffaO > 0), 
	CHECK (DataInizio <= DataFine) 
) 

--Tabella Categoria
CREATE TABLE Categoria
(
	CodiceC VARCHAR(10) NOT NULL,
	DescrizioneC VARCHAR(30) NOT NULL,
	TipoDocumento VARCHAR(30) NOT NULL,
	Sconto INT(3) NOT NULL,

	PRIMARY KEY (CodiceC),
	CHECK (Sconto BETWEEN 0 AND 100), 
	CHECK (DescrizioneC IN ('Base','Bambini','18app',
	'Over-70','NonVedenti','Invalidi','Altra')), 
	CHECK (TipoDocumento IN ('CartaIdentita','Certificato','Patente',
	'TesseraSpeciale','CodiceFiscale','Attestato','Buono')) 
) 

--Tabella Servizio 
CREATE TABLE Servizio
(
	CodiceS VARCHAR(10) NOT NULL,
	TipologiaS VARCHAR(30) NOT NULL,
	DescrizioneS VARCHAR(30) NOT NULL,
	PrezzoS DECIMAL(6,2) NOT NULL,
	
	PRIMARY KEY (CodiceS),
	CHECK (TipologiaS IN ('ServizioPersonale','ProdottoAccessorio')),
	CHECK (DescrizioneS IN ('InterpretePersonale','Audioguida',
	'AccompagnatorePersonalizzato','CatalogoOpere','MappaMuseo')), 
	CHECK (PrezzoS > 0) 
) 

--Tabella Visitatore
CREATE TABLE Visitatore
(
	CodiceV VARCHAR(10) NOT NULL,
	Cognome VARCHAR(50) NOT NULL,
	Nome VARCHAR(50) NOT NULL,
	DataN DATE NOT NULL,
	IndirizzoV VARCHAR(50) NOT NULL,
	CittàV VARCHAR(20) NOT NULL,
	CapV VARCHAR(5) NOT NULL,
	Cell VARCHAR(20) NOT NULL,
	Email VARCHAR(70) NOT NULL,
	Password VARCHAR(16) NOT NULL,
	NcartaCredito VARCHAR(16) NOT NULL,
	Titolare VARCHAR(50) NOT NULL,
	AnnoS YEAR(4) NOT NULL,
	MeseS VARCHAR(2) NOT NULL,
	CVV VARCHAR(4) NOT NULL,
	Nazionalita VARCHAR(20) NOT NULL,
	CodiceC1 VARCHAR(10) NOT NULL,
	
	PRIMARY KEY (CodiceV),
	FOREIGN KEY (CodiceC1) REFERENCES Categoria (CodiceC)
	ON UPDATE CASCADE
	ON DELETE CASCADE
) 

--Tabella Biglietto
CREATE TABLE Biglietto
(
	CodiceB VARCHAR(10) NOT NULL,
	TipologiaB VARCHAR(20) NOT NULL,
	DataVal DATE NOT NULL,
	TitoloB VARCHAR(70) NOT NULL,
	NoteB VARCHAR(70),
	DataA DATE,
	OraA TIME,
	CodiceE1 VARCHAR(10) NOT NULL,
	CodiceV1 VARCHAR(10),
	
	PRIMARY KEY (CodiceB),
	FOREIGN KEY (CodiceE1) REFERENCES Evento (CodiceE)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	FOREIGN KEY (CodiceV1) REFERENCES Visitatore (CodiceV)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	CHECK (TipologiaB IN ('Base','Speciale')), 
	CHECK (DataA <= DataVal) 
)

--Tabella Include
CREATE TABLE Include
(
	CodiceB1 VARCHAR(10) NOT NULL,
	CodiceS1 VARCHAR(10) NOT NULL,

	PRIMARY KEY (CodiceB1, CodiceS1),
	FOREIGN KEY (CodiceS1) REFERENCES Servizio (CodiceS)
	ON UPDATE CASCADE
	ON DELETE CASCADE,
	FOREIGN KEY (CodiceB1) REFERENCES Biglietto (CodiceB)
	ON UPDATE CASCADE
	ON DELETE CASCADE
)

--VdI Interrelazionali

CREATE ASSERTION VDI8 CHECK ((Biglietto.DataVal >= Evento.DataInizio) AND
(Biglietto.DataVal <= Evento.DataFine)); 

CREATE ASSERTION VDI14 CHECK (Visitatore.DataN < Biglietto.DataA); 

--Trigger sulla tabella Evento per la gestione dell’attributo “Tipo” 
--DELIMITER //
CREATE TRIGGER trg1
BEFORE INSERT ON biglietteria.Evento
FOR EACH ROW
BEGIN
IF NEW.Tipo LIKE 'Visita'
THEN
SET NEW.DataInizio = NULL;
SET NEW.DataFine = NULL;
END IF;
END 
--//
--DELIMITER ;


--Istruzioni linguaggio DML (Data manipulation language) per inserimento dati nelle tabelle

--Tabella Museo
INSERT INTO Museo
VALUES('M1','Museo nazionale di Capodimonte','Sylvain Bellenger','Via Miano,
2','Napoli','80131','mbacmucap@mailcert.beniculturali.it','www.museocapodimonte
.beniculturali.it','Fondato da Bruno Molajoli nel 1957');

--Tabella Evento
INSERT INTO Evento
VALUES('E1','EsposizioneTematica','Luca Giordano. Dalla Natura alla
pittura','20.00','2020-01-20','2020-06-01','Le tele più belle e famose di Luca
Giordano','M1');

INSERT INTO Evento
VALUES('E2','Visita','Visita appartamento storico','14.00','','','Dettagli
appartamento','M1');

INSERT INTO Evento
VALUES('E3','EsposizioneTematica','Depositi di Capodimonte. Storie ancora da
scrivere','30.00','2019-01-20','2019-10-15','Sono state esposte 1220 opere
provenienti dai depositi di Capodimonte','M1');

--Tabella Categoria
INSERT INTO Categoria
VALUES('C1','Bambini','CartaIdentita','50');

INSERT INTO Categoria
VALUES('C2','Invalidi','Certificato','100');

INSERT INTO Categoria
VALUES('C3','Over-70','CartaIdentita','40');

INSERT INTO Categoria
VALUES('C4','Base','CartaIdentita','0');

INSERT INTO Categoria
VALUES('C5','18app','Buono','100');

--Tabella Servizio
INSERT INTO Servizio
VALUES('S1','ServizioPersonale','AccompagnatorePersonalizzato','20.00');

INSERT INTO Servizio
VALUES('S2','ServizioPersonale','InterpretePersonale','50.00');

INSERT INTO Servizio
VALUES('S3','ProdottoAccessorio','Audioguida','10.00');

INSERT INTO Servizio
VALUES('S4','ProdottoAccessorio','CatalogoOpere','5.50');

--Tabella Visitatore
INSERT INTO Visitatore
VALUES('V1','Rossi','Mario','1948-05-03','Via Napoli,
15','Pozzuoli','80078','3516679123','rossimario@gmail.com','pwmariorossi','51542756504
38659','Mario Rossi','2022','03','788','Italiana','C3');

INSERT INTO Visitatore
VALUES('V2','Smith','Silvia','1959-03-12','Via Roma,
12','Napoli','80100','3493379321','silviasmith@gmail.com','pwsmithsilvia','40832129048
75336','Silvia Smith','2023','05','111','Inglese','C2');

INSERT INTO Visitatore
VALUES('V3','Neri','Vincenzo','1980-04-22','Via Toledo,
32','Napoli','80100','3396655123','vincenzoneri@outlook.com','pwneri','530228751736871
5','Vincenzo Neri','2025','01','321','Italiana','C4');

INSERT INTO Visitatore
VALUES('V4','Verdi','Maria','1999-07-20','Via Caracciolo,
22','Napoli','80100','3314569871','verdimaria@outlook.com','pwverdimaria','55979944601
41783','Verdi Maria','2022','06','373','Italiana','C4');

INSERT INTO Visitatore
VALUES('V5','Marrone','Luigi','1987-05-12','Via Flaminia,
16','Roma','00196','3518899456','luigimarr@gmail.com','pwluigimarr','4067739656023194'
,'Marrone Luigi','2026','02','732','Italiana','C4');

--Tabella Biglietto
INSERT INTO Biglietto
VALUES('B1','Speciale','2019-07-12','Museo di Capodimonte - Esposizione
depositi','Categoria Over-70. Include servizio aggiuntivo','2019-07-
06','20:07:32','E3','V1');

INSERT INTO Biglietto
VALUES('B2','Speciale','2019-09-10','Museo di Capodimonte - Esposizione
depositi','Categoria Invalidi. Include servizio aggiuntivo','2019-09-
02','15:03:21','E3','V2');

INSERT INTO Biglietto
VALUES('B3','Speciale','2020-02-10','Museo di Capodimonte - Esposizione Luca
Giordano','Categoria Base','2020-02-05','18:35:04','E1','V3');

INSERT INTO Biglietto
VALUES('B4','Speciale','2020-03-12','Museo di Capodimonte - Esposizione Luca
Giordano','Categoria Base','2020-03-07','20:15:11','E1','V4');

INSERT INTO Biglietto
VALUES('B5','Base','2020-05-16','Museo di Capodimonte - Visita appartamento
storico','Categoria Base. Include servizio aggiuntivo','2020-05-
15','09:22:44','E2','V5');

--Tabella Include
INSERT INTO Include
VALUES('B1','S4');

INSERT INTO Include
VALUES('B2','S2');

INSERT INTO Include
VALUES('B5','S3');
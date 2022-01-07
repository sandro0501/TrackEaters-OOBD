-- POPOLAMENTO TABELLE DEL DB 
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella PROPRIETARIO: aggiunge il proprietario dei ristoranti.
INSERT INTO PROPRIETARIO (CodProprietario, Username, Password, Nome, Cognome, Email)
VALUES (1,'sandro05','password00','Santolo','Barretta','santolobarretta05@gmail.com');
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella RISTORANTE: aggiunge i ristoranti amministrati da un proprietario.
INSERT INTO RISTORANTE (CodRistorante, Denominazione, Indirizzo, Telefono, Citta, Prov, Cap, Email, SitoWeb, Proprietario)
VALUES (1,'Bella Napoli','Via Francesco Caracciolo, 1','0813509900','Napoli','NA','80122','bellanapoli@gmail.com','www.ristorantebellanapoli.it',1);

INSERT INTO RISTORANTE (CodRistorante, Denominazione, Indirizzo, Telefono, Citta, Prov, Cap, Email, SitoWeb, Proprietario)
VALUES (2,'Bella Napoli 2','Via Toledo, 30','0813339900','Napoli','NA','80134','bellanapoli@gmail.com','www.ristorantebellanapoli.it',1);

INSERT INTO RISTORANTE (CodRistorante, Denominazione, Indirizzo, Telefono, Citta, Prov, Cap, Proprietario)
VALUES (3,'La Madonnina','Via Alessandro Manzoni, 5','+390289091122','Milano','MI','20121',1);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella MANAGERRISTORANTE: aggiunge i manager che gestiscono un ristorante, se previsti.
INSERT INTO MANAGERRISTORANTE (CodManager, Username, Password, Nome, Cognome, Email, Telefono, RistoranteGestito)
VALUES (1,'angelo02','qwerty0123','Angelo','Di Maio','angelodimaio@gmail.com','+393337060999',2);

INSERT INTO MANAGERRISTORANTE (CodManager, Username, Password, Nome, Cognome, Telefono, RistoranteGestito)
VALUES (2,'mariorossi33','mr123456','Mario','Rossi','+393517799111',3);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella SALA: aggiunge le sale ai relativi ristoranti cui appartengono.
INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (1,'Sala Pulcinella',50,100,'Interna',1);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (2,'Sala Vesuvio',20,60,'Interna',1);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (3,'Sala Garden',10,30,'Esterna',1);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (4,'Sala Maradona',50,100,'Interna',2);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (5,'Sala Partenope',18,25,'Interna',2);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (6,'Sala Duomo',30,80,'Interna',3);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (7,'Sala Meneghino',30,80,'Interna',3);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (8,'Sala Biscione',20,60,'Interna',3);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (9,'Sala Exclusive',10,20,'Esterna',3);

INSERT INTO SALA (CodSala, Denominazione, CapienzaAvventori, DimensioneMq, TipoSala, Ristorante)
VALUES (10,'Sala Vip',10,NULL,'Esterna',3);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
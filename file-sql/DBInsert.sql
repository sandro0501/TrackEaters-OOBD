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
-- Insert per la tabella CAMERIERE: aggiunge i camerieri ai rispettivi ristoranti per cui lavorano.
INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA78432DB','Ciro','Esposito',TO_DATE('08/01/2000','dd/mm/yyyy'),'Maschio','Napoli','NA','Qualiano','NA','3517486042','ciroespo@gmail.com',1);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA66421DA','Andrea','Russo',TO_DATE('10/10/1990','dd/mm/yyyy'),'Maschio','Villaricca','NA','Quarto','NA','3591676343','andrearusso@outlook.it',1);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('AU0199811','Maria','De Rosa',TO_DATE('22/03/1989','dd/mm/yyyy'),'Femmina','Pozzuoli','NA','Napoli','NA','3722282194','mariaderosa@gmail.com',1);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA64321CE','Rosaria','Romano',TO_DATE('30/08/1993','dd/mm/yyyy'),'Femmina','Napoli','NA','Napoli','NA','3218505681','romano01@gmail.com',1);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('AU3425442','Pasquale','Riccio',TO_DATE('12/04/1988','dd/mm/yyyy'),'Maschio','Caserta','CE','Casoria','NA','3273256337','ricciopas22@outlook.it',1);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA53216BE','Gabriele','Marino',TO_DATE('21/02/1993','dd/mm/yyyy'),'Maschio','Napoli','NA','Pozzuoli','NA','3553493696','marino0@gmail.com',2);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA73121FE','Salvatore','Neri',TO_DATE('12/03/1996','dd/mm/yyyy'),'Maschio','Napoli','NA','Bacoli','NA','3215642156','sasineri11@gmail.com',2);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('AU0567231','Luisa','Esposito',TO_DATE('08/01/2000','dd/mm/yyyy'),'Femmina','Napoli','NA','Quarto','NA','3445768683','espolui0@outlook.com',2);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA52131PV','Carmen','Granata',TO_DATE('28/05/1995','dd/mm/yyyy'),'Femmina','Marcianise','CE','Pozzuoli','NA','3830046533','carmen233@gmail.com',2);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA87452TB','Laura','Galli',TO_DATE('17/11/1999','dd/mm/yyyy'),'Femmina','Milano','MI','Legnano','MI','3746409289','lauragalli56@gmail.com',3);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA33145OD','Sara','Sala',TO_DATE('13/12/2000','dd/mm/yyyy'),'Femmina','Milano','MI','Sesto San Giovanni','MI','3227317200','sara123@gmail.com',3);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('AU0236754','Fiorella','Bianchi',TO_DATE('25/10/1990','dd/mm/yyyy'),'Femmina','Milano','MI','Rho','MI','3229731501','bianchi0@outlook.com',3);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA10946DE','Raffaele','Fontana',TO_DATE('04/09/1994','dd/mm/yyyy'),'Maschio','Milano','MI','Legnano','MI','3619439924','raffaele444@gmail.com',3);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA33241OA','Achille','Rinaldi',TO_DATE('21/05/1987','dd/mm/yyyy'),'Maschio','Milano','MI','Milano','MI','3283664283','achillerinaldi2@gmail.com',3);

INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante)
VALUES ('CA13264UI','Morena','Costa',TO_DATE('19/03/1999','dd/mm/yyyy'),'Femmina','Milano','MI','Assago','MI','3194130484','morena43@outlook.com',3);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/




































/*============================================================================================*/
/*============================================================================================*/





















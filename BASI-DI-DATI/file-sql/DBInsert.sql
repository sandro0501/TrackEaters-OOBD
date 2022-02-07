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
-- Insert per la tabella TAVOLO
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (1, 10, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (2, 5, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (3, 5, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (4, 2, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (5, 2, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (6, 2, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (7, 2, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (8, 2, 1);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (9, 20, 1);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (10, 5, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (11, 5, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (12, 2, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (13, 2, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (14, 2, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (15, 2, 2);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (16, 2, 2);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (17, 2, 3);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (18, 2, 3);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (19, 2, 3);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (20, 2, 3);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (21, 2, 3);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (22, 10, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (23, 5, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (24, 5, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (25, 2, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (26, 2, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (27, 2, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (28, 2, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (29, 2, 4);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (30, 20, 4);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (31, 2, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (32, 2, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (33, 4, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (34, 2, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (35, 2, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (36, 2, 5);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (37, 4, 5);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (38, 10, 6);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (39, 5, 6);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (40, 5, 6);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (41, 10, 6);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (42, 10, 7);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (43, 5, 7);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (44, 5, 7);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (45, 10, 7);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (46, 5, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (47, 5, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (48, 2, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (49, 2, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (50, 2, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (51, 2, 8);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (52, 2, 8);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (53, 2, 9);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (54, 2, 9);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (55, 2, 9);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (56, 2, 9);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (57, 2, 9);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (58, 2, 10);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (59, 2, 10);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (60, 2, 10);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (61, 2, 10);
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala) VALUES (62, 2, 10);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella ADIACENZATAVOLO 
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (1, 2);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (1, 4);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (2, 1);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (2, 5);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (2, 3);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (3, 2);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (3, 6);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (4, 1);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (4, 5);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (4, 7);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (5, 4);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (5, 2);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (5, 6);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (5, 8);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (6, 3);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (6, 5);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (6, 9);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (7, 4);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (7, 8);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (8, 7);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (8, 5);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (8, 9);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (9, 8);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (9, 6);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (10, 13);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (10, 11);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (11, 14);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (11, 12);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (12, 11);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (12, 15);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (13, 10);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (13, 14);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (14, 11);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (14, 15);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (15, 12);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (15, 16);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (16, 15);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (17, 18);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (17, 19);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (18, 17);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (18, 20);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (19, 17);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (19, 20);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (19, 21);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (20, 18);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (20, 19);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (21, 19);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (22, 23);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (22, 25);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (23, 22);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (23, 26);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (23, 24);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (24, 23);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (24, 27);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (25, 22);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (25, 26);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (25, 30);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (26, 25);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (26, 23);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (26, 27);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (27, 26);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (27, 24);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (27, 28);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (28, 27);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (28, 29);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (30, 25);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (31, 32);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (31, 34);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (32, 31);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (32, 35);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (32, 33);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (33, 32);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (33, 36);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (34, 31);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (34, 35);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (35, 34);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (35, 32);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (35, 36);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (36, 37);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (36, 35);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (36, 33);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (37, 36);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (38, 39);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (39, 38);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (39, 40);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (39, 41);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (40, 39);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (41, 39);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (42, 43);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (43, 42);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (43, 44);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (43, 45);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (44, 43);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (45, 43);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (46, 47);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (46, 48);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (47, 46);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (47, 49);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (48, 46);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (48, 49);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (49, 48);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (49, 47);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (49, 50);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (50, 49);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (50, 51);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (51, 50);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (51, 52);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (52, 51);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (53, 54);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (53, 55);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (54, 53);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (54, 56);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (55, 53);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (55, 56);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (55, 57);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (56, 54);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (56, 55);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (57, 55);

INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (58, 59);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (58, 60);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (59, 58);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (59, 61);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (60, 58);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (60, 61);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (60, 62);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (61, 60);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (61, 59);
INSERT INTO ADIACENZATAVOLO (Tavolo, TavoloAdiacente) VALUES (62, 60);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella TAVOLATA
INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (1, TO_DATE('17/11/2021','dd/mm/yyyy'),4,'CA78432DB');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (2, TO_DATE('17/11/2021','dd/mm/yyyy'),5,'CA66421DA');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (3, TO_DATE('18/11/2021','dd/mm/yyyy'),12,'AU0199811');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (4, TO_DATE('18/11/2021','dd/mm/yyyy'),13,'CA64321CE');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (5, TO_DATE('19/11/2021','dd/mm/yyyy'),18,'AU3425442');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (6, TO_DATE('20/11/2021','dd/mm/yyyy'),8,'CA78432DB');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (7, TO_DATE('20/11/2021','dd/mm/yyyy'),25,'CA53216BE');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (8, TO_DATE('22/11/2021','dd/mm/yyyy'),26,'CA73121FE');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (9, TO_DATE('22/11/2021','dd/mm/yyyy'),27,'AU0567231');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (10, TO_DATE('25/11/2021','dd/mm/yyyy'),37,'CA52131PV');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (11, TO_DATE('19/12/2021','dd/mm/yyyy'),26,'CA53216BE');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (12, TO_DATE('20/12/2021','dd/mm/yyyy'),39,'CA87452TB');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (13, TO_DATE('20/12/2021','dd/mm/yyyy'),49,'CA33145OD');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (14, TO_DATE('24/12/2021','dd/mm/yyyy'),50,'AU0236754');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (15, TO_DATE('25/12/2021','dd/mm/yyyy'),53,'CA10946DE');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (16,TO_DATE('25/01/2022','dd/mm/yyyy'),55,'CA33241OA');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (17,TO_DATE('25/01/2022','dd/mm/yyyy'),62,'CA13264UI');

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere) VALUES (18,TO_DATE('25/01/2022','dd/mm/yyyy'),50,'CA13264UI');
COMMIT;
/*===========================================================================================*/
/*===========================================================================================*/
-- Insert per la tabella AVVENTORE
INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('IC3159530','Baldassarre','Pinto',TO_DATE('04/06/1953','dd/mm/yyyy'),'Maschio','Napoli','NA','Napoli','NA','+393493302038','baldassareepinto@gmail.com',35.8,'V',1,1);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('PW824173','Filiberto','Milano',TO_DATE('19/11/1940','dd/mm/yyyy'),'Maschio','Napoli','NA','Napoli','NA','+393598741558','filibertomilano@outlook.com',36.8,'V',1,1);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('WF1996739','Felicita','Piazza',TO_DATE('16/06/1973','dd/mm/yyyy'),'Femmina','Vindoli','RN','Vindoli','RN','+393658942018','felicitaPiazza3@libero.it',36.9,'V',1,2);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('SU2810531','Lea','Barese',TO_DATE('26/07/1985','dd/mm/yyyy'),'Femmina','Cino','SO','Caivano','NA','+393259847862','leaBarese26@gmail.com',36.5,'V',1,2);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('BD8518049','Nazzareno','Onio',TO_DATE('07/12/2001','dd/mm/yyyy'),'Maschio','Badia','VV','Marcianise','CE','+393517788436','nazaon2001@outlook.it',37.0,'V',1,3);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('KT5802431','Edoardo','Ricci',TO_DATE('29/01/2002','dd/mm/yyyy'),'Maschio','Perticani','PG','Benevento','BN','+393254159687','edoRich@libero.it',36.4,'V',1,3);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('WI0726870','Prospero','Padovesi',TO_DATE('24/04/1963','dd/mm/yyyy'),'Maschio','Dorno','PV','Caserta','CE','+393659852014','prPa2404@gmail.com',36.4,'V',1,4);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('CY1881570','Alice','Cocci',TO_DATE('24/05/1951','dd/mm/yyyy'),'Femmina','Calvignasco','MI','Roma','RM','+393654002598','AliceCC@outlook.com',36.2,'V',1,4);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('RT1739919','Quinzio','Pugliesi',TO_DATE('18/05/1989','dd/mm/yyyy'),'Maschio','Ascensione','RA','Recale','CE','+393398947852','QuinzioPugliesi0589@gmail.com',37.0,'F',1,5);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('YS3432289','Ida','Pagnotto',TO_DATE('01/03/1966','dd/mm/yyyy'),'Femmina','Martano','LE','Martano','LE','+393698521655','IdaPagno@gmail.com',36.8,'F',1,5);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('GU1160846','Geronima','Endrizzi',TO_DATE('09/11/2000','dd/mm/yyyy'),'Non specificato','Nago','TN','Vico Equense','NA','+393854759624','GeronimaEnd@gmail.com',35.9,'V',1,6);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('AD8695321','Carolina','Pugliese',TO_DATE('07/04/1953','dd/mm/yyyy'),'Femmina','Casavatore','NA','Casoria','NA','+393275273639','CarolinaPugliese@gmail.com',35.4,'V',1,6);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('BG2548759','Marcella','Pezzali',TO_DATE('28/12/1977','dd/mm/yyyy'),'Femmina','Arzano','NA','Arzano','NA','+393732068075','MarcellaPezzali@gmail.com',36.1,'V',2,7);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('GH5632104','Dolores','Zanzi',TO_DATE('18/01/1955','dd/mm/yyyy'),'Femmina','Volla','NA','Cetara','SA','+393380722982','DoloresDePanza@gmail.com',36.4,'V',2,7);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('FR5849625','Fabiola','Mengolo',TO_DATE('19/09/1956','dd/mm/yyyy'),'Femmina','Giffoni Sei Casali','SA','San Giorgio a Cremano','NA','+393416755818','FabiMengolo@gmail.com',36.5,'V',2,8);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('TR5625487','Daniele','Bernardi',TO_DATE('03/12/1959','dd/mm/yyyy'),'Maschio','Cercola','NA','Portici','NA','+393562319517','DaanBernardi@gmail.com',37.1,'V',2,8);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('BR2648058','Carolina','Lombardi',TO_DATE('07/11/1961','dd/mm/yyyy'),'Femmina','Melito di Napoli','NA','Melito di Napoli','NA','+393516530360','CaroLombardi@gmail.com',37.0,'V',2,9);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('LE2615481','Rossana','Filzi',TO_DATE('23/09/1965','dd/mm/yyyy'),'Femmina','Afragola','NA','Montecorvino Pugliano','SA','+393316825631','RossanaFilzi@gmail.com',36.8,'V',2,9);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('ML6215403','Pierluigi','Trapanese',TO_DATE('30/09/1965','dd/mm/yyyy'),'Maschio','Casandrino','NA','Fisciano','SA','+393303659368','LuigiTrapanese@gmail.com',36.8,'V',2,10);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('RS4697315','Silvia','Golgi',TO_DATE('22/04/1968','dd/mm/yyyy'),'Femmina','Casalnuovo di Napoli','NA','Calvanico','SA','+393869408344','SilviGolgi@gmail.com',36.6,'V',2,10);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('GC9674582','Nicola','Ricci',TO_DATE('21/08/1969','dd/mm/yyyy'),'Maschio','Bellizzi','SA','San Sebastiano al Vesuvio','NA','+393362582808','NicoRic@gmail.com',36.5,'V',2,10);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('AE6164595','Antonio','Bettoni',TO_DATE('20/08/1971','dd/mm/yyyy'),'Maschio','Mugnano di Napoli','NA','Mercato San Severino','SA','+393410197804','AntoBet@gmail.com',36.3,'V',2,10);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('PO3031697','Amleto','Virgilio',TO_DATE('05/01/1975','dd/mm/yyyy'),'Maschio','Marano di Napoli','NA','Maiori','SA','+393488969310','AmletoVirgilio@gmail.com',36.2,'V',2,11);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('MR9748683','Mauro','Priuli',TO_DATE('15/04/1988','dd/mm/yyyy'),'Maschio','Marano di Napoli','NA','Marano di Napoli','NA','+393394922230','MauroPriuli@gmail.com',36.2,'V',2,11);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('DR0301264','Rosaria','Argurio',TO_DATE('25/05/1976','dd/mm/yyyy'),'Femmina','Dugenta','BN','Durazzano','BN','+393250404211','RosiArgurio@gmail.com',36.5,'V',3,12);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('LZ9575684','Mauro','Zola',TO_DATE('17/10/1979','dd/mm/yyyy'),'Maschio','Bellona','CE','Arienzo','CE','+393411767562','MauroZola@gmail.com',36.5,'V',3,12);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('IC2558319','Donatello','Pellegrini',TO_DATE('19/03/1980','dd/mm/yyyy'),'Maschio','Vitulazio','CE','Vitulazio','CE','+393397508638','DonaPellegrini@gmail.com',37.0,'V',3,12);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('TE0864370','Giancarlo','Boitani',TO_DATE('05/04/1982','dd/mm/yyyy'),'Maschio','Cervino','CE','San Felice a Cancello','CE','+393416061365','GianBoitani@gmail.com',37.0,'V',3,12);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('ZO6283162','Melania','Poerio',TO_DATE('23/04/1984','dd/mm/yyyy'),'Femmina','Santa Maria a Vico','CE','Santa Maria la Fossa','CE','+393533370100','MelaniaPoerio@gmail.com',36.7,'V',3,12);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('IH2648039','Renata','Pizzetti',TO_DATE('11/11/1985','dd/mm/yyyy'),'Femmina','Piana di Monte Verna','CE','Piana di Monte Verna','CE','+393516025201','RenataPizz@gmail.com',36.7,'V',3,13);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('FU2645786','Giuseppina','Giannuzzi',TO_DATE('20/07/1990','dd/mm/yyyy'),'Femmina','Grazzanise','CE','Grazzanise','CE','+393520418674','GeppyGianni@gmail.com',36.3,'V',3,13);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('UR6437280','Angelica','Barbarigo',TO_DATE('02/07/1991','dd/mm/yyyy'),'Femmina','San Tammaro','CE','Santa Maria Capua Vetere','CE','+393510895615','LikaBarbagio@gmail.com',36.3,'V',3,14);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('OG6407351','Melissa','Tasso',TO_DATE('16/08/1992','dd/mm/yyyy'),'Femmina','Santa Maria Capua Vetere','CE','Caiazzo','CE','+393309496253','MeliTasso@gmail.com',36.4,'V',3,14);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('OG6427318','Gianluca','Murri',TO_DATE('19/05/1995','dd/mm/yyyy'),'Maschio','Marcianise','CE','Marcianise','CE','+393528831547','GianMurri@gmail.com',36.5,'F',3,15);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('LR9137648','Jolanda','Adinolfi',TO_DATE('06/05/1996','dd/mm/yyyy'),'Femmina','Portico di Caserta','CE','Macerata Campania','CE','+393519447992','JoleAdi@gmail.com',37.0,'F',3,15);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('HE5467974','Fernando','Cilibrasi',TO_DATE('19/07/1997','dd/mm/yyyy'),'Maschio','Pozzuoli','NA','Pozzuoli','NA','+393342696918','FernandoCilibrasi@gmail.com',36.5,'F',3,16);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('TR9746286','Roberto','Camanni',TO_DATE('24/11/1998','dd/mm/yyyy'),'Maschio','Quarto','NA','Quarto','NA','+393438255310','RobiCamanni@gmail.com',36.4,'F',3,16);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('IT3146975','Carmelo','Mastroianni',TO_DATE('12/02/1999','dd/mm/yyyy'),'Maschio','Cardito','NA','Curti','CE','+393309290526','CarmeloMastroianni@gmail.com',36.5,'F',3,17);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('HY9746580','Ezio','Ammaniti',TO_DATE('11/12/2001','dd/mm/yyyy'),'Maschio','Frattamaggiore','NA','Frattamaggiore','NA','+393353722101','EzioAmm@gmail.com',36.8,'F',3,17);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('LH9137684','Aria','Moschino',TO_DATE('02/05/2002','dd/mm/yyyy'),'Femmina','Capodrise','CE','Massa di Somma','NA','+393301539510','AriMoschino@gmail.com',36.7,'V',3,18);

INSERT INTO AVVENTORE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Temperatura, HaGreenpass, Ristorante, Tavolata)
VALUES('GE9197735','Vittorio','Pulci',TO_DATE('10/12/2002','dd/mm/yyyy'),'Maschio','Grumo Nevano','NA','Casapulla','CE','+393273531946','VikPulci@gmail.com',36.5,'V',3,18);
COMMIT;
/*===========================================================================================*/
/*===========================================================================================*/
-- Insert per la tabella CASO
INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(1,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,'IC3159530',NULL,1,NULL);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(2,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,'SU2810531',NULL,1,NULL);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(3,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,'RT1739919',NULL,1,NULL);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(4,TO_DATE('25/01/2022','dd/mm/yyyy'),'InRisoluzione',NULL,'LE2615481',NULL,NULL,1);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(5,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,'LZ9575684',NULL,NULL,2);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(6,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,'OG6427318',NULL,NULL,2);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(7,TO_DATE('25/01/2022','dd/mm/yyyy'),'Risolto',NULL,'GE9197735',NULL,NULL,2);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(8,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,NULL,'CA78432DB',1,NULL);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(9,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,NULL,'CA33241OA',NULL,2);

INSERT INTO CASO (CodCaso, DataRegistrazione, StatoCaso, Note, AvventorePositivo, CamerierePositivo, RegistraProprietario, RegistraManager)
VALUES(10,TO_DATE('25/01/2022','dd/mm/yyyy'),'NonRisolto',NULL,NULL,'CA66421DA',1,NULL);
COMMIT;
/*===========================================================================================*/
/*===========================================================================================*/
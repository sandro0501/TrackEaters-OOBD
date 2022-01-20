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
INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (1, 10, 1, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (2, 5, 1, 1);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (3, 5, 1, 2);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (4, 2, 1, 3);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (5, 2, 1, 4);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (6, 2, 1, 5);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (7, 2, 1, 6);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (8, 2, 1, 7);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (9, 20, 1, 8);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (10, 5, 2, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (11, 5, 2, 10);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (12, 2, 2, 11);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (13, 2, 2, 12);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (14, 2, 2, 13);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (15, 2, 2, 14);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (16, 2, 2, 15);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (17, 2, 3, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (18, 2, 3, 17);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (19, 2, 3, 18);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (20, 2, 3, 19);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (21, 2, 3, 20);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (22, 10, 4, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (23, 5, 4, 22);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (24, 5, 4, 23);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (25, 2, 4, 24);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (26, 2, 4, 25);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (27, 2, 4, 26);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (28, 2, 4, 27);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (29, 2, 4, 28);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (30, 20, 4, 29);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (31, 2, 5, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (32, 2, 5, 31);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (33, 4, 5, 32);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (34, 2, 5, 33);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (35, 2, 5, 34);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (36, 2, 5, 35);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (37, 4, 5, 36);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (38, 10, 6, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (39, 5, 6, 38);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (40, 5, 6, 39);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (41, 10, 6, 40);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (42, 10, 7, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (43, 5, 7, 42);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (44, 5, 7, 43);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (45, 10, 7, 44);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (46, 5, 8, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (47, 5, 8, 46);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (48, 2, 8, 47);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (49, 2, 8, 48);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (50, 2, 8, 49);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (51, 2, 8, 50);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (52, 2, 8, 51);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (53, 2, 9, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (54, 2, 9, 53);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (55, 2, 9, 54);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (56, 2, 9, 55);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (57, 2, 9, 56);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (58, 2, 10, NULL);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (59, 2, 10, 58);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (60, 2, 10, 59);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (61, 2, 10, 60);

INSERT INTO TAVOLO (CodTavolo, MaxAvventori, Sala, TavoloAdiacente)
VALUES (62, 2, 10, 61);
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Insert per la tabella TAVOLATA
INSERT INTO TAVOLATA (CodTavolata, DataArrivo, Tavolo, Cameriere)
VALUES (1, TO_DATE('22/01/2022', 'dd/mm/yyyy'),1,CA78432DB);

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (2, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 4, CA78432DB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (3, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 5, CA78432DB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (4, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 9, CA66421DA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (5, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 10, CA66421DA )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (6, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 12, AU0199811)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (7, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 13, AU0199811)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (8, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 15, CA64321CE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (9, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 16, CA64321CE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (10, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 17, AU3425442)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (11, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 19, AU3425442)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (12, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 23, CA53216BE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (13, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 24, CA53216BE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (14, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 27, CA73121FE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (15, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 28, CA73121FE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (16, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 29, CA73121FE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (17, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 31, AU0567231)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (18, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 33, AU0567231)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (19, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 35, CA52131PV)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (20, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 37, CA52131PV)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (21, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 38, CA87452TB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (22, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 39, CA87452TB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (23, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 41, CA87452TB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (24, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 42, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (25, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 43, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (26, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 44, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (27, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 46, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (28, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 47, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (29, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 50, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (30, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 52, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (31, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 53, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (32, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 55, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (33, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 56, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (34, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 58, CA33241OA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (35, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 59, CA33241OA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (36, TO_DATE('15/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 62, CA13264UI)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (37, TO_DATE('16/11/2021', 'dd/mm/yyyy'), 20:00, 22:00, 1, CA78432DB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (38, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 4, CA78432DB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (39, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 5, CA78432DB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (40, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 7, CA66421DA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (41, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 8, CA66421DA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (42, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 9, CA66421DA )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (43, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 10, CA66421DA )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (44, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 12, AU0199811 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (45, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 13, AU0199811 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (46, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 15, CA64321CE  )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (47, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 16 CA64321CE  )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (48, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 17, AU3425442 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (49, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 18, AU3425442)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (50, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 19, AU3425442 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (51, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 22, CA53216BE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (52, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 23, CA53216BE )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (53, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 24, CA53216BE )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (54, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 26, CA53216BE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (55, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 27, CA73121FE )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (56, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 28, CA73121FE )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (57, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 29, CA73121FE )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (58, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 30, AU0567231)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (59, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 31, AU0567231)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (60, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 32, AU0567231 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (61, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 33, AU0567231 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (62, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 35, CA52131PV )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (63, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 36, CA52131PV)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (64, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 37, CA52131PV )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (65, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 38, CA87452TB )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (66, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 39, CA87452TB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (67, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 41, CA87452TB)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (68, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 42, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (69, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 43, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (70, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 44, CA33145OD)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (71, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 46, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (72, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 47, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (73, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 48, AU0236754 )

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (74, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 50, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (75, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 52, AU0236754)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (76, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 53, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (77, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 55, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (78, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 56, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (79, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 57, CA10946DE)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (80, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 58, CA33241OA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (81, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 59, CA33241OA)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (82, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 60, CA13264UI)

INSERT INTO TAVOLATA (CodTavolata, DataArrivo, OraArrivo, OraUScita, Tavolo, Cameriere)
VALUES (83, TO_DATE('16/11/2021', 'dd/mm/yyyy'),20:00, 22:00, 62, CA13264UI)
/*===========================================================================================*/
/*===========================================================================================*/
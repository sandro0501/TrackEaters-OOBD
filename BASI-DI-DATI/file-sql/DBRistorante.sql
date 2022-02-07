-- DEFINIZIONE DELLE TABELLE DB 
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella PROPRIETARIO
CREATE TABLE PROPRIETARIO
(
	CodProprietario	INTEGER	GENERATED BY DEFAULT AS IDENTITY,
	Username		VARCHAR2(64)  NOT NULL,	
	Password 		VARCHAR2(64)  NOT NULL,
	Nome			VARCHAR2(64)  NOT NULL,
	Cognome			VARCHAR2(64)  NOT NULL,
	Email			VARCHAR2(320)   
);
/
-- Definizione dei vincoli per la tabella PROPRIETARIO
ALTER TABLE PROPRIETARIO ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_PROPRIETARIO PRIMARY KEY (CodProprietario),
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_PROPRIETARIO CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo Unico username proprietario
	CONSTRAINT UNICO_USERNAME_PROPRIETARIO UNIQUE (Username)
);
/
-- Trigger per il vincolo Password legale 
CREATE OR REPLACE TRIGGER PASSWORD_PROPRIETARIO_LEGALE
BEFORE INSERT OR UPDATE ON PROPRIETARIO
FOR EACH ROW
BEGIN
	PASSWORD_LEGALE(:NEW.Password);
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella RISTORANTE
CREATE TABLE RISTORANTE
(
	CodRistorante	INTEGER	GENERATED BY DEFAULT AS IDENTITY,
	Denominazione	VARCHAR2(64)  	NOT NULL,	
	Indirizzo 		VARCHAR2(64)  	NOT NULL,
	Telefono		VARCHAR2(20)  	NOT NULL,
	Citta			VARCHAR2(64)  			,
	Prov			VARCHAR2(2)   			,
	Cap				VARCHAR2(5)				,
	Email			VARCHAR2(320)			,  
	SitoWeb			VARCHAR2(100)			, 
	Proprietario	INTEGER		  	NOT NULL
);
/
-- Definizione dei vincoli per la tabella RISTORANTE
ALTER TABLE RISTORANTE ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_RISTORANTE PRIMARY KEY (CodRistorante),
	
	-- Vincolo di chiave esterna
	/*Non sarà possibile eliminare un proprietario a cui sono associati uno o più ristoranti
	ON DELETE NO ACTION è implementato di default da ORACLE*/ 
	CONSTRAINT FK_PROPRIETARIO_RISTORANTE FOREIGN KEY (Proprietario) REFERENCES PROPRIETARIO(CodProprietario),
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_RISTORANTE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo Sito Web Legale
	CONSTRAINT SITO_WEB_LEGALE CHECK (SitoWeb LIKE 'www.__%._%' OR SitoWeb IS NULL)
);
/
-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_RISTORANTE_LEGALE
BEFORE INSERT OR UPDATE ON RISTORANTE
FOR EACH ROW
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/
-- Trigger per il vincolo Cap legale
CREATE OR REPLACE TRIGGER CAP_LEGALE
BEFORE INSERT OR UPDATE ON RISTORANTE
FOR EACH ROW
BEGIN
	-- Controlla che i caratteri associati al CAP inserito siano 5 e tutti numeri. 
	-- Se il controllo fallisce, quindi è presente un carattere diverso da un numero oppure
	-- ci sono meno di 5 caratteri allora il CAP non è valido.
	IF (is_number(:NEW.Cap)=0) OR (LENGTH(:NEW.Cap)<5) THEN
		RAISE_APPLICATION_ERROR(-20012,'CAP inserito non valido.');
	END IF;
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella MANAGERRISTORANTE
CREATE TABLE MANAGERRISTORANTE
(
	CodManager			INTEGER GENERATED BY DEFAULT AS IDENTITY,
	Username			VARCHAR2(64)  NOT NULL,	
	Password 			VARCHAR2(64)  NOT NULL,
	Nome				VARCHAR2(64)  NOT NULL,
	Cognome				VARCHAR2(64)  NOT NULL,
	Email				VARCHAR2(320)		  ,
	Telefono			VARCHAR2(20)  NOT NULL,
	RistoranteGestito	INTEGER 	  		  
);
/
-- Definizione dei vincoli per la tabella MANAGERRISTORANTE
ALTER TABLE MANAGERRISTORANTE ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_MANAGER_RISTORANTE PRIMARY KEY (CodManager),
	
	-- Vincolo di chiave esterna
	-- Se si cancella un ristorante vengono eliminati anche i manager che lo gestiscono 
	CONSTRAINT FK_MANAGER_RISTORANTE FOREIGN KEY (RistoranteGestito) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_MANAGER_RISTORANTE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo Unico username manager
	CONSTRAINT UNICO_USERNAME_MANAGER_RISTORANTE UNIQUE (Username)
);
/
-- Trigger per il vincolo Password legale
CREATE OR REPLACE TRIGGER PASSWORD_MANAGER_RISTORANTE_LEGALE
BEFORE INSERT OR UPDATE ON MANAGERRISTORANTE
FOR EACH ROW
BEGIN
	PASSWORD_LEGALE(:NEW.Password);
END;
/
-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_MANAGER_RISTORANTE_LEGALE
BEFORE INSERT OR UPDATE ON MANAGERRISTORANTE
FOR EACH ROW
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella SALA
CREATE TABLE SALA
(
    CodSala				INTEGER GENERATED BY DEFAULT AS IDENTITY,
    Denominazione       VARCHAR2(64)    NOT NULL,
    CapienzaAvventori   INTEGER			NOT NULL,
    DimensioneMq        INTEGER		 			,
    TipoSala            VARCHAR(10)		NOT NULL,
    Ristorante        	INTEGER         NOT NULL   
);
/
-- Definizione dei vincoli per la tabella SALA
ALTER TABLE SALA ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_SALA PRIMARY KEY (CodSala),
    
    -- Vincolo di chiave esterna
	-- Se si cancella un ristorante vengono eliminate anche le sale che vi appartengono
    CONSTRAINT FK_SALA_RISTORANTE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
	-- Vincolo CapienzaAvventori legale 
	CONSTRAINT CAPIENZAAVVENTORI_LEGALE CHECK (CapienzaAvventori>0),
	
	-- Vincolo DimensioneMq legale 
	CONSTRAINT DIMENSIONEMQ_LEGALE CHECK (DimensioneMq>0 OR DimensioneMq IS NULL),
	
	-- Vincolo TSala
	CONSTRAINT TSALA CHECK (TipoSala IN ('Interna','Esterna'))	
);
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella CAMERIERE
CREATE TABLE CAMERIERE
(
    NumCid              VARCHAR2(9)		NOT NULL,
    Nome                VARCHAR2(64)	NOT NULL,
    Cognome             VARCHAR2(64)	NOT NULL,
    DataN               DATE			NOT NULL,
    Sesso               VARCHAR2(20)	NOT NULL,
    CittaN              VARCHAR2(64)	NOT NULL,
    ProvN               VARCHAR2(2)		NOT NULL,
    CittaRes            VARCHAR2(64)	NOT NULL,
    ProvRes             VARCHAR2(2)		NOT NULL,
    Telefono            VARCHAR2(20)	NOT NULL,
    Email               VARCHAR2(320)			,
    Ristorante          INTEGER			NOT NULL  
);
/
-- Definizione dei vincoli per la tabella CAMERIERE
ALTER TABLE CAMERIERE ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_CAMERIERE PRIMARY KEY (NumCid),
	
	-- Vincolo di chiave esterna
	-- Se si cancella un ristorante vengono eliminate anche i camerieri che vi lavorano
	CONSTRAINT FK_CAMERIERE_RISTORANTE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_CAMERIERE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo TSesso
	CONSTRAINT TSesso CHECK (Sesso IN ('Maschio','Femmina','Non specificato'))	
);
/
-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_CAMERIERE_LEGALE
BEFORE INSERT OR UPDATE ON CAMERIERE
FOR EACH ROW
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/
-- Trigger per il vincolo Età cameriere legale
CREATE OR REPLACE TRIGGER ETA_CAMERIERE_LEGALE
BEFORE INSERT OR UPDATE ON CAMERIERE
FOR EACH ROW
DECLARE etacameriere INTEGER;
BEGIN
	-- Se l'età del cameriere è inferiore a 18 anni, 
	-- allora non sarà possibile inserire il cameriere 
	etacameriere := TRUNC((TO_NUMBER(SYSDATE - :NEW.DataN))/365.25); 
	
	IF etacameriere < 18 THEN 
		RAISE_APPLICATION_ERROR(-20014,'DataN per cameriere non valida. Un cameriere deve essere maggiorenne!');
	END IF; 
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella TAVOLO
CREATE TABLE TAVOLO
(
    CodTavolo 		INTEGER GENERATED BY DEFAULT AS IDENTITY,
    MaxAvventori    INTEGER		NOT NULL,
    Sala            INTEGER		NOT NULL 
);
/
-- Definizione dei vincoli per la tabella TAVOLO
ALTER TABLE TAVOLO ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_TAVOLO PRIMARY KEY (CodTavolo),
    
    -- Vincolo di chiave esterna
	-- Se si cancella una sala vengono eliminati anche i tavoli in essa contenuti
    CONSTRAINT FK_SALA_TAVOLO FOREIGN KEY (Sala) REFERENCES SALA(CodSala) ON DELETE CASCADE
);
/
-- Trigger per il vincolo MaxAvventori legale 
CREATE OR REPLACE TRIGGER MAXAVVENTORI_LEGALE
AFTER INSERT OR UPDATE ON TAVOLO
FOR EACH ROW 
DECLARE
capienza INTEGER;
BEGIN
	-- Calcolo di CapienzaAvventori 
	SELECT S.CapienzaAvventori INTO capienza
	FROM SALA S 
	WHERE S.CodSala = :NEW.Sala;

	-- Se MaxAvventori è <=0 allora non è valido 
	IF :NEW.MaxAvventori <=0 THEN
		RAISE_APPLICATION_ERROR(-20015,'Il valore per MaxAvventori deve essere maggiore di 0!');
	ELSE 
		-- Se MaxAvventori è > di CapienzaAvventori della sala in cui il tavolo è contenuto
		-- allora non è valido 
		IF :NEW.MaxAvventori > capienza THEN 
			RAISE_APPLICATION_ERROR(-20016,'Il valore di MaxAvventori per il tavolo deve essere 
			minore o uguale alla CapienzaAvventori della sala che contiene il tavolo in questione!');
		END IF;
	END IF; 
END;
/
-- Trigger per il vincolo Capienza legale 
CREATE OR REPLACE TRIGGER CAPIENZA_LEGALE
BEFORE INSERT ON TAVOLO
FOR EACH ROW
DECLARE
capienza INTEGER;
capienzacorrente INTEGER;
BEGIN
	-- Calcolo di CapienzaAvventori 
	SELECT S.CapienzaAvventori INTO capienza
	FROM SALA S 
	WHERE S.CodSala = :NEW.Sala;
	
	-- Calcolo della CapienzaAvventori corrente per la Sala 
	SELECT SUM(T.MaxAvventori) INTO capienzacorrente
	FROM TAVOLO T
	WHERE T.Sala =:NEW.Sala;
	
	-- Se la somma fra la Capienza corrente e il nuovo MaxAvventori supera 
	-- la Capienza massima della Sala allora blocca l'inserimento
	IF :NEW.MaxAvventori+capienzacorrente > capienza THEN
		RAISE_APPLICATION_ERROR(-20017,'Errore. Capienza massima della sala di riferimento superata!');
	END IF;
	
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella ADIACENZATAVOLO
CREATE TABLE ADIACENZATAVOLO
(
   Tavolo 		   INTEGER,
   TavoloAdiacente INTEGER
);
/
-- Definizione dei vincoli per la tabella ADIACENZATAVOLO
ALTER TABLE ADIACENZATAVOLO ADD
(
    -- Vincoli di chiave esterna
    CONSTRAINT FK_TAVOLO FOREIGN KEY (Tavolo) REFERENCES TAVOLO(CodTavolo) ON DELETE CASCADE,
	CONSTRAINT FK_TAVOLOADIACENTE FOREIGN KEY (TavoloAdiacente) REFERENCES TAVOLO(CodTavolo) ON DELETE CASCADE,
	
	-- Vincolo Adiacenza legale
	CONSTRAINT ADIACENZA_LEGALE CHECK (Tavolo <> TavoloAdiacente)
);
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella TAVOLATA
CREATE TABLE TAVOLATA
(
    CodTavolata		INTEGER GENERATED BY DEFAULT AS IDENTITY,
    DataArrivo      DATE        					DEFAULT SYSDATE NOT NULL,
    OraArrivo       INTERVAL DAY(0) TO SECOND(0)	DEFAULT INTERVAL '20:00' HOUR TO MINUTE	 NOT NULL,
    OraUsicta       INTERVAL DAY(0) TO SECOND(0)	DEFAULT INTERVAL '22:00' HOUR TO MINUTE	 NOT NULL,
    Tavolo          INTEGER     					NOT NULL,
    Cameriere       VARCHAR2(9)    					NOT NULL  
);
/
-- Definizione dei vincoli per la tabella TAVOLATA
ALTER TABLE TAVOLATA ADD
(
	-- Vincolo di chiave primaria
    CONSTRAINT PK_TAVOLATA PRIMARY KEY (CodTavolata),
    
	-- Vincolo di chiave esterna
	-- Se si elimina un tavolo viene eliminata anche la tavolata ad esso associato 
	CONSTRAINT FK_TAVOLO_TAVOLATA FOREIGN KEY (Tavolo) REFERENCES TAVOLO(CodTavolo) ON DELETE CASCADE,
    
	-- Vincolo di chiave esterna
	CONSTRAINT FK_CAMERIERE_TAVOLATA FOREIGN KEY (Cameriere) REFERENCES CAMERIERE(NumCid),
   
	-- Vincolo Unica composizione tavolo a tavolata 
	CONSTRAINT UNICA_COMPOSIZIONE_TAVOLO_A_TAVOLATA UNIQUE(DataArrivo,Tavolo)
);
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella AVVENTORE
CREATE TABLE AVVENTORE
(
    NumCid              VARCHAR2(9)		NOT NULL,
    Nome                VARCHAR2(64)	NOT NULL,
    Cognome             VARCHAR2(64)	NOT NULL,
    DataN               DATE			NOT NULL,
    Sesso               VARCHAR2(15)	NOT NULL,
    CittaN              VARCHAR2(64)	NOT NULL,
    ProvN               VARCHAR2(2)		NOT NULL,
    CittaRes            VARCHAR2(64)	NOT NULL,
    ProvRes             VARCHAR2(2)		NOT NULL,
    Telefono            VARCHAR2(20)    NOT NULL,
    Email               VARCHAR2(320)			,
    Temperatura         DECIMAL(3,1)	NOT NULL,
    HaGreenpass         CHAR          	DEFAULT 'F' NOT NULL
);
/
-- Definizione dei vincoli per la tabella AVVENTORE
ALTER TABLE AVVENTORE ADD
(
	-- Vincolo di chiave primaria
    CONSTRAINT PK_AVVENTORE PRIMARY KEY (NumCid),
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_AVVENTORE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo TSesso
	CONSTRAINT TSesso_AVVENTORE CHECK (Sesso IN ('Maschio','Femmina','Non specificato')),	
	
	-- Vincolo per il dominio dell'attributo booleano HaGreenPass
	CONSTRAINT HAGREENPASS_VALUES CHECK (HaGreenPass IN('V','F')),
	
	-- Vincolo Temperatura avventore legale 
	CONSTRAINT TEMPERATURA_AVVENTORE_LEGALE CHECK (Temperatura BETWEEN 35.0 AND 37.5)	
);
/
-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_AVVENTORE_LEGALE
BEFORE INSERT OR UPDATE ON AVVENTORE
FOR EACH ROW
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/
-- Trigger per il vincolo Temperatura avventore legale
CREATE OR REPLACE TRIGGER TEMPERATURA_AVVENTORE
BEFORE INSERT OR UPDATE ON AVVENTORE
FOR EACH ROW
BEGIN
	-- Se la temperatura dell'avventore supera i 37.5 gradi allora comunica che l'avventore 
	-- puo' essere un potenziale caso da registrare nella tabella CASO. 
	IF :NEW.Temperatura > 37.5 THEN 
		RAISE_APPLICATION_ERROR( -20020, 'Temperatura avventore illegale! 
		Potrebbe essere un potenziale CASO da registrare.');
	END IF;
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella ACCOGLIENZA
CREATE TABLE ACCOGLIENZA
(
	Ristorante 	INTEGER 	NOT NULL, 
	Avventore	VARCHAR2(9) NOT NULL
);
/
-- Definizione dei vincoli per la tabella ACCOGLIENZA
ALTER TABLE ACCOGLIENZA ADD
(
    -- Vincoli di chiave esterna
    CONSTRAINT FK_RISTORANTE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	CONSTRAINT FK_AVVENTORE FOREIGN KEY (Avventore) REFERENCES AVVENTORE(NumCid) ON DELETE CASCADE
);
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella PARTECIPAZIONETAVOLATA
CREATE TABLE PARTECIPAZIONETAVOLATA
(
	Avventore	VARCHAR2(9) NOT NULL,
	Tavolata 	INTEGER 	NOT NULL
);
/
-- Definizione dei vincoli per la tabella PARTECIPAZIONETAVOLATA
ALTER TABLE PARTECIPAZIONETAVOLATA ADD
(
    -- Vincoli di chiave esterna
	CONSTRAINT FK_PARTECIPAZIONE_AVVENTORE FOREIGN KEY (Avventore) REFERENCES AVVENTORE(NumCid) ON DELETE CASCADE,
	CONSTRAINT FK_PARTECIPAZIONE_TAVOLATA FOREIGN KEY (Tavolata) REFERENCES TAVOLATA(CodTavolata) ON DELETE CASCADE
);
/
-- Trigger per il vincolo Data nascita legale 
CREATE OR REPLACE TRIGGER DATA_NASCITA_LEGALE
BEFORE INSERT OR UPDATE ON PARTECIPAZIONETAVOLATA
FOR EACH ROW
DECLARE
datatavolata TAVOLATA.DataArrivo%TYPE; 
datanascita AVVENTORE.DataN%TYPE;
BEGIN
	-- Recupera la data della tavolata a cui partecipa l'avventore 
	SELECT T.DataArrivo INTO datatavolata
	FROM TAVOLATA T 
	WHERE T.CodTavolata = :NEW.Tavolata;
	
	-- Recupera la data di nascita dell'avventore che partecipa alla tavolata
	SELECT A.DataN INTO datanascita
	FROM AVVENTORE A
	WHERE A.NumCid = :NEW.Avventore;
	
	-- Se la data di nascita dell'avventore è successiva alla data della tavolata allora
	-- blocca l'inserimento dell'avventore 
	IF datanascita > datatavolata THEN 
		RAISE_APPLICATION_ERROR( -20018, 'L avventore non puo partecipare alla tavolata. 
		Controllare la sua data di nascita!');
	END IF;
END;
/
-- Trigger per il vincolo Has greenpass  
CREATE OR REPLACE TRIGGER HAS_GREENPASS
BEFORE INSERT OR UPDATE ON PARTECIPAZIONETAVOLATA
FOR EACH ROW
DECLARE 
tipologiasala SALA.TipoSala%TYPE;
hagreenpass AVVENTORE.HaGreenpass%TYPE; 
BEGIN
	
	-- Recupera la tipologia della sala in cui è ubicato il tavolo della tavolata a cui partecipa l'avventore 
	SELECT S.TipoSala INTO tipologiasala
	FROM TAVOLATA T JOIN TAVOLO TA ON T.Tavolo = TA.CodTavolo JOIN SALA S ON S.CodSala = TA.Sala
	WHERE T.CodTavolata = :NEW.Tavolata;
	
	-- Recupera informazione sul green pass per l'avventore che partecipa alla tavolata 
	SELECT A.HaGreenpass INTO hagreenpass 
	FROM AVVENTORE A 
	WHERE A.NumCid = :NEW.Avventore; 
	
	-- Se l'avventore è sprovvisto di green pass ed è stato associato ad una tavolata il cui tavolo 
	-- si trova in una sala interna allora non può partecipare alla tavolata. 
	IF hagreenpass='F' AND tipologiasala='Interna' THEN 
		RAISE_APPLICATION_ERROR( -20019, 'L avventore è sprovvisto di green pass. 
		Puo partecipare unicamente ad una tavolata composta da un tavolo ubicato in una sala esterna!');
	END IF;
END;
/
-- Trigger per il vincolo Somma avventori a tavolata legale 
CREATE OR REPLACE TRIGGER SOMMA_AVVENTORI_A_TAVOLATA_LEGALE
BEFORE INSERT ON PARTECIPAZIONETAVOLATA
FOR EACH ROW
DECLARE 
maxavventoritavolo TAVOLO.MaxAvventori%TYPE;
numavventoricorrente INTEGER; 
BEGIN
	-- Recupera il massimo numero dei posti del tavolo associato alla tavolata 
	SELECT TA.MaxAvventori INTO maxavventoritavolo
	FROM TAVOLATA T JOIN TAVOLO TA ON T.Tavolo = TA.CodTavolo
	WHERE T.CodTavolata = :NEW.Tavolata;
    
	-- Conta gli avventori correnti che partecipano alla tavolata 
	SELECT COUNT(P.Avventore) INTO numavventoricorrente
	FROM PARTECIPAZIONETAVOLATA P 
	WHERE P.Tavolata = :NEW.Tavolata;

	-- Se il numero di avventori correnti che partecipano alla tavolata 
	-- più il nuovo avventore che si sta per registrare 
	-- superano complessivamente il numero dei posti del tavolo 
	-- allora non è possibile registrare il nuovo avventore 
	IF numavventoricorrente+1 > maxavventoritavolo THEN 
		RAISE_APPLICATION_ERROR( -20021, 'Impossibile registrare avventore alla tavolata. 
		Il tavolo di riferimento ha tutti i posti occupati!');
	END IF;
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella CASO
CREATE TABLE CASO
(
	CodCaso	INTEGER GENERATED BY DEFAULT AS IDENTITY,
    DataRegistrazione    DATE			NOT NULL,
    StatoCaso            VARCHAR2(20) 	DEFAULT 'NonRisolto' NOT NULL,
    Note                 VARCHAR2(100)	,
    AvventorePositivo    VARCHAR2(9)	,
    CamerierePositivo    VARCHAR2(9)	,
    RegistraProprietario INTEGER		,
    RegistraManager      INTEGER
);
/
-- Definizione dei vincoli per la tabella CASO
ALTER TABLE CASO ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_CASO PRIMARY KEY (CodCaso),
    
    -- Vincolo di chiave esterna
    CONSTRAINT FK_AVVENTORE_POSITIVO FOREIGN KEY (AvventorePositivo) REFERENCES AVVENTORE(NumCid) ON DELETE SET NULL,
    
	-- Vincolo di chiave esterna
	CONSTRAINT FK_CAMERIERE_POSITIVO FOREIGN KEY (CamerierePositivo) REFERENCES CAMERIERE(NumCid) ON DELETE SET NULL,
   
	-- Vincolo di chiave esterna
	CONSTRAINT FK_REGISTRA_PROPRIETARIO FOREIGN KEY (RegistraProprietario) REFERENCES PROPRIETARIO(CodProprietario) ON DELETE SET NULL,
	
	-- Vincolo di chiave esterna
	CONSTRAINT FK_REGISTRA_MANAGER FOREIGN KEY (RegistraManager) REFERENCES MANAGERRISTORANTE(CodManager) ON DELETE SET NULL,
	
	-- Vincolo TCaso
	CONSTRAINT TCaso CHECK (StatoCaso IN ('Risolto','InRisoluzione','NonRisolto'))
);
/
-- Trigger per il vincolo Data registrazione caso 
CREATE OR REPLACE TRIGGER DATA_REGISTRAZIONE_CASO
BEFORE INSERT OR UPDATE ON CASO
FOR EACH ROW
DECLARE 
datanascita_avventore AVVENTORE.DataN%TYPE;
datanascita_cameriere CAMERIERE.DataN%TYPE;
BEGIN
	IF :NEW.AvventorePositivo IS NOT NULL  THEN 
		-- Recupera la data di nascita dell'avventore positivo 
		SELECT A.DataN INTO datanascita_avventore
		FROM AVVENTORE A 
		WHERE A.NumCid = :NEW.AvventorePositivo;
		
		-- Se la data di registrazione del caso precede la data di nascita
		-- allora non e' possibile registrare il caso 
		IF :NEW.DataRegistrazione < datanascita_avventore THEN 
				RAISE_APPLICATION_ERROR( -20022, 'Impossibile registrare caso: data registrazione non valida.');
		END IF; 	
	END IF; 


	IF :NEW.CamerierePositivo IS NOT NULL THEN 
		-- Recupera la data di nascita del cameriere positivo 
		SELECT C.DataN INTO datanascita_cameriere
		FROM CAMERIERE C 
		WHERE C.NumCid = :NEW.CamerierePositivo;
		
		-- Se la data di registrazione del caso precede la data di nascita
		-- allora non e' possibile registrare il caso 
		IF :NEW.DataRegistrazione < datanascita_cameriere THEN 
				RAISE_APPLICATION_ERROR( -20022, 'Impossibile registrare caso: data registrazione non valida.');
		END IF; 
	END IF; 	
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della VISTA 'Tavolate' : 
-- per ogni tavolata di un ristorante calcola il numero totale di partecipanti alla tavolata. 
CREATE VIEW TAVOLATE (Ristorante, CodiceTavolata, Partecipanti) AS
SELECT A.Ristorante, PT.Tavolata, COUNT(PT.Avventori) AS TOT_TAVOLATA
FROM ACCOGLIENZA A JOIN PARTECIPAZIONETAVOLATA PT ON A.Avventore = PT.Avventore
GROUP BY A.Ristorante, PT.Tavolata
ORDER BY PT.Tavolata ASC;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della VISTA RIEPILOGO_RISTORANTI_PROPRIETARIO 
-- la vista, dato un codice di un proprietario, crea un riepilogo generale che include dettagli su tutti i ristoranti da esso amministrati
-- supponiamo che sia CodProprietario = 1
CREATE VIEW RIEPILOGO_RISTORANTI_PROPRIETARIO (Ristorante, Sala, CapienzaSala, TipoSala, TavoloInSala, MaxAvventoriTavolo) AS
SELECT R.CodRistorante, S.CodSala, S.CapienzaAvventori, S.TipoSala, T.CodTavolo, T.MaxAvventori
FROM PROPRIETARIO P JOIN RISTORANTE R ON P.CodProprietario = R.Proprietario JOIN SALA S ON R.CodRistorante = S.Ristorante JOIN TAVOLO T ON T.Sala = S.CodSala 
WHERE P.CodProprietario = 1
ORDER BY R.CodRistorante ASC, S.CodSala ASC, T.CodTavolo ASC;

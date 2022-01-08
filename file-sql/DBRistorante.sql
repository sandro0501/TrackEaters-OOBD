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
DECLARE
BEGIN
	PASSWORD_LEGALE(:NEW.Password);
END;
/
/*
-- Trigger SetUpper_Nome_Cognome : DA RIVEDERE PUO' NON ESSERE NECESSARIO.
CREATE OR REPLACE TRIGGER SET_UPPER_NOME_COGNOME
BEFORE INSERT OR UPDATE ON PROPRIETARIO
FOR EACH ROW
BEGIN
	-- Setta la stringa relativa a Nome tutta in maiuscolo
	:NEW.Nome := UPPER(:NEW.Nome);
	-- Setta la stringa relativa a Cognome tutta in maiuscolo
	:NEW.Cognome := UPPER(:NEW.Cognome);
END;
/
*/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella RISTORANTE
CREATE TABLE RISTORANTE
(
	CodRistorante	INTEGER	GENERATED BY DEFAULT AS IDENTITY,
	Denominazione	VARCHAR2(64)  	NOT NULL,	
	Indirizzo 		VARCHAR2(64)  	NOT NULL,
	Telefono		VARCHAR2(20)  	NOT NULL,
	Citta			VARCHAR2(64)  	NOT NULL,
	Prov			VARCHAR2(2)   	NOT NULL,
	Cap				VARCHAR2(5)		NOT NULL,
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
	CONSTRAINT FK_RISTORANTE FOREIGN KEY (Proprietario) REFERENCES PROPRIETARIO(CodProprietario) /*ON DELETE NO ACTION*/ ,
	
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
	RistoranteGestito	INTEGER 	  		  ,
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
DECLARE
BEGIN
	PASSWORD_LEGALE(:NEW.Password);
END;
/

-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_MANAGER_RISTORANTE_LEGALE
BEFORE INSERT OR UPDATE ON MANAGERRISTORANTE
FOR EACH ROW
DECLARE
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/

/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella SALA
CREATE TABLE SALA
{
    CodSala				INTEGER GENERATED BY DEFAULT AS IDENTITY,
    Denominazione       VARCHAR2(64)    NOT NULL,
    CapienzaAvventori   INTEGER			NOT NULL,
    DimensioneMq        INTEGER		 			,
    TipoSala            VARCHAR(10)		NOT NULL,
    Ristorante        	INTEGER         NOT NULL   
};
/

-- Definizione dei vincoli per la tabella SALA
ALTER TABLE SALA ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_SALA PRIMARY KEY (CodSala),
    
    -- Vincolo di chiave esterna
	-- Se si cancella un ristorante vengono eliminate anche le sale che vi appartengono
    CONSTRAINT FK_SALA FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
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
{
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
};
/

-- Definizione dei vincoli per la tabella CAMERIERE
ALTER TABLE CAMERIERE ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_CAMERIERE PRIMARY KEY (NumCid),
	
	-- Vincolo di chiave esterna
	-- Se si cancella un ristorante vengono eliminate anche i camerieri che vi lavorano
	CONSTRAINT FK_CAMERIERE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_CAMERIERE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	-- Vincolo Età cameriere legale
	CONSTRAINT ETA_CAMERIERE_LEGALE CHECK ((TRUNC(TO_NUMBER(SYSDATE - DATAN)/365.25))>18),
	
	-- Vincolo TSesso
	CONSTRAINT TSesso CHECK (Sesso IN ('Maschio','Femmina','Non specificato'))	
);
/

-- Trigger per il vincolo Numero di telefono legale 
CREATE OR REPLACE TRIGGER NUMERO_DI_TELEFONO_CAMERIERE_LEGALE
BEFORE INSERT OR UPDATE ON CAMERIERE
FOR EACH ROW
DECLARE
BEGIN
	NUMERO_DI_TELEFONO_LEGALE(:NEW.Telefono);
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- Creazione della tabella Tavolo
CREATE TABLE TAVOLO
{
    CodTavolo 		INTEGER GENERATED BY DEFAULT AS IDENTITY,
    MaxAvventori    INTEGER		NOT NULL,
    Sala            INTEGER		NOT NULL,
    TavoloAdiacente INTEGER     
};
/

-- Definizione dei vincoli per la tabella TAVOLO
ALTER TABLE TAVOLO ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_TAVOLO PRIMARY KEY (CodTavolo),
    
    -- Vincolo di chiave esterna
	-- Se si cancella una sala vengono eliminati anche i tavoli in essa contenuti
    CONSTRAINT FK_SALA FOREIGN KEY (Sala) REFERENCES SALA(CodSala) ON DELETE CASCADE,
    
    --Vincolo di chiave esterna
	--Se si cancella un tavolo adiacente ad un altro, l'adiacenza diventa NULL 
    CONSTRAINT FK_TAVOLO_ADIACENTE FOREIGN KEY (TavoloAdiacente) REFERENCES TAVOLO(CodTavolo) ON DELETE SET NULL
);
/

--Trigger per il vincolo MaxAvventori legale 
CREATE OR REPLACE TRIGGER MAXAVVENTORI_LEGALE
BEFORE INSERT OR UPDATE ON TAVOLO
DECLARE
capienza INTEGER;
BEGIN
	-- Se MaxAvventori è <=0 allora non è valido 
	IF :NEW.MaxAvventori <=0 THEN
		RAISE_APPLICATION_ERROR(-20013,'Il valore per MaxAvventori deve essere maggiore di 0!');
	ELSE 
		 -- Se MaxAvventori è > di CapienzaAvventori della sala in cui il tavolo è contenuto
		 -- allora non è valido 
		 
		 -- Calcolo di CapienzaAvventori 
		 SELECT CapienzaAvventori INTO capienza
		 FROM Sala S JOIN Tavolo T ON S.CodSala=T.Sala
		 WHERE T.CodTavolo = :NEW.CodTavolo;
		 
		 IF :NEW.MaxAvventori > capienza THEN 
			RAISE_APPLICATION_ERROR(-20014,'Il valore di MaxAvventori per il tavolo deve essere 
			minore o uguale alla CapienzaAvventori della sala che contiene il tavolo in questione!');
	END IF; 
END;
/

--Trigger per il vincolo SommaMaxAvventori legale (da fare)






/*============================================================================================*/
/*============================================================================================*/

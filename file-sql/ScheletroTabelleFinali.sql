
-- Crea la tabella SALA
CREATE TABLE SALA
{
    CodSala             INTEGER GENERETED BY DEFAULT AS IDENTITY,
    Denominazione       VARCHAR2(64)    NOT NULL,
    CapienzaAvventori   INTEGER         NOT NULL,
    DimensioneMq        INTEGER,
    TipoSala            TSala           NOT NULL,
    Ristornate          INTEGER         NOT NULL
    
};


-- Definizione dei vincoli per la tabella SALA
ALTER TABLE SALA ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_SALA PRIMARY KEY (CodSala),
    
    -- Vincolo di chiave esterna
    CONSTRAINT FK_SALA FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
    
);

-- Crea la tabella CAMERIERE
CREATE TABLE CAMERIERE
{
    NumCid              VARCHAR2(10)     NOT NULL,
    Nome                VARCHAR2(64)     NOT NULL,
    Cognome             VARCHAR2(64)     NOT NULL,
    DataN               DATE             NOT NULL,
    Sesso               TSesso           NOT NULL,
    CittaN              VARCHAR2(64)     NOT NULL,
    ProvN               VARCHAR2(2)      NOT NULL,
    CittaRes            VARCHAR2         NOT NULL,
    ProvRes             VARCHAR2(2)      NOT NULL,
    Telefono            VARCHAR2(20)     NOT NULL,
    Email               VARCHAR2(320),
    Ristorante          INTEGER
    
};

-- Definizione dei vincoli per la tabella CAMERIERE
ALTER TABLE CAMERIERE ADD
(
	-- Vincolo di chiave primaria
	CONSTRAINT PK_CAMERIERE PRIMARY KEY (NumCid),
	
	-- Vincolo di chiave esterna
	CONSTRAINT FK_RISTORANTE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante) ON DELETE CASCADE,
	
	-- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_CAMERIERE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL)
);


-- Definizione della tabella TAVOLO
CREATE TABLE TAVOLO
{
    CodTavolo INTEGER GENERETED BY DEFAULT AS IDENTITY,
    MaxAvventori    INTEGER     NOT NULL,
    Sala            INTEGER     NOT NULL,
    TavoloAdiacente INTEGER     NOT NULL
};

-- Definizione dei vincoli per la tabella TAVOLO
ALTER TABLE TAVOLO ADD
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_TAVOLO PRIMARY KEY (CodTavolo),
    
    -- Vincolo di chiave secondaria
    CONSTRAINT FK_SALA FOREIGN KEY (Sala) REFERENCES SALA(CodSala) ON DELETE CASCADE,
    
    --Vincolo di chiave secondaria
    CONSTRAINT FK_TAVOLO_ADIACENTE FOREIGN KEY (TavoloAdiacente) REFERENCES TAVOLO(CodTavolo)
    
);

-- Crea la tabella TAVOLATA
CREATE TABLE TAVOLATA
{
    CodTavolata     INTEGER GENERETED BY DEFAULT AS IDENTITY,
    DataArrivo      DATE        NOT NULL,
    OraArrivo       INTERVAL    NOT NULL,
    OraUsicta       INTERVAL    NOT NULL,
    Tavolo          INTEGER     NOT NULL,
    Cameriere       INTEGER     NOT NULL
    
}

-- Definizione dei vincoli per la tabella TAVOLATA
ALTER TABLE TAVOLATA AS
(

    -- Vincolo di chiave primaria
    CONSTRAINT PK_TAVOLATA PRIMARY KEY (CodTavolata),
    
    -- Vincolo di chiave esterna
    CONSTRAINT FK_TAVOLO FOREIGN KEY (Tavolo) REFERENCES TAVOLO(CodTavolo) ON DELETE CASCADE,
    
    -- Vinvolo di chiave esterna
   CONSTRAINT FK_CAMERIERE FOREIGN KEY (Cameriere) REFERENCES CAMERIERE(NumCid)

);


-- Crea la tabella TAVOLO
CREATE TABLE AVVENTORE
{
    NumCid              VARCHAR2(10)     NOT NULL,
    Nome                VARCHAR2(64)     NOT NULL,
    Cognome             VARCHAR2(64)     NOT NULL,
    DataN               DATE             NOT NULL,
    Sesso               TSesso           NOT NULL,
    CittaN              VARCHAR2(64)     NOT NULL,
    ProvN               VARCHAR2(2)      NOT NULL,
    CittaRes            VARCHAR2         NOT NULL,
    ProvRes             VARCHAR2(2)      NOT NULL,
    Telefono            VARCHAR2(20)     NOT NULL,
    Email               VARCHAR2(320),
    Temperatura         DECIMAL          NOT NULL,
    HaGreenpass         BOOLEAN          NOT NULL,
    Ristorante          INTEGER          NOT NULL,
    Tavolata            INTEGER          NOT NULL
};

-- Definizione dei vincoli per la tabella AVVENTORE
ALTER TABLE AVVENTORE AS
(

    -- Vincolo di chiave primaria
    CONSTRAINT PK_AVVENTORE PRIMARY KEY (NumCid),
    
    -- Vincolo di chiave esterna
    CONSTRAINT FK_RISTORANTE FOREIGN KEY (Ristorante) REFERENCES RISTORANTE(CodRistorante),
    
    -- Vinvolo di chiave esterna
   CONSTRAINT FK_TAVOLATA FOREIGN KEY (Tavolata) REFERENCES TAVOLATA(CodTavolata) ON DELETE CASCADE,
   
   -- Vincolo Email legale
	CONSTRAINT EMAIL_LEGALE_AVVENTORE CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL)

);

-- Crea la tabella CASO
CREATE TABLE CASO
{
    CodCaso INTEGER GENERETED BY DEFAULT AS IDENTITY,
    DataRegistrazione    DATE    NOT NULL,
    StatoCaso            TCaso   NOT NULL,
    Note                 VARCHAR2(320)
    AvventorePositivo    INTEGER,
    CamerierePositivo    INTEGER,
    RegistraProprietario INTEGER,
    RegistraManager      INTEGER
}:

-- Definizione dei vincoli per la tabella CASO
ALTER TABLE CASO AS
(
    -- Vincolo di chiave primaria
    CONSTRAINT PK_CASO PRIMARY KEY (CodCaso),
    
    -- Vincolo di chiave esterna
    CONSTRAINT FK_AVVENTORE_POSITIVO FOREIGN KEY (AvventorePositivo) REFERENCES AVVENTORE(NumCid),
    
    -- Vincolo di chiave esterna
   CONSTRAINT FK_CAMERIERE_POSITIVO FOREIGN KEY (CamerierePositivo) REFERENCES CAMERIERE(CodCameriere),
   
   -- Vincolo di chiave esterna
    CONSTRAINT FK_REGISTRA_PROPRIETARIO FOREIGN KEY (RegistraProprietario) REFERENCES PROPRIETARIO(CodProprietario),
    
    -- Vincolo di chiave esterna
   CONSTRAINT FK_REGISTRA_MANAGER FOREIGN KEY (RegistraManager) REFERENCES MANAGERRISTORANTE(CodManager)
   
  
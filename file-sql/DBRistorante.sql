
-- Crea la tabella PROPRIETARIO
CREATE TABLE PROPRIETARIO
(
	CodProprietario	INTEGER		  GENERATED BY DEFAULT AS IDENTITY,
	Username		VARCHAR2(64)  NOT NULL,	
	Password 		VARCHAR2(64)  NOT NULL,
	Nome			VARCHAR2(64)  NOT NULL,
	Cognome			VARCHAR2(64)  NOT NULL,
	Email			VARCHAR(320)  DEFAULT NULL  
);

-- Definizione dei vincoli per la tabella PROPRIETARIO
ALTER TABLE PROPRIETARIO ADD
(
	--Vincolo di chiave primaria
	CONSTRAINT PK_PROPRIETARIO PRIMARY KEY (CodProprietario),
	
	--Vincolo Email legale
	CONSTRAINT Email_legale CHECK (Email LIKE '_%@_%.__%' OR Email IS NULL),
	
	--Vincolo Unico username proprietario
	CONSTRAINT Unico_username_proprietario UNIQUE (Username)
	
);

--Trigger Password_legale 
CREATE OR REPLACE TRIGGER Password_legale
BEFORE INSERT OR UPDATE ON PROPRIETARIO
FOR EACH ROW
DECLARE

password_okay INTEGER; 

BEGIN
	
	-- Controlla se la password contiene almeno una lettera ed un numero 
	IF REGEXP_LIKE(:NEW.Password,'^.*[A-Z].*$') AND REGEXP_LIKE(:NEW.Password,'^.*[0-9].*$') THEN
		password_okay := 1;
	ELSE
		password_okay := 0; -- La password non contiene almeno una lettera ed un numero 
	END IF;
	
	/* Se la password inserita è lunga meno di 8 caratteri o 
	non contiene almeno una lettera ed un numero 
	allora non è valida */
	IF (LENGTH(:NEW.Password)<8) OR (password_okay = 0) THEN
		RAISE_APPLICATION_ERROR(-20010,'Password non valida. Deve contenere almeno 8 caratteri, una lettera ed un numero!');
	END IF;
	
END;


--Trigger SetUpper_Nome_Cognome
CREATE OR REPLACE TRIGGER SetUpper_Nome_Cognome
BEFORE INSERT OR UPDATE ON PROPRIETARIO
FOR EACH ROW
 
BEGIN

	--Setta la stringa relativa a Nome tutta in maiuscolo
	:NEW.Nome := UPPER(:NEW.Nome);
	
	--Setta la stringa relativa a Cognome tutta in maiuscolo
	:NEW.Cognome := UPPER(:NEW.Cognome);
	
END;

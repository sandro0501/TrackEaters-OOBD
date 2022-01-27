--FUNZIONI E PROCEDURE DEL DB
/*============================================================================================*/
/*============================================================================================*/
-- 1. Funzione IS_NUMBER il cui scopo è quello di verificare che una stringa inserita contenga solo caratteri numerici
CREATE FUNCTION IS_NUMBER (stringa IN VARCHAR2) RETURN INT
IS
valorenumerico NUMBER;
BEGIN
	-- Converte da valore numerico a stringa e ritorna 1
	valorenumerico := TO_NUMBER(stringa);
	RETURN 1;
	
	-- Se fallisce la conversione, errore e ritorna 0
	EXCEPTION WHEN VALUE_ERROR THEN
	RETURN 0;
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- 2. Procedure Numero di telefono legale (viene riutilizzata più volte nei trigger) 
CREATE PROCEDURE NUMERO_DI_TELEFONO_LEGALE (numerotelefonico IN VARCHAR2) 
IS 
stringa VARCHAR2(15);
BEGIN

	-- Rimuove inizialmente tutti gli spazi, se presenti, dalla stringa del numero telefonico
	-- per effettuare il successivo controllo
    stringa := REPLACE(numerotelefonico,' ','');
	
	-- Se presente un prefisso nel numero telefonico con il carattere +, rimuove quest'ultimo
	-- per effettuare il successivo controllo 
	IF stringa LIKE '+%' THEN
		stringa := TRIM('+' FROM stringa);
	END IF;
	
	-- Controlla che i restanti caratteri associati al numero telefonico siano numeri. 
	-- Se il controllo fallisce, è presente un carattere diverso da un numero 
	-- quindi il numero di telefono non è valido.
	IF (is_number(stringa)=0) THEN
		RAISE_APPLICATION_ERROR(-20010,'Numero di telefono non valido.');
	END IF;
END;
/
/*============================================================================================*/
/*============================================================================================*/
-- 3. Procedure Password legale (viene riutilizzata più volte nei trigger)
CREATE PROCEDURE PASSWORD_LEGALE (password IN VARCHAR2) 
IS 
password_okay INTEGER; 
BEGIN
	-- Controlla se la password contiene almeno una lettera ed un numero 
	IF REGEXP_LIKE(password,'^.*[A-Z].*$') AND REGEXP_LIKE(password,'^.*[0-9].*$') THEN
		password_okay := 1;
	ELSE
		password_okay := 0; -- La password non contiene almeno una lettera ed un numero 
	END IF;
	
	-- Se la password inserita è lunga meno di 8 caratteri o 
	-- non contiene almeno una lettera ed un numero allora non è valida
	IF (LENGTH(password) < 8) OR (password_okay = 0) THEN
		RAISE_APPLICATION_ERROR(-20011,'Password non valida. 
		Deve contenere almeno 8 caratteri, una lettera ed un numero!');
	END IF;
END;
/
/*============================================================================================*/
/*============================================================================================*/

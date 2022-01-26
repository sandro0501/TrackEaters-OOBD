-- QUERY DA EFFETTUARE SUL DB 
 
/* Numero giornaliero totale di avventori per ristorante	
La query, dato un determinato ristorante e specificata una data, 
calcola il numero giornaliero totale di avventori 
che sono stati accolti dal ristorante in quella data.
Supponiamo che il ristorante dato abbia CodRistorante=1 e la DataArrivo='17/11/2021'. */

SELECT T.DataArrivo AS DATA, COUNT(A.NumCid) AS TOT_GIORNALIERO_AVVENTORI
FROM Avventore A JOIN Tavolata T ON A.Tavolata = T.CodTavolata 
WHERE A.Ristorante = 1 AND T.DataArrivo = TO_DATE('17/11/2021', 'dd/mm/yyyy')
GROUP BY T.DataArrivo;

/*============================================================================================*/
/*============================================================================================*/

/* Numero mensile totale di avventori per ristorante
La query, dato un determinato ristorante e specificato un mese, 
calcola il numero mensile totale di avventori che sono stati accolti dal ristorante in quel mese. */

SELECT  TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, TO_CHAR(T.DataArrivo, 'mm') AS MESE, COUNT(A.NumCid)AS Numero_Avventori_Mese
FROM    AVVENTORE A JOIN TAVOLATA T ON A.Tavolata=T.CodTavolata
WHERE   A.Ristorante = 3 AND TO_CHAR(T.DataArrivo, 'yyyy')=2021 AND TO_CHAR(T.DataArrivo, 'mm')=12
GROUP BY TO_CHAR(T.DataArrivo, 'yyyy'), TO_CHAR(T.DataArrivo, 'mm');

/*============================================================================================*/
/*============================================================================================*/

/* Numero giornaliero totale di avventori per tutti i ristoranti di un proprietario	
La query, dato un determinato proprietario e specificata una data, 
calcola il numero giornaliero totale di avventori che sono stati accolti da tutti i ristoranti 
amministrati dal proprietario, in quella data. */

SELECT  R.CodRistorante Ristorante, COUNT(A.NumCid) Numero
FROM    (RISTORANTE R JOIN AVVENTORE A 
        ON R.CodRistorante=A.Ristorante) JOIN TAVOLATA T 
        ON A.Tavolata=T.CodTavolata
WHERE   R.Proprietario=1 AND T.DataArrivo=TO_DATE('22/11/2021', 'dd/mm/yyyy')
GROUP   BY R.CodRistorante; 

/*============================================================================================*/
/*============================================================================================*/

/* Numero mensile totale di avventori per tutti i ristoranti 
di un proprietario	La query, dato un determinato proprietario 
e specificato un mese, calcola il numero mensile totale di avventori 
che sono stati accolti da tutti i ristoranti amministrati dal proprietario, 
in quel mese. */

SELECT   R.CodRistorante Ristorante, COUNT(A.NumCid) Numero_Avventori
FROM    (RISTORANTE R JOIN AVVENTORE A 
        ON R.CodRistorante=A.Ristorante) JOIN TAVOLATA T 
        ON A.Tavolata=T.CodTavolata
WHERE   R.Proprietario=1 AND TO_CHAR(T.DataArrivo, 'yyyy')=2021 AND TO_CHAR(T.DataArrivo, 'mm')=11
GROUP   BY R.CodRistorante; 

/*============================================================================================*/
/*============================================================================================*/

/* Casi positivi giornalieri di un ristorante
La query, dato un determinato ristorante e specificata una data, 
calcola il numero giornaliero totale di avventori risultati positivi nel ristorante in quella data.*/

SELECT  T.DataArrivo Data, COUNT(C.AvventorePositivo) Numero_Positivi
FROM    (TAVOLATA T JOIN AVVENTORE A 
        ON T.CodTavolata=A.Tavolata) JOIN CASO C 
        ON A.NumCid=C.AvventorePositivo
WHERE T.DataArrivo=TO_DATE('22/11/2021', 'dd/mm/yyyy')
GROUP BY T.DataArrivo;

/*============================================================================================*/
/*============================================================================================*/

/* Casi positivi mensili di un ristorante
La query, dato un determinato ristorante e specificato un mese, 
calcola il numero mensile di avventori risultati positivi nel ristorante in quel mese. */

SELECT  TO_CHAR(T.DataArrivo, 'yyyy') Anno, TO_CHAR(T.DataArrivo, 'mm') Mese, COUNT(C.AvventorePositivo) Numero_Positivi
FROM    (TAVOLATA T JOIN AVVENTORE A 
        ON T.CodTavolata=A.Tavolata) JOIN CASO C 
        ON A.NumCid=C.AvventorePositivo
WHERE TO_CHAR(T.DataArrivo, 'yyyy')= 2021 AND TO_CHAR(T.DataArrivo, 'mm')=11
GROUP BY TO_CHAR(T.DataArrivo, 'yyyy'), TO_CHAR(T.DataArrivo, 'mm');

/*============================================================================================*/
/*============================================================================================*/

/* Casi positivi annuali di un ristorante
La query, dato un determinato ristorante e specificato un anno, 
calcola il numero annuale di avventori risultati positivi nel ristorante in quell'anno.*/

SELECT  TO_CHAR(T.DataArrivo, 'yyyy') Anno, COUNT(C.AvventorePositivo) Numero_Positivi
FROM    (TAVOLATA T JOIN AVVENTORE A 
        ON T.CodTavolata=A.Tavolata) JOIN CASO C 
        ON A.NumCid=C.AvventorePositivo
WHERE TO_CHAR(T.DataArrivo, 'yyyy')= 2021
GROUP BY TO_CHAR(T.DataArrivo, 'yyyy');

/*============================================================================================*/
/*============================================================================================*/

/* Casi positivi giornalieri per tutti i ristoranti di un proprietario
La query, dato un determinato proprietario e specificata una data, 
calcola il numero giornaliero totale di avventori risultati positivi 
nei ristoranti da lui amministrati. */

SELECT  R.CodRistorante Ristorante, COUNT(C.AvventorePositivo) Numero_Positivi
FROM    ((TAVOLATA T JOIN AVVENTORE A 
        ON T.CodTavolata=A.Tavolata) JOIN CASO C 
        ON A.NumCid=C.AvventorePositivo) JOIN RISTORANTE R
        ON A.Ristorante=R.CodRistorante
WHERE   R.Proprietario=1 AND T.DataArrivo=TO_DATE('17/11/2021', 'dd/mm/yyyy')
GROUP BY R.CodRistorante;

/*============================================================================================*/
/*============================================================================================*/
-- Casi positivi mensili per tutti i ristoranti di un proprietario
SELECT TO_CHAR(C.DataRegistrazione,'mm  ') AS MESE, TO_CHAR(C.DataRegistrazione,'yyyy') AS ANNO, COUNT(C.CodCaso) AS TOT_AVVENTORI_POSITIVI
FROM Caso C JOIN Avventore A ON C.AvventorePositivo = A.NumCid JOIN Ristorante R ON R.CodRistorante = A.Ristorante
WHERE R.Proprietario = 1 AND TO_CHAR(C.DataRegistrazione,'mm')= 01 AND TO_CHAR(C.DataRegistrazione,'yyyy')= 2022
GROUP BY TO_CHAR(C.DataRegistrazione,'mm  '), TO_CHAR(C.DataRegistrazione,'yyyy');

/*============================================================================================*/
/*============================================================================================*/

-- Casi positivi annuali per tutti i ristoranti di un proprietario
SELECT TO_CHAR(C.DataRegistrazione,'yyyy') AS ANNO, COUNT(C.CodCaso) AS TOT_AVVENTORI_POSITIVI
FROM Caso C JOIN Avventore A ON C.AvventorePositivo = A.NumCid JOIN Ristorante R ON R.CodRistorante = A.Ristorante
WHERE R.Proprietario = 1 AND TO_CHAR(C.DataRegistrazione,'yyyy')= 2022
GROUP BY TO_CHAR(C.DataRegistrazione,'yyyy');

/*============================================================================================*/
/*============================================================================================*/

-- Informazioni sugli avventori risultati positivi in un ristorante
SELECT C.CodCaso, C.DataRegistrazione AS DATAR, A.NumCid, CAST(A.Nome AS VARCHAR2(30)) AS Nome, CAST(A.Cognome AS VARCHAR2(30)) AS Cognome, 
A.DataN, A.Telefono, A.HaGreenpass AS G , T.CodTavolata, T.DataArrivo, T.Cameriere, T.Tavolo, TA.TavoloAdiacente 
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid JOIN TAVOLATA T ON T.CodTavolata = A.Tavolata JOIN TAVOLO TA ON TA.CodTavolo = T.Tavolo
WHERE A.Ristorante = 1;

/*============================================================================================*/
/*============================================================================================*/

-- Informazioni sui camerieri risultati positivi in un ristorante
SELECT C.CodCaso, C.DataRegistrazione AS DATAR, C.StatoCaso, CA.NumCid, CA.Nome, CA.Cognome, CA.DataN, CA.Sesso, CA.Telefono
FROM CAMERIERE CA JOIN CASO C ON CA.NumCid = C.CamerierePositivo
WHERE CA.Ristorante = 1;

/*============================================================================================*/
/*============================================================================================*/

--Avventori positivi con o senza green pass 
SELECT COUNT(C.CodCaso) AS POSITIVI_CON_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
WHERE A.HaGreenpass='V';

SELECT COUNT(C.CodCaso) AS POSITIVI_SENZA_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
WHERE A.HaGreenpass='F';

/*============================================================================================*/
/*============================================================================================*/

--Numero di avventori medio per tavolata di un ristorante
--1.Si crea la vista "Tavolate" che per ogni tavolata di un ristorante calcola il numero totale di partecipanti alla tavolata. 
CREATE VIEW TAVOLATE (Ristorante, CodiceTavolata, Partecipanti) AS
SELECT A.Ristorante, A.Tavolata, COUNT(A.NumCid) AS TOT_TAVOLATA
FROM AVVENTORE A JOIN TAVOLATA T ON A.Tavolata = T.CodTavolata
GROUP BY A.Ristorante, A.Tavolata
ORDER BY A.Tavolata ASC;
--2.Si esegue la seguente query sulla vista, 
-- supponendo di voler conoscere la media di avventori per tavolata del ristorante di CodRistorante = 2; 
SELECT T.Ristorante, AVG(T.Partecipanti) AS MEDIA_AVVENTORI_PER_TAVOLATA
FROM TAVOLATE T
WHERE T.Ristorante = 2;
GROUP BY T.Ristorante;

/*============================================================================================*/
/*============================================================================================*/

-- Avventori e camerieri risultati positivi in una stessa tavolata di un ristorante 

/*============================================================================================*/
/*============================================================================================*/

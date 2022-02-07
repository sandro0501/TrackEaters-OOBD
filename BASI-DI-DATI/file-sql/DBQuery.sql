-- QUERY IMPLEMENTATE DA POTER EFFETTUARE SUL DB 
 
-- 1.Numero giornaliero di avventori per ristorante
-- Supponiamo che il ristorante dato abbia CodRistorante = 1 e la DataArrivo = '17/11/2021'.
SELECT R.Denominazione AS RISTORANTE, T.DataArrivo AS DATA, COUNT(ACC.Avventore) AS TOT_GIORNALIERO_AVVENTORI
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid 
				  JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata 
WHERE R.CodRistorante = 1 AND T.DataArrivo = TO_DATE('17/11/2021','dd/mm/yyyy')
GROUP BY R.Denominazione, T.DataArrivo;
/*============================================================================================*/
/*============================================================================================*/
-- 2.Numero mensile di avventori per ristorante
-- Supponiamo che il ristorante dato abbia CodRistorante = 1 e il mese di riferimento sia 11/2021
SELECT R.Denominazione AS RISTORANTE, TO_CHAR(T.DataArrivo, 'mm  ') AS MESE, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
	   COUNT(ACC.Avventore) AS TOT_MENSILE_AVVENTORI
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid 
				  JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata 
WHERE R.CodRistorante = 1 AND TO_CHAR(T.DataArrivo,'yyyy') = 2021 AND TO_CHAR(T.DataArrivo,'mm') = 11
GROUP BY R.Denominazione, TO_CHAR(T.DataArrivo,'mm  '),TO_CHAR(T.DataArrivo,'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 3.Numero giornaliero di avventori per tutti i ristoranti di un proprietario
-- Supponiamo che il proprietario abbia CodProprietario = 1 e la DataArrivo = '17/11/2021'
SELECT R.Proprietario, T.DataArrivo AS DATA, COUNT(ACC.Avventore) AS TOT_GIORNALIERO_AVVENTORI_RISTORANTI
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid 
				  JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata 
WHERE R.Proprietario = 1 AND T.DataArrivo = TO_DATE('17/11/2021','dd/mm/yyyy')
GROUP BY R.Proprietario, T.DataArrivo;
/*============================================================================================*/
/*============================================================================================*/
-- 4.Numero mensile di avventori per tutti i ristoranti di un proprietario	
-- Supponiamo che il proprietario abbia CodProprietario = 1 e il mese di riferimento sia 11/2021
SELECT R.Proprietario, TO_CHAR(T.DataArrivo, 'mm  ') AS MESE, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
	   COUNT(ACC.Avventore) AS TOT_MENSILE_AVVENTORI_RISTORANTI
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid 
				  JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata 
WHERE R.Proprietario = 1 AND TO_CHAR(T.DataArrivo,'mm') = 11 AND TO_CHAR(T.DataArrivo, 'yyyy') = 2021 
GROUP BY R.Proprietario, TO_CHAR(T.DataArrivo,'mm  '),TO_CHAR(T.DataArrivo,'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 5.Casi positivi di un determinato ristorante per data di arrivo della tavolata
-- Supponiamo che il codice del ristorante sia CodRistorante = 1 e che la data di arrivo della tavolata sia il: '17/11/2021'
SELECT R.Denominazione AS RISTORANTE, T.DataArrivo AS DATA_ARV, 
	   COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.CodRistorante = 1 AND T.DataArrivo = TO_DATE('17/11/2021','dd/mm/yyyy')
GROUP BY R.Denominazione, T.DataArrivo;
/*============================================================================================*/
/*============================================================================================*/
-- 6.Casi positivi di un determinato ristorante per mese di arrivo della tavolata
-- Supponiamo che il codice del ristorante sia CodRistorante = 1 e che il mese di arrivo della tavolata sia 11/2021
SELECT R.Denominazione AS RISTORANTE, TO_CHAR(T.DataArrivo, 'mm  ') AS MESE, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
	   COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.CodRistorante = 1 AND TO_CHAR(T.DataArrivo,'mm') = 11 AND TO_CHAR(T.DataArrivo, 'yyyy') = 2021 
GROUP BY R.Denominazione, TO_CHAR(T.DataArrivo, 'mm  '), TO_CHAR(T.DataArrivo, 'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 7.Casi positivi di un determinato ristorante per anno di arrivo della tavolata
-- Supponiamo che il codice del ristorante sia CodRistorante = 1 e che l'anno di arrivo della tavolata sia il 2021
SELECT R.Denominazione AS RISTORANTE, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
	   COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.CodRistorante = 1 AND TO_CHAR(T.DataArrivo, 'yyyy') = 2021 
GROUP BY R.Denominazione, TO_CHAR(T.DataArrivo, 'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 8.Casi positivi di tutti i ristoranti di un proprietario per data di arrivo della tavolata
-- Supponiamo che il codice del proprietario sia CodProprietario = 1 e che la data di arrivo della tavolata sia il: '17/11/2021'
SELECT R.Proprietario, T.DataArrivo AS DATA_ARV, 
	   COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI_RISTORANTI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.Proprietario = 1 AND T.DataArrivo = TO_DATE('17/11/2021','dd/mm/yyyy')
GROUP BY R.Proprietario, T.DataArrivo;
/*============================================================================================*/
/*============================================================================================*/
-- 9.Casi positivi di tutti i ristoranti di un proprietario per mese di arrivo della tavolata 
-- Supponiamo che il codice del proprietario sia CodProprietario = 1 e che il mese di arrivo della tavolata sia 11/2021
SELECT R.Proprietario, TO_CHAR(T.DataArrivo, 'mm  ') AS MESE, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
       COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI_RISTORANTI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.Proprietario = 1 AND TO_CHAR(T.DataArrivo,'mm') = 11 AND TO_CHAR(T.DataArrivo, 'yyyy') = 2021 
GROUP BY R.Proprietario, TO_CHAR(T.DataArrivo, 'mm  '), TO_CHAR(T.DataArrivo, 'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 10.Casi positivi di tutti i ristoranti di un proprietario per anno di arrivo della tavolata 
-- Supponiamo che il codice del proprietario sia CodProprietario = 1 e che l'anno di arrivo della tavolata sia il 2021
SELECT R.Proprietario, TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, 
	   COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI_RISTORANTI
FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante 
				  JOIN CASO C ON C.AvventorePositivo = A.Avventore 
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
WHERE R.Proprietario = 1 AND TO_CHAR(T.DataArrivo, 'yyyy') = 2021 
GROUP BY R.Proprietario, TO_CHAR(T.DataArrivo, 'yyyy');
/*============================================================================================*/
/*============================================================================================*/
-- 11.Informazioni sugli avventori risultati positivi in un ristorante
-- Supponiamo che il codice del ristorante che ha accolto gli avventori risultati positivi sia CodRistorante = 1
SELECT C.CodCaso, C.DataRegistrazione AS DATAR, CAST(R.Denominazione AS VARCHAR2(20)) AS RISTORANTE,
	   A.NumCid, CAST(A.Nome AS VARCHAR2(30)) AS Nome, CAST(A.Cognome AS VARCHAR2(30)) AS Cognome, A.DataN, 
	   A.Telefono, A.HaGreenpass AS G , T.CodTavolata, T.DataArrivo, T.Cameriere, T.Tavolo, TAV.Sala
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN CASO C ON C.AvventorePositivo = A.NumCid
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
				  JOIN TAVOLO TAV ON TAV.CodTavolo = T.Tavolo  
WHERE R.CodRistorante = 1
ORDER BY C.CodCaso;
/*============================================================================================*/
/*============================================================================================*/
-- 12.Informazioni sugli avventori risultati positivi in tutti i ristoranti di un proprietario 
-- Supponiamo che il codice del proprietario dei ristoranti sia CodProprietario = 1
SELECT C.CodCaso, C.DataRegistrazione AS DATAR, CAST(R.Denominazione AS VARCHAR2(20)) AS RISTORANTE,
	   A.NumCid, CAST(A.Nome AS VARCHAR2(30)) AS Nome, CAST(A.Cognome AS VARCHAR2(30)) AS Cognome, A.DataN, 
	   A.Telefono, A.HaGreenpass AS G , T.CodTavolata, T.DataArrivo, T.Cameriere, T.Tavolo, TAV.Sala
FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante 
				  JOIN AVVENTORE A ON A.NumCid = ACC.Avventore 
				  JOIN CASO C ON C.AvventorePositivo = A.NumCid
				  JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo
				  JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata
				  JOIN TAVOLO TAV ON TAV.CodTavolo = T.Tavolo  
WHERE R.Proprietario = 1
ORDER BY C.CodCaso;
/*============================================================================================*/
/*============================================================================================*/
-- 13.Informazioni sui camerieri risultati positivi in un ristorante
-- Supponiamo che il codice del ristorante per cui lavorano i camerieri risultati positivi sia CodRistorante = 1
SELECT CA.CodCaso, CA.DataRegistrazione AS DATAR, 
	   CAST(R.Denominazione AS VARCHAR2(20)) AS RISTORANTE, 
	   C.NumCid, CAST(C.Nome AS VARCHAR2(30)) AS Nome, 
	   CAST(C.Cognome AS VARCHAR2(30)) AS Cognome, 
	   C.DataN, C.Telefono
FROM RISTORANTE R JOIN CAMERIERE C ON R.CodRistorante = C.Ristorante 
				  JOIN CASO CA ON CA.CamerierePositivo = C.NumCid 
WHERE C.Ristorante = 1
ORDER BY CA.CodCaso;
/*============================================================================================*/
/*============================================================================================*/
-- 14.Informazioni sui camerieri risultati positivi in tutti i ristoranti di un proprietario 
-- Supponiamo che il codice del proprietario dei ristoranti sia CodProprietario = 1
SELECT CA.CodCaso, CA.DataRegistrazione AS DATAR, 
	   CAST(R.Denominazione AS VARCHAR2(20)) AS RISTORANTE, 
	   C.NumCid, CAST(C.Nome AS VARCHAR2(30)) AS Nome, 
	   CAST(C.Cognome AS VARCHAR2(30)) AS Cognome, 
	   C.DataN, C.Telefono
FROM RISTORANTE R JOIN CAMERIERE C ON R.CodRistorante = C.Ristorante 
				  JOIN CASO CA ON CA.CamerierePositivo = C.NumCid 
WHERE R.Proprietario = 1
ORDER BY CA.CodCaso;
/*============================================================================================*/
/*============================================================================================*/
-- 15.Avventori positivi con o senza green pass 
-- Per ristorante: supponiamo che CodRistorante = 1 
SELECT COUNT(C.CodCaso) AS AVVENTORI_POSITIVI_CON_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
            JOIN ACCOGLIENZA ACC ON ACC.Avventore = A.NumCid 
WHERE A.HaGreenpass='V' AND ACC.Ristorante = 1;

SELECT COUNT(C.CodCaso) AS AVVENTORI_POSITIVI_SENZA_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
            JOIN ACCOGLIENZA ACC ON ACC.Avventore = A.NumCid 
WHERE A.HaGreenpass='F' AND ACC.Ristorante = 1;

-- Per proprietario: supponiamo che CodProprietario = 1 
SELECT COUNT(C.CodCaso) AS AVVENTORI_POSITIVI_CON_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
            JOIN ACCOGLIENZA ACC ON ACC.Avventore = A.NumCid 
			JOIN RISTORANTE R ON R.CodRistorante = ACC.Ristorante
WHERE A.HaGreenpass='V' AND R.Proprietario = 1;

SELECT COUNT(C.CodCaso) AS AVVENTORI_POSITIVI_SENZA_GREENPASS
FROM CASO C JOIN AVVENTORE A ON C.AvventorePositivo = A.NumCid 
            JOIN ACCOGLIENZA ACC ON ACC.Avventore = A.NumCid 
			JOIN RISTORANTE R ON R.CodRistorante = ACC.Ristorante
WHERE A.HaGreenpass='F' AND R.Proprietario = 1;
/*============================================================================================*/
/*============================================================================================*/
-- 16.Numero di avventori medio per tavolata di un ristorante 
-- Supponendo di voler conoscere la media di avventori per tavolata del ristorante di CodRistorante = 2
-- Utilizziamo la vista RIEPILOGO_TAVOLATE_RISTORANTI_PROPRIETARIO
SELECT T.CodRistorante, T.Ristorante,  AVG(T.PartecipantiTavolata) AS MEDIA_AVVENTORI_PER_TAVOLATA
FROM RIEPILOGO_TAVOLATE_RISTORANTI_PROPRIETARIO T 
WHERE T.CodRistorante = 2
GROUP BY T.CodRistorante, T.Ristorante;
/*============================================================================================*/
/*============================================================================================*/
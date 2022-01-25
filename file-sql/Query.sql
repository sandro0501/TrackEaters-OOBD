-- QUERY DA EFFETTUARE SUL DB 

-- Query 1: 
/* Numero giornaliero totale di avventori per ristorante	
La query, dato un determinato ristorante e specificata una data, 
calcola il numero giornaliero totale di avventori 
che sono stati accolti dal ristorante in quella data.
Supponiamo che il ristorante dato abbia CodRistorante=1 e la DataArrivo='17/11/2021'. */

SELECT 	COUNT(A.NumCid) AS numero_giornaliero_avventori
FROM 	Avventore A JOIN Tavolata T ON A.Tavolata=T.CodTavolata 
WHERE 	A.Ristorante=1 AND T.DataArrivo=TO_DATE('17/11/2021', 'dd/mm/yyyy');

/*============================================================================================*/
/*============================================================================================*/

-- Query 2: 
/* Numero mensile totale di avventori per ristorante
La query, dato un determinato ristorante e specificato un mese, 
calcola il numero mensile totale di avventori che sono stati accolti dal ristorante in quel mese. */

SELECT  TO_CHAR(T.DataArrivo, 'yyyy') AS ANNO, TO_CHAR(T.DataArrivo, 'mm') AS MESE, COUNT(A.NumCid)AS Numero_Avventori_Mese
FROM    AVVENTORE A JOIN TAVOLATA T ON A.Tavolata=T.CodTavolata
WHERE   A.Ristorante = 3 AND TO_CHAR(T.DataArrivo, 'yyyy')=2021 AND TO_CHAR(T.DataArrivo, 'mm')=12
GROUP BY TO_CHAR(T.DataArrivo, 'yyyy'), TO_CHAR(T.DataArrivo, 'mm');

/*============================================================================================*/
/*============================================================================================*/

--Query 3: 
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

--Query 4: 
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

--Query 5:

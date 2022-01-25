-- QUERY DA EFFETTUARE SUL DB 

-- Query 1: Numero giornaliero totale di avventori per ristorante	
/* La query, dato un determinato ristorante e specificata una data, 
calcola il numero giornaliero totale di avventori 
che sono stati accolti dal ristorante in quella data.
Supponiamo che il ristorante dato abbia CodRistorante=1 e la DataArrivo='17/11/2021'. */
SELECT 	COUNT(A.NumCid) AS numero_giornaliero_avventori
FROM 	Avventore A JOIN Tavolata T ON A.Tavolata=T.CodTavolata 
WHERE 	A.Ristorante=1 AND T.DataArrivo=TO_DATE('17/11/2021', 'dd/mm/yyyy');

/*============================================================================================*/
/*============================================================================================*/

-- Query 2: Numero mensile totale di avventori per ristorante
/* La query, dato un determinato ristorante e specificato un mese, 
calcola il numero mensile totale di avventori che sono stati accolti dal ristorante in quel mese. */


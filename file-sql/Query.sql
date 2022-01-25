--Numero giornaliero totale di avventori per ristorante	
/*La query, dato un determinato ristorante e specificata una data, 
calcola il numero giornaliero totale di avventori 
che sono stati accolti dal ristorante in quella data.*/
SELECT 	COUNT(A.NumCid)
FROM 	(RISTORANTE R JOIN AVVENTORE A ON R.CodRistorante=A.Ristorante) 
		JOIN TAVOLATA T ON A.Tavolata=T.CodTavolata
WHERE 	R.CodRistorante=3 AND T.DataArrivo=TO_DATE('25/12/2021', 'dd/mm/yyyy');
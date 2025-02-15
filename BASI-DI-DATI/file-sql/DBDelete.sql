-- SCRIPT DELETE RISTORANTE
/*============================================================================================*/
/*============================================================================================*/
-- Script 1: Cancella i dati da tutte le tabelle del DB Ristorante 
DELETE FROM PROPRIETARIO;
DELETE FROM RISTORANTE; 
DELETE FROM MANAGERRISTORANTE;
DELETE FROM SALA; 
DELETE FROM CAMERIERE; 
DELETE FROM TAVOLO;
DELETE FROM ADIACENZATAVOLO;
DELETE FROM TAVOLATA;
DELETE FROM AVVENTORE;
DELETE FROM ACCOGLIENZA;
DELETE FROM PARTECIPAZIONETAVOLATA;
DELETE FROM CASO;
COMMIT; 
/*============================================================================================*/
/*============================================================================================*/
-- Script 2: Cancella le procedure e funzioni del DB Ristorante  
DROP PROCEDURE NUMERO_DI_TELEFONO_LEGALE;
DROP PROCEDURE PASSWORD_LEGALE;
DROP FUNCTION IS_NUMBER;
COMMIT; 
/*============================================================================================*/
/*============================================================================================*/
-- Script 3: Cancella tutte le viste del DB Ristorante 
DROP VIEW RIEPILOGO_RISTORANTI_PROPRIETARIO;
DROP VIEW RIEPILOGO_TAVOLATE_RISTORANTI_PROPRIETARIO;
DROP VIEW RIEPILOGO_AVVENTORI_RISTORANTI;
COMMIT;
/*============================================================================================*/
/*============================================================================================*/
-- Script 4: Cancella tutte le tabelle del DB RISTORANTE
DROP TABLE PROPRIETARIO CASCADE CONSTRAINTS;
DROP TABLE RISTORANTE CASCADE CONSTRAINTS;
DROP TABLE MANAGERRISTORANTE CASCADE CONSTRAINTS;
DROP TABLE SALA CASCADE CONSTRAINTS;
DROP TABLE CAMERIERE CASCADE CONSTRAINTS;
DROP TABLE TAVOLO CASCADE CONSTRAINTS;
DROP TABLE ADIACENZATAVOLO CASCADE CONSTRAINTS;
DROP TABLE TAVOLATA CASCADE CONSTRAINTS;
DROP TABLE AVVENTORE CASCADE CONSTRAINTS;
DROP TABLE ACCOGLIENZA CASCADE CONSTRAINTS;
DROP TABLE PARTECIPAZIONETAVOLATA CASCADE CONSTRAINTS;
DROP TABLE CASO CASCADE CONSTRAINTS;
COMMIT; 
/*============================================================================================*/
/*============================================================================================*/

@echo off
net start OracleOraDB19Home1MTSRecoveryService
net start OracleOraDB19Home1TNSListener
net start OracleVssWriterORCL
net start OracleServiceORCL
echo Tutti i servizi sono stati avviati correttamente
pause
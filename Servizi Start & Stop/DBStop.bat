@echo off
net STOP OracleOraDB19Home1MTSRecoveryService
net STOP OracleOraDB19Home1TNSListener
net STOP OracleVssWriterORCL
net STOP OracleServiceORCL
echo Tutti i servizi sono stati arrestati correttamente
pause
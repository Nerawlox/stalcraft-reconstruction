@echo off
powershell.exe -NoProfile -File "%~dp0start-local.ps1"
if errorlevel 1 pause

@echo off
setlocal
set VERSION=8.10.2
set BASE=%USERPROFILE%\.gradle\wrapper\dists\gradle-%VERSION%-bin\manual
set GRADLE=%BASE%\gradle-%VERSION%\bin\gradle.bat
if not exist "%GRADLE%" (
  if not exist "%BASE%" mkdir "%BASE%"
  powershell -NoProfile -ExecutionPolicy Bypass -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest 'https://services.gradle.org/distributions/gradle-%VERSION%-bin.zip' -OutFile '%BASE%\gradle.zip'; Expand-Archive -Force '%BASE%\gradle.zip' '%BASE%'; Remove-Item '%BASE%\gradle.zip'"
)
call "%GRADLE%" %*

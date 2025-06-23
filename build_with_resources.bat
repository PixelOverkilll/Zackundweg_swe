@echo off
REM Compile Java sources
if not exist out mkdir out
javac -d out src/*.java
if %errorlevel% neq 0 exit /b %errorlevel%

REM Copy resources to output directory
copy /Y Bank2.png out\
copy /Y BankIcon.png out\
copy /Y start.gif out\
copy /Y Bild_2025-05-16_224321331.png out\

REM Create executable JAR with resources
cd out
jar cfe ../Zackundweg_executable.jar Main *.class Bank2.png BankIcon.png start.gif Bild_2025-05-16_224321331.png
cd ..

echo Build complete. Run with: java -jar Zackundweg_executable.jar

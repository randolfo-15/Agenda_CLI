# Author: Randolfo A Goncalves
# date:   21-03-24

# Sistema de compilação rápida para java
# ======================================
all: program# Programa Main 

files = ./src/*.java         #  path sources
binarys= ./.bin/*.class      #  path binarys
manifest= ./src/MANIFEST.MF  #  path manifest file

# Build default:
program: $(files)
	javac -d .bin $(files) 

# Clear solution: 
clear: 
	rm $(binarys)

# Execute program:
run: 
	java -cp ".:.bin/" Agenda

# .Jar:
jar: 
	jar cfm Agenda.jar $(manifest) $(binarys)

all:
	clear
	javac TestDrive.java
run:all
	clear
	java TestDrive
clean:
	rm *.class \Items/*.class
	clear
crun:
	clear
	javac TestDrive.java
	java TestDrive

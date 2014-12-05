all:
	clear
	javac TestDrive.java
clean:
	rm *.class \Items/*.class
	clear
crun:
	clear
	javac TestDrive.java
	java TestDrive

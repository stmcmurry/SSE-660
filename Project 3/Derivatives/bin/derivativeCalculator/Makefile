jar: classes
	jar cfv jcm.jar `find . -name "*.class"`

classes: clean
	javac -target 1.1 -source 1.3 `find . -name "*.java"`

clean:
	rm -f `find . -name "*.class"`





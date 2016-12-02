java -jar antlr-4.5.3-complete.jar DrawingBoard.in
javac *.java
java org.antlr.v4.gui.TestRig DrawingBoard start -tree < %*

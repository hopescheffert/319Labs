java -jar ./antlr-4.5.3-complete.jar DrawingBoard.g4
javac -cp ".:./antlr-4.5.3-complete.jar" *.java
java -cp ".:./antlr-4.5.3-complete.jar" org.antlr.v4.gui.TestRig DrawingBoard start -tree < %*

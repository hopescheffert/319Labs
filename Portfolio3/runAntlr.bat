java -jar ../antlr-4.4-complete.jar %*
javac *.java
java org.antlr.v4.runtime.misc.TestRig $*

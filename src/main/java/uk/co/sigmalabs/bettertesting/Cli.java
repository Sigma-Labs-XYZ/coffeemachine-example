package uk.co.sigmalabs.bettertesting;

import java.util.Scanner;

public class Cli {

    private final Scanner scanner = new Scanner(System.in);
    private final Printer printer = new Printer();

    public int askAndAnswerNumber(String question) {
        printer.writeln(question);
        return scanner.nextInt();
    }

    public String askAndAnswer(String question) {
        printer.writeln(question);
        return scanner.next();
    }
    public void writeln(String text) {
        printer.writeln(text);
    }
}

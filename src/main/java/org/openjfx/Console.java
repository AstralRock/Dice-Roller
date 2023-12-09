package org.openjfx;

public class Console {
    public static void output(String output) {
        Controller.getTerminal().appendText(output + "\n");
    }
}

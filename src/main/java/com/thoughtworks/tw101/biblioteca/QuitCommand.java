package com.thoughtworks.tw101.biblioteca;

/**
 * Created by richardlau on 5/2/16.
 */
public class QuitCommand implements Command {

    public void run() {
        System.exit(0);
    }
}

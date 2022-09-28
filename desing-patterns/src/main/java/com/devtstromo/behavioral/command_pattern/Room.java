package com.devtstromo.behavioral.command_pattern;

public class Room {
    Command command;

    public Room() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

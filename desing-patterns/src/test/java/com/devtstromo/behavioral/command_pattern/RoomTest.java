package com.devtstromo.behavioral.command_pattern;


import org.junit.jupiter.api.Test;

class RoomTest {

    @Test
    public void testCommand() {
        Room livingRoom = new Room();
        livingRoom.setCommand(new SwitchLightsCommand(new Light()));
        livingRoom.executeCommand();
    }

}
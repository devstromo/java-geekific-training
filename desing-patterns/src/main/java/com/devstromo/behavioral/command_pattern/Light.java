package com.devstromo.behavioral.command_pattern;

public class Light {
    private boolean switchedOn;

    public void switchLights() {
        switchedOn = !switchedOn;
    }
}

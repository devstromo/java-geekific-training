package com.devstromo.behavioral.command_pattern;

public class SwitchLightsCommand implements Command {
    Light light;

    public SwitchLightsCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLights();
    }
}

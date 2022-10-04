package com.devstromo.behavioral.mediator;

public class Dialog implements Mediator {
    private TextBox userTextBox;
    private TextBox passTextBox;
    public LoginButton button;

    @Override
    public void login() {
        String username = userTextBox.getText();
        String password = passTextBox.getText();

    }
}

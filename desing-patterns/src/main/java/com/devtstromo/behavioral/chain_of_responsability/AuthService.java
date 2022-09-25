package com.devtstromo.behavioral.chain_of_responsability;

public class AuthService {

    private Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean logIn(String email, String password) {
        if (handler.handle(email, password)) {
            System.out.println("Authorization was successful!");
            // Do stuff for auth users
            return true;
        }
        return false;
    }
}

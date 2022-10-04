package com.devstromo.behavioral.chain_of_responsability;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthServiceTest {

    @Test
    public void authServiceTest() {
        Database database = new Database();
        Handler handler = new UserExistHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database))
            .setNextHandler(new RoleCheckHandler());
        AuthService service = new AuthService(handler);
        assertFalse(service.logIn("username", "password"));
        assertFalse(service.logIn("user_username", "password"));
        assertTrue(service.logIn("admin_username", "admin_password"));
    }

}
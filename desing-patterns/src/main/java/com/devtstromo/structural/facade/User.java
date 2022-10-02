package com.devtstromo.structural.facade;

import lombok.Data;
import lombok.EqualsAndHashCode;

public record User(String id, String name, double balance, String currency, String accountNbr) {

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String currency() {
        return currency;
    }

    @Override
    public String accountNbr() {
        return accountNbr;
    }
}

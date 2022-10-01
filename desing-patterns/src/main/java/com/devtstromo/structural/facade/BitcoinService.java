package com.devtstromo.structural.facade;

public class BitcoinService extends CryptoService {
    @Override
    public void buyCurrency(User user, double amount) {
        System.out.println("Buying " + amount + " of Bitcoin...");
    }
}

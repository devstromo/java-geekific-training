package com.devtstromo.structural.facade;

public class BuyCryptoFacade {

    public void buyCryptocurrency(double amount, String currency) {
        DatabaseService databaseService = new DatabaseService();
        User user = databaseService.getUser(UIService.getLoggedInUserId());
        if (user.getBalance() < amount) {
            System.out.println("Insufficient balance to perform transaction");
            return;
        }
        CryptoFactory.getCryptoService(currency)
            .buyCurrency(user, amount);
        MailService mailService = new MailService();
        mailService.sendConfirmationMail(user);
    }
}

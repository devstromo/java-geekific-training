package com.devstromo.behavioral.visitor;

public interface Visitor {
    void visitBank(Bank bank);
    void visitCompany(Company company);
    void visitResident(Resident resident);
    void visitRestaurant(Restaurant restaurant);
}

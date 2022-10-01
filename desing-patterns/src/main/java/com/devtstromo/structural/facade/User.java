package com.devtstromo.structural.facade;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public record User(String id, String name, double balance, String currency, String accountNbr) {

}

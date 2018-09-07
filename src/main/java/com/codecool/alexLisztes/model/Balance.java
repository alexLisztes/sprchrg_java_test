package com.codecool.alexLisztes.model;

import java.math.BigDecimal;

public class Balance {

    private BigDecimal money;


    public Balance() {
        this(BigDecimal.ZERO);
    }

    public Balance(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}

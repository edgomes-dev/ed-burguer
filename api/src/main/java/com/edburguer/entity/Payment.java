package com.edburguer.entity;

import lombok.Getter;

@Getter
public enum Payment {
    MONEY(1),
    PIX(2),
    CARD(3);

    private final int code;

    Payment(int code) { this.code = code; }

    public static Payment valueOf(int code) {
        for (Payment value : Payment.values()) {
            if (code == value.getCode()) return value;
        }

        throw new IllegalArgumentException("Payment invalid code");
    }
}

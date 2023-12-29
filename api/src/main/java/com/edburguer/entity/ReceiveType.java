package com.edburguer.entity;

import lombok.Getter;

@Getter
public enum ReceiveType {
    REMOVAL(1),
    DELIVERY(2);

    private final int code;

    private ReceiveType(int code) {
        this.code = code;
    }

    public static ReceiveType valueOf(int code) {
        for (ReceiveType value : ReceiveType.values()) {
            if (code == value.getCode()) return  value;
        }

        throw new IllegalArgumentException("Invalid ReceiveType code");
    }
}

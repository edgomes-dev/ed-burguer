package com.edburguer.entity;

import lombok.Getter;

@Getter
public enum Status {
    RequestAccepted(1),
    OrderPreparation(2),
    OrderDelivered(3),
    OrderFinish(4);

    private final int code;

    private Status(int code) { this.code = code; }

    public static Status valueOf(int code) {
        for(Status value : Status.values()) {
            if (code == value.getCode()) return value;
        }

        throw new IllegalArgumentException("Status invalid code");
    }
}

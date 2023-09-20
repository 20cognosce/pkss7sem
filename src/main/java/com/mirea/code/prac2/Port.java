package com.mirea.code.prac2;

import lombok.Getter;

public enum Port {
    ONE(5001),
    TWO(5002),
    THREE(5003),
    FOUR(5004),
    FIVE(5005);

    @Getter
    private final Integer port;

    public static Port of(Integer port) {
        switch (port) {
            case 5001 -> {
                return ONE;
            }
            case 5002 -> {
                return TWO;
            }
            case 5003 -> {
                return THREE;
            }
            case 5004 -> {
                return FOUR;
            }
            case 5005 -> {
                return FIVE;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    Port(Integer port) {
        this.port = port;
    }
}
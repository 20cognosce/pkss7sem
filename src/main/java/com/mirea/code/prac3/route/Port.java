package com.mirea.code.prac3.route;

import lombok.Getter;

public enum Port {
    ONE(5001),
    TWO(5002),
    THREE(5003),
    FOUR(5004),
    FIVE(5005);

    @Getter
    private final Integer port;

    Port(Integer port) {
        this.port = port;
    }
}
package io.getarrays.server.enumeration;

import lombok.Getter;

public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    @Getter
    private final String status;

    Status(String status) {
        this.status = status;
    }
}

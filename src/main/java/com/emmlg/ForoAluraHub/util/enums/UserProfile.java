package com.emmlg.ForoAluraHub.util.enums;

public enum UserProfile {
    INSTRUCTOR("Instructor"),
    STUDENT("Estudiante"),
    ADMIN("Administrator"),
    GUEST("Invitado");

    private final String description;

    UserProfile(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

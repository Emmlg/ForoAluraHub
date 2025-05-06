package com.emmlg.ForoAluraHub.Exceptions;

public class UsuarioExistente extends RuntimeException {
    public UsuarioExistente(String message) {
        super(message);
    }
}

package com.alura.forohub.infra.errores;

public class Integrity extends RuntimeException {
    public Integrity(String s) {

        super(s);
    }
}

package com.api.rec.resume.service;

import java.io.IOException;

import gate.util.GateException;

public class AnnieThreadLocal {
    private static final ThreadLocal<Annie> threadLocalAnnie = ThreadLocal.withInitial(() -> {
        try {
            Annie annie = new Annie();
            annie.initAnnie();
            return annie;
        } catch (GateException | IOException e) {
            throw new RuntimeException("Annie initialization failed", e);
        }
    });

    public static Annie getAnnie() {
        return threadLocalAnnie.get();
    }
}

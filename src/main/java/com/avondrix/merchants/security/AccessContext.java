package com.avondrix.merchants.security;

public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String s) {
        token.set(s);
    }

    public void clearAccessKey() {
        token.remove();
    }
}

package me.cpele.helloapp;

class Assert {
    static <T> T notNull(T object) {
        if (BuildConfig.DEBUG && object == null) {
            throw new AssertionError("Object should not be null");
        }
        return object;
    }
}

package javaheap;

import java.util.Random;
import java.util.UUID;

public class SampleObject {
    private final Long id;
    private final UUID uuid;
    private final String description;

    public SampleObject() {
        var r = new Random();
        this.id = r.nextLong();
        this.uuid = UUID.randomUUID();
        var bytes = new byte[20000];
        r.nextBytes(bytes);
        this.description = new String(bytes);
    }

    public Long id() {
        return id;
    }

    public UUID uuid() {
        return uuid;
    }

    public String description() {
        return description;
    }

}

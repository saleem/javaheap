package javaheap;

import java.util.HashSet;
import java.util.Set;

public class SampleObjectBuilder {
    public Set<SampleObject> create(int howMany) {
        Set objects = new HashSet(howMany);
        for (int i = 0; i < howMany; i++) {
            objects.add(new SampleObject());
        }
        return objects;
    }
}

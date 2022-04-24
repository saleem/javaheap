package javaheap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SampleObjectTest {
    @DisplayName("Should create object with non-empty fields")
    @Test
    void createObject() {
        SampleObject sampleObject = new SampleObject();
        assertObjectState(sampleObject);
    }

    @DisplayName("Should create man objects, each with non-empty fields")
    @Test
    void createManyObjects() {
        var classUnderTest = new SampleObjectBuilder();
        var objects = classUnderTest.create(10000);
        for (var obj : objects) {
            assertObjectState(obj);
        }
    }

    private void assertObjectState(SampleObject obj) {
        assertAll("Sample Object",
                () -> assertNotNull(obj.id(), "Id is null"),
                () -> assertNotNull(obj.uuid(), "UUID is null"),
                () -> assertNotNull(obj.description(), "Description is null"),
                () -> assertTrue(obj.description().length() >= 10000,
                        "Description is less than 10000 characters long")
        );
    }
}

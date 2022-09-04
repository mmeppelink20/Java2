package assignments.assignmentintro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @Test
    public void introAssignmentChecks() {
        assertEquals("0.0.1", new Version().toString());
        assertEquals("1.2.3", new Version("1.2.3").toString());
        assertEquals("1.2.3", new Version("1.2.3.4").toString());
        assertEquals("1.2.3", new Version("1.2.3.d").toString());
        assertEquals("1.0.0", new Version("1").toString());
        assertEquals("1.1.0", new Version("1.1").toString());
        assertEquals("1.2.3", new Version(1, 2, 3).toString());
        assertEquals("0.0.1", new Version("").toString());
    }

    @Test
    public void introAssignmentBadChecks() {
        assertThrows(IllegalArgumentException.class, new Executable(){
            @Override
            public void execute() throws Throwable {
                new Version("a.b.c");
            }
        });

        assertThrows(IllegalArgumentException.class, () -> new Version("-1, 0, 0"));

    }

    @Test
    void roundOffError() {
        assertEquals(2.11, 1.1 + 1.01, 2); // delta is amount of decimal places to check
    }
}
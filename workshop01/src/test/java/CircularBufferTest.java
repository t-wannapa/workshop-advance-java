import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {

    CircularBuffer circularBuffer = new CircularBuffer();

    @Test
    @DisplayName("ตรวจสอบขนาด default ของ CircularBuffer ต้องมีขนาดเท่ากับ 10")
    public void create_buffer_with_default_size(){
        // Act
        circularBuffer.create(10);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(10, size);
    }

    @Test
    @DisplayName("ตรวจสอบขนาดของ CircularBuffer ต้องมีขนาดเท่ากับ 5")
    public void create_buffer_with_specified_size_5(){
        // Act
        circularBuffer.create(5);
        int size = circularBuffer.getSize();

        // Validate/Checking/Assert
        assertEquals(5, size);
    }
}
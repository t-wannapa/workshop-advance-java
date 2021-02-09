public class CircularBuffer {
    // Variables
    public static final int DEFAULT_SIZE = 10;
    private String[] buffer;
    private int writePointer;
    private int readPointer;

    // Constructor

    // Methods
    // Public
    public void create() {
        create(DEFAULT_SIZE);
    }

    public void create(int size) {
        buffer = new String[size];
    }

    int getSize() {
        return buffer.length;
    }

    public void init(int size) {
        buffer = new String[size];
        writePointer = 0;
        readPointer = 0;
    }



    public void write(String input) {
        int pointer = getWritePointer();
        nextWritePointer();

        buffer[pointer] = input;
    }


    public String read() {
        int pointer = getReadPointer();
        nextReadPointer();

        return buffer[pointer];
    }

    public int getWritePointer() {
        return writePointer;
    }
    public int getReadPointer() {
        return readPointer;
    }

    // Private
    private void nextWritePointer() {
        if (isEndBuffer(writePointer)) {
            writePointer = 0;
            return;
        }
        writePointer++;
    }

    private void nextReadPointer() {
        if (isEndBuffer(readPointer)) {
            readPointer = 0;
            return;
        }
        readPointer++;
    }

    private boolean isEndBuffer(int pointer) {
        return pointer == buffer.length-1;
    }

    private boolean isFullBuffer() {
        return readPointer == writePointer;
    }


}

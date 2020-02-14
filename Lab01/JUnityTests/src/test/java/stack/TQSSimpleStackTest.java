package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TQSSimpleStackTest {
    protected ITStack s;
    private int stack_size = 100;

    @BeforeEach
    void setUp() {
        s = new TQSSimpleStack(stack_size);
    }

    @Test
    void pushEmptyStack() {
        int pushes = 10;
        for (int i =  0; i<10; i++){
            s.push(i);
        }
        assertFalse(s.isEmpty());
        assertEquals(s.size(), 10);
    }

    @Test
    void pushFullStack(){
        int pushes = 100;
        for (int i = 0; i<100; i++){
            s.push(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> s.push(1));
    }

    @Test
    void popEmptyStack(){
        assertTrue(s.isEmpty());
        assertThrows(NoSuchElementException.class, () -> s.pop());
    }

    @Test
    void pop() {
        int pushes = 4;
        for (int i = 0; i<=4; i++){
            s.push(i);
        }
        for (int i = 0; i<=3; i++){
            s.pop();
        }

        assertEquals(s.peek(), 0);
    }

    @Test
    void peek() {
        s.push(1);
        assertEquals(s.peek(), 1);
    }

    @Test
    void size() {
        s.push(2);
        assertEquals(s.size(), 1);
    }

    @Test
    void isEmpty() {
        assertTrue(s.isEmpty());
        assertEquals(s.size(), 0);
    }
}
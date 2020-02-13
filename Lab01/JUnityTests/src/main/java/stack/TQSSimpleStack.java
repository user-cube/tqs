package stack;

import java.util.EmptyStackException;
import java.util.Stack;

class TQSSimpeStack<T> extends Stack<T> {
    private int maxSize;
    private Object[] array;
    private int top;

    public TQSSimpeStack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new Object[maxSize];
        this.top = -1;
    }

    public T pop() {
        if(this.isEmpty())
            throw new EmptyStackException();
        return element(top--);
    }

    public T peek() {
        if(this.isEmpty())
            throw new EmptyStackException();
        return element(top);
    }

    // Safe because push(T) is type checked.
    @SuppressWarnings("unchecked")
    private T element(int index) {
        return (T)array[index];
    }
}
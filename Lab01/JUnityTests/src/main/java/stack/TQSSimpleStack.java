package stack;

import java.util.Stack;

class TQSSimpleStack implements ITStack {

    private Object[] array;
    private int size = 0;

    public TQSSimpleStack(int stack_size) {
        array = new Object[stack_size];
    }

    public void push(Object item) {
        return;
    }

    public Object pop(){
        return null;
    }

    public Object peek() {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }
}
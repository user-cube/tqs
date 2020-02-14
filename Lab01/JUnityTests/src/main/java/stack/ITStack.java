package stack;

public interface ITStack {

    void push(Object item);

    Object pop();

    Object peek();

    int size();

    boolean isEmpty();
}

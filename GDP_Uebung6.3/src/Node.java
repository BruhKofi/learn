class Node<T>{
    private T value;
    private Node<T> next;

    public Node( T value, Node<T> anchor ) {
        this.value = value;
        this.next = anchor;
    }

    public T getValue() { return value; }
    public Node<T> getNext() { return next; }
}

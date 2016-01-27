abstract class AutoDialer<T> implements Callable{
    private Node<T> anchor;

    /*
     * insert an element at the first position
     */
    public void insert( T element ) {
        anchor = new Node<T>( element, anchor );
    }

    /*
     * call call() method on all elements contained in the list
     */
    public void callAll() {
        Node<T> iterator = anchor;

        while( iterator != null ) {
            iterator.getValue().call();
            iterator = iterator.getNext();
        }
    }
}

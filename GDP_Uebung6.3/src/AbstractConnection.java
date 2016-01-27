abstract class AbstractConnection implements Callable{
    public final String type;
    private Person person;

    protected AbstractConnection( String type, Person person ) {
        this.type = type;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    protected abstract void connect();

    /*
     * establish a connection (implemented in subclass) and then call the person
     */
    public void call() {
        connect();
        getPerson().call();
    }
}

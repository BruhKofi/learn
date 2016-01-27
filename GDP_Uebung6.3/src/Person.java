class Person implements Callable{
    public final String name;

    protected Person( String name ) {
        this.name = name;
    }

    @Override
    public void call() {
        System.out.println( "Hello " + name );
    }
}

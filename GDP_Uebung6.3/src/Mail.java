class Mail extends AbstractConnection{
    public Mail( Person person ) {
        super( "Mail", person );
    }

    @Override
    public void connect() {
        System.out.println( "Establish Mail connection" );
    }
}

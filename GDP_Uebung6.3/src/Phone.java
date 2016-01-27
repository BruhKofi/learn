class Phone extends AbstractConnection{
    public Phone( Person person ) {
        super( "Phone", person );
    }
   
    @Override
    public void connect() {
        System.out.println( "Start voice synthesizer" );
        System.out.println( "Establish phone connection" );
    }
}

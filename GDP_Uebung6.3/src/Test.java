class Test{
    private static void test1() {
        AutoDialer<Person> dialer = new AutoDialer<Person>();

        dialer.insert( new Person( "Mrs. X" ) );
        dialer.insert( new Person( "Mr. Y" ) );

        dialer.callAll();
    }

    private static void test2() {
        AutoDialer<AbstractConnection> dialer = new AutoDialer<AbstractConnection>();

        dialer.insert( new Mail( new Person( "Mrs. X" ) ) );
        dialer.insert( new Phone( new Person( "Mr. Y" ) ) );

        dialer.callAll();
    }

    public static void main( String[] args ) {
        test1();
        test2();
    }
}

public class FibonacciCache {
  private static int aufrufe = 0;
  private static int fib(int n, int[] cache) {
    aufrufe++;
    // ToDo: berechne rekursiv das n-te Glied der Fibonacci-Folge,
    // wobei fib fuer jedes n maximal einmal aufgerufen werden
    // soll und gebe den Wert zurueck
    if (n==0){
      return 0;
    }
    if (n==1){
      cache[n] = fib(n-1,cache) + 1;
      return cache[n];
    }
    cache[n] = fib(n-1,cache) + cache[n-2];

  return cache[n];

  }
  public static void main(String []args) {
    int n = Integer.parseInt(args[0]);
    int[] cache = new int[n+1]; // initial sind alle Eintraege 0
    System.out.println("fib(" + n + ") = "
      + fib(n, cache) + " (Aufrufe = " + aufrufe + ")");
  }
}

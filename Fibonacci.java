public class Fibonacci {
  private static int aufrufe = 0;
  private static int fib(int n) {
      aufrufe++;
      if (n==0){
        return 0;
      }
      if (n==1){
        return 1;
      }
      n = fib(n - 1) + fib(n - 2);
    return n;
  }
  public static void main(String []args) {
    int n = Integer.parseInt(args[0]);
    System.out.println("fib(" + n + ") = "
      + fib(n) + " (Aufrufe = " + aufrufe + ")");
  }
}

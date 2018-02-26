
package mdza.cs.dynamicpgramming;

/**
 *
 * @author Alberto Mendoza>
 */
public class Fibonacci {
    public static int fib(int i) {
        if (i == 0 || i == 1) return i;
        else
        return (fib(i - 2) + fib(i - 1));
    }
    
    public static int fibMemo(int i) {
        int [] memo = new int[i+1];
        for (int k=0; k<memo.length; ++k)
            memo[k] = 0;
        return fibMemo(i, memo);
    }
    
    private static int fibMemo(int i, int[] memo){
        if (i == 0 || i == 1) 
           return memo[i] = i;
        else if(memo[i]==0)
            return memo[i] = (fib(i - 2) + fib(i - 1));
        else
            return memo[i];
    }
    
    public static void Tester() {
        int[] fib = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233};
        int max = 50;  //fib.length;
        
        long now = System.currentTimeMillis();
        for (int i=0; i<max; ++i) 
            System.out.printf("fibMemo(%d) -> result: %d \n", i, Fibonacci.fibMemo(i));
        System.out.println("Execution time: " + (System.currentTimeMillis() - now));
        
        now = System.currentTimeMillis();
        for (int i=0; i<max; ++i) 
            System.out.printf("fib(%d) -> result: %d \n", i, Fibonacci.fib(i));
        System.out.println("Execution time: " + (System.currentTimeMillis() - now));
        
    }
}

import java.util.Scanner;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      
      int a = scan.nextInt();
      int b = scan.nextInt();
      int c = scan.nextInt();
      
      double s;
      
      s = Math.sqrt(4*Math.pow(a, 2)*Math.pow(b, 2)-Math.pow((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)),2))/4;
      
      System.out.println((int)(s * 100) / 100.0);
   }

}
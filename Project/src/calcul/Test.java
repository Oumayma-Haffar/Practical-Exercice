package calcul;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("Put Quantity !");
         Scanner s1 = new Scanner(System.in);
         int quantity = s1.nextInt();
         System.out.println("Put Price !");
         Scanner s2 = new Scanner(System.in);
         double price = s2.nextDouble();
         System.out.println(" Price = "+CalculPrice.CalculateTotalPrice(quantity, price));
	}

}

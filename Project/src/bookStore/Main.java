package bookStore;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connection.MyConnection;

public class Main {
	 public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
	       
		    Command cmd = new Command ();
		    User user = new User ();
	        Book book = new Book(null, null, 0, null);
	        
	        int a=0;
	        int c=0;
	        do {
	            System.out.println("Choose:");
	            System.out.println("1: Update book ");
	            System.out.println("2: Add book ");
	            System.out.println("3: list of books ");
	            System.out.println("4: Command ");
	            System.out.println("5: delete book ");
	            System.out.println("6: insert user ");	
	            System.out.println("7: check list of users");
	            System.out.println("8: check list of orders and total price ");
	            
	            System.out.println("9: logout ");
	            Scanner s = new Scanner( System.in );
	            a   = s.nextInt();
	            switch(a)
	            {case 1:{
	        System.out.println("Put  the book's id you want to update ");
	        Scanner sc9 = new Scanner( System.in );
	        int idu   = sc9.nextInt();
	        
	         System.out.println(" title ");
	            Scanner sc = new Scanner( System.in );
	            String Title   = sc.nextLine();
	            System.out.println(" author ");
	            Scanner sc1 = new Scanner( System.in );
	            String Author   = sc1.nextLine();
	            System.out.println(" price ");
	            Scanner sc3 = new Scanner( System.in );
	            Double Price   = sc3.nextDouble();
	            
	            System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
                Scanner sc4 = new Scanner( System.in );
                String date=sc4.next();
                java.sql.Date Releasedate=java.sql.Date.valueOf(date);
	              book.updateBook(idu, Title,Author, Price, Releasedate);
	          break;
	          }
	            case 2:{ 
	                System.out.println("Put in the book's title ");
	                Scanner sc = new Scanner( System.in );
	                String Title   = sc.nextLine();
	                System.out.println("Put in the book's author ");
	                Scanner sc1 = new Scanner( System.in );
	                String Author   = sc1.nextLine();
	                System.out.println("Put in the book's price ");
	                Scanner sc3 = new Scanner( System.in );
	                Double Price   = sc3.nextDouble();
	                System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
	                Scanner sc4 = new Scanner( System.in );
	                String date=sc4.next();
	                java.sql.Date Releasedate=java.sql.Date.valueOf(date);
	                book.insertBooks(Title, Author, Price, Releasedate);
	            
	            break;}
	            case 3:{
	            try {
	                book.displayBook();
	            } catch (ClassNotFoundException | SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }break;}
	            case 4:{
	            	do {
	            	book.displayBook();	
	            	cmd.addCommand();
	            	System.out.println("do you want to add another command 1:yes 2:no ");
	                Scanner scr = new Scanner( System.in );
	                c = scr.nextInt();
	                }while(c==1);break;}
	           
	            case 5:{
	            System.out.println("Put  the book's id you want to delete ");
	            Scanner sc8 = new Scanner( System.in );
	            int idd   = sc8.nextInt();
	            book.deleteBook(idd);
	           break; }
	            case 6:{
	            	user.adduser();
		            	 break;}
	            
			    case 7:{
		         	user.consultuser();
		         	 break;}
			    case 8: {
			    	 MyConnection cn;
	                    PreparedStatement pstmt;
	                    cn = new MyConnection();
	                     pstmt = cn.Myconnect().prepareStatement("SELECT * FROM Command "); 
	                    ResultSet rs = pstmt.executeQuery();
	                    int i=0;
	                    
	                    while (rs.next()) {
	                        
	                           String id = rs.getString("id");
	                           String idbook = rs.getString("idbook");
	                           String pricebook = rs.getString("pricebook");
	                           String quantity = rs.getString("quantity");
	                           String total = rs.getString("total");
	                           

	 

	                           //Display values
	                           System.out.print("id commande: " + id);
	                           System.out.print(", id book: " + idbook);
	                           System.out.print(", price book: " +pricebook);
	                           System.out.print(", quantity: " + quantity);
	                           System.out.print(", total : " + total);
	                           cmd.totalPrice();
	               }
	                    
	                
			    	break;}
			    case 9: {
	                 MyConnection con;
	                 PreparedStatement pstmt;
	                 con = new MyConnection();
	                 try {
	                 pstmt = con.Myconnect().prepareStatement("TRUNCATE TABLE cmdline ");
	                 pstmt.executeUpdate();
	                 System.out.println("a la prochaine");
	                 }
	                 catch(SQLException e)
	                 {e.printStackTrace();}
	                break;}
	               }
	            
	            }   
	        while(a!=9);
	 }
	 
}

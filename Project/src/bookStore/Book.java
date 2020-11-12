package bookStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.MyConnection;

import java.sql.Date;

		public class Book {
		private String Title;
		private String Author;
		private double Price;
		private Date ReleaseDate;
		Connection c =null;
		Statement stmt =null;
		public Book(String title, String author, double price, Date releaseDate) {
			super();
			Title = title;
			Author = author;
			Price = price;
			ReleaseDate = releaseDate;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getAuthor() {
			return Author;
		}
		public void setAuthor(String author) {
			Author = author;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public Date getRealeaseDate() {
			return ReleaseDate;
		}
		public void setRealeaseDate(Date realeaseDate) {
			ReleaseDate = realeaseDate;
		}
		
		// Insert Books
		public void insertBooks (String Title, String Author, double Price, Date releaseDate ) throws ClassNotFoundException, SQLException
		  {
			MyConnection c;
		    PreparedStatement pstmt;
		    c = new MyConnection();
			    if (c==null)
		            System.out.println("server connection error!");
		            else System.out.println("Connected !");
			    pstmt =  c.Myconnect().prepareStatement("INSERT INTO `book`(Id,Title,Author,Price,ReleaseDate) VALUES (? , ?, ?, ?, ?)");
			    pstmt.setNString(1, null );
			    pstmt.setString(2, Title );
			    pstmt.setString(3, Author );
			    pstmt.setDouble(4,Price);
			    pstmt.setDate(5, releaseDate);
			    System.out.println("Added with Success");
			    pstmt.executeUpdate();
		  }
		
		  // Display Books
	
			public void displayBook() throws ClassNotFoundException, SQLException 
		    {   MyConnection c;
		    PreparedStatement pstmt;
		    c = new MyConnection();
			    if (c==null)
		            System.out.println("server connection error!");
		            else System.out.println("Connected !");
			    
		    try {
		    	pstmt =  c.Myconnect().prepareStatement("SELECT * FROM Book "); 
		    ResultSet rs = pstmt.executeQuery();
		    int i=0;
		    while (rs.next()) {
		        i++;
		        System.out.println("Book n° "+i);
		        System.out.println("id : " + rs.getString("id"));
		        System.out.println("title : " + rs.getString("title"));
		        System.out.println("author : " + rs.getString("author"));
		        System.out.println("telephone : " + rs.getString("price"));
		        System.out.println("date: " + rs.getString("releaseDate"));
		    }}
		    catch(SQLException e)
		    {e.printStackTrace();}
		
		 
		
		     }
			// Method Calculate 
			
			// Delete Books
			
			public void deleteBook(long id) throws ClassNotFoundException, SQLException
			    {    MyConnection c;
			    PreparedStatement pstmt;
			    c = new MyConnection();
			    try {
			   pstmt =  c.Myconnect().prepareStatement("DELETE FROM book WHERE id =?");
			  
			    pstmt.setLong(1,id);
			    pstmt.executeUpdate();
			    System.out.println("Deleted !");
			    }
			    catch(SQLException e)
			    {e.printStackTrace();}
			           
			        }
			 //Update Books
			public void updateBook(int id,String title, String author, double price, Date releaseDate2 ) throws ClassNotFoundException, SQLException
			{   Connection con =null;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";
			con = DriverManager.getConnection(url,"root","");
			try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE book SET author = ?,title = ?,price = ?,releasedate = ? WHERE id = ?");

			 

			pstmt.setString(1, author );
			pstmt.setString(2, title );
			pstmt.setDouble(3,price);
			pstmt.setDate(4, releaseDate2 );
			pstmt.setInt(5, id );

			 

			           pstmt.executeUpdate();
			           System.out.println("updated succefully");}
			catch(SQLException e)
			{e.printStackTrace();}
			       
			    }
			}

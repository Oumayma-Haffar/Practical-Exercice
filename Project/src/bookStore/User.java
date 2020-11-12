package bookStore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connection.MyConnection;

public class User {
    private String login;
    private String password;
    private String first_Name;
    private String last_name;
    private String phone;
    public String getLogin() {
        return login;
    }
 
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void adduser() throws ClassNotFoundException, SQLException
    {
        MyConnection con;
        PreparedStatement pstmt;
        con = new MyConnection();
        System.out.println(" login ");
        Scanner a1 = new Scanner( System.in );
        String login   = a1.nextLine();
        System.out.println(" password  ");
        Scanner a2 = new Scanner( System.in );
        String password   = a2.nextLine();
        System.out.println(" first_Name ");
        Scanner a3 = new Scanner( System.in );
        String first_Name = a3.nextLine();
        System.out.println(" last_Name ");
        Scanner a4 = new Scanner( System.in );
        String last_name  = a4.nextLine();
        System.out.println(" phone ");
        Scanner a5 = new Scanner( System.in );
        int  phone = a5.nextInt();
        pstmt = con.Myconnect().prepareStatement("INSERT INTO `user`(login,password,first_Name,last_name,phone) VALUES (?, ?, ?, ?, ?)");
       
		pstmt.setNString(1, login );
        pstmt.setString(2, password );
        pstmt.setString(3, first_Name );
        pstmt.setString(4,last_name);
        pstmt.setInt(5, phone );
                   System.out.println("added with success");
                   pstmt.executeUpdate();
    }
    public void consultuser() throws ClassNotFoundException, SQLException
    {
    	 MyConnection con;
         PreparedStatement pstmt;
         con = new  MyConnection();
        
          pstmt = con.Myconnect().prepareStatement("SELECT * FROM user "); 
         ResultSet rs = pstmt.executeQuery();
         int i=0;
         while (rs.next()) {
             
                String login= rs.getString("login");
                String password = rs.getString("password");
                String first_Name = rs.getString("first_Name");
                String last_name = rs.getString("last_name");
                int phone = rs.getInt("phone");
                
                //Display values
                System.out.print("login: " + login);
                System.out.print(", password: " + password);
                System.out.print(", first_Name: " + first_Name);
                System.out.print(",last_name: " + last_name);
                System.out.print(", phone: " + phone);
    }
    }
}


import java.util.*;
import java.io.*;
import java.sql.*;
public class maria {


	public static void main(String[] args) {
      // TODO Auto-generated method stub
Scanner input = new Scanner(System.in);
      Connection connection = null;
      String url = "jdbc:mariadb://localhost:3306/cinemavio";
      String user = "root";
      String pwd = "";
      
      try {
         connection = DriverManager.getConnection(url, user, pwd);
       
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
                  System.out.println("thanks!");

      }
      System.out.println("Successfully connected to database");
      
            try {
         Statement stmt = connection.createStatement();
      
     try { 
     int cases ;
     do {
   
System.out.println("please enter which operation you want to perform");
    cases = input.nextInt();

     
      
      switch  (cases) 
      
     {
     
     case 1 : 
    int x=0;
    mainLoop:
    do {  


      System.out.println("please enter branch info");

      System.out.println("please enter your branch name");
      String name = input.next();
      ///
       for (int i=0; i<name.length();i++){
if (!Character.isLetter(name.charAt(i))){
   System.out.println("please enter a valid branch name ");
//
continue mainLoop;
}}




 System.out.println("please enter the street where your branch is located");
String street = input.next();
//
 for (int i=0; i<street.length();i++){
if (!Character.isLetter(street.charAt(i))){
   System.out.println("please enter a valid street name ");
//continue;
continue mainLoop;
}}
   System.out.println("please enter the city where your branch is located");
String city = input.next();
//
 for (int i=0; i<city.length();i++){
if (!Character.isLetter(city.charAt(i))){
   System.out.println("please enter a valid city ");
//continue;
continue mainLoop;
}}



         String sql = "INSERT INTO Branch VALUES("+name+",'"+street+"',"+city+")";
       x=stmt.executeUpdate(sql);
         if (x<1)
 System.out.println("failling on inserting your record please re-enter your values");


}  while (x<1);

break;
         
        case 2 :       
         
         ResultSet rs = null;
         
         rs = stmt.executeQuery("SELECT * FROM Branch");
         while(rs.next()) {
            
            System.out.print(rs.getString("name") + "\t");
            System.out.print(rs.getString("street") + "\t");
            System.out.print(rs.getString("city") + "\t");

            System.out.println();
         }
         
         break;
         
         
          case 3 :
         System.out.println("thanks!");
             break;
             
default:  
             System.out.println("please enter 1 for inserting a record 2 for display or 3 to exit");
   
      }
     } while ( cases != 3);
   }
      catch (InputMismatchException e){
   
 System.out.println("please enter 1 for inserting a record 2 for display or 3 to exit");
   
      }
      
      
  
      
      
     
      
         // revise it            
         stmt.close();
         connection.close();
         }
       catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();

      }  

}}

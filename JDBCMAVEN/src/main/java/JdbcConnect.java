import java.sql.*;
import java.util.*;
public class JdbcConnect {
    public static void main(String args[])
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ksolves", "root", "root");
            if (conn != null) {

                System.out.println("KSOLVES PLACEMENT PORTAL\n1:PRINT DATA\n2:INSERT DATA\n3:UPDATE DATA\n4:DELETE DATA\n5:SEARCH DATA\n6:SEARCH NAME");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();

                if (choice == 1) {
                    String sql = "select * from ksolvesashish";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    System.out.println("ID"+" NAME"+" COMPANY ");
                    while (rs.next()) {
                        System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("companyt"));
                    }
                }


                if (choice == 2) {
                    String sql = "insert into ksolvesashish values(?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    System.out.println("ENTER THE EMPLOYEE ID: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("ENTER THE EMPLOYEE NAME: ");
                    String name = scan.nextLine();
                    System.out.println("ENTER THE EMPLOYEE COMPANY: ");
                    String company = scan.nextLine();
                    pst.setInt(1, id);
                    pst.setString(2, name);
                    pst.setString(3, company);
                    int x = pst.executeUpdate();
                    System.out.println("NUMBER OF ROW INSERTED: " + x);

                }

                if (choice == 3) {
                    String sql = "update ksolvesashish set companyt=? where id=?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    System.out.println("ENTER THE EMPLOYEE ID: ");
                    int id = scan.nextInt();
                    String name = scan.nextLine();
                    System.out.println("ENTER THE EMPLOYEE NEW COMPANY: ");
                    String company = scan.nextLine();
                    pst.setString(1, company);
                    pst.setInt(2, id);
                    int x = pst.executeUpdate();
                    System.out.println("NUMBER OF ROW UPDATED: " + x);
                }

                if (choice == 4) {
                    String sql = "delete from ksolvesashish  where id=?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    System.out.println("ENTER THE EMPLOYEE ID WHOME YOU WANT TO REMOVE: ");
                    int id = scan.nextInt();
                    pst.setInt(1, id);
                    int x = pst.executeUpdate();
                    System.out.println("NUMBER OF ROW DELETED: " + x);
                }

                if (choice == 5) {
                    String sql = "select * from ksolvesashish  where id=?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    System.out.println("ENTER THE EMPLOYEE ID WHOSE DETAILS YOU WANT: ");
                    int id = scan.nextInt();
                    pst.setInt(1, id);
                    ResultSet rs = pst.executeQuery();
                    System.out.println("ID"+" NAME"+" COMPANY ");
                    while (rs.next()) {
                        System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("companyt"));
                    }
                }

                if (choice == 6) {
                    String sql = "select * from ksolvesashish  where name=?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    System.out.println("ENTER NAME TO RETRIEVE ALL ITS DATA: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    pst.setString(1, name);
                    ResultSet rs = pst.executeQuery();
                    System.out.println("ID"+" NAME"+" COMPANY ");
                    while (rs.next()) {
                        System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getString("companyt"));
                    }
                }

            }
        }catch(Exception e){
            System.out.println("EXCEPTION: "+e);
        }
    }
}

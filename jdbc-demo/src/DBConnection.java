import java.sql.*;
import java.util.Scanner;

public class DBConnection {
    static final String jdbcURL = "jdbc:oracle:thin:@ora.csc.ncsu.edu:1521:orcl01";
    static Connection connection = null;
    private static ResultSet result = null;

    /**
     *
     * @param user
     * @param password
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void setConnection(String user, String password) throws ClassNotFoundException, SQLException{
        try {

            Class.forName("oracle.jdbc.OracleDriver");

            Statement stmt = null;
            ResultSet rs = null;

            try {

                // Get a connection from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL

                connection = DriverManager.getConnection(jdbcURL, user, password);

                // Create a statement object that will be sending your
                // SQL statements to the DBMS

                stmt = connection.createStatement();

                // Get data from the COFFEES table

                // rs = stmt.executeQuery("SELECT COF_NAME, PRICE FROM COFFEES1");

                // Now rs contains the rows of coffees and prices from
                // the COFFEES table. To access the data, use the method
                // NEXT to access all rows in rs, one row at a time

//                while (rs.next()) {
//                    String s = rs.getString("COF_NAME");
//                    float n = rs.getFloat("PRICE");
//                    System.out.println(s + "   " + n);
//                }

            } finally {
                close(rs);
                close(stmt);
                close(connection);
            }
        } catch (Throwable oops) {
            oops.printStackTrace();
        }


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // connect to the Oracle server
        setConnection("gzhang26", "200371225");
        // todo: how to init Oracle database frame & data by Java?
//        System.out.println("Need to recreate and reinitiate data tables? 1. NO. 2 Yes");
//        // if yes, reinitiate the tables
//        if(new Scanner(System.in).nextInt() == 2){
//            InitiateProcess.init(connection);
//        }
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter the choice: \n0. Exit\n1. Admin Login\n2. Brand Login\n3.Customer Login\n");
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
//                    AdminLogin.run(connection);
                    break;
                case 2:
//                    BrandLogin.run(connection);
                    break;
                case 3:
//                    CustomerLogin.run(connection);
                    break;
                default:
                    System.out.println("Input error, please retry.\n");
                    break;
            }
        } while (choice != 0);
    }

    static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Throwable whatever) {
            }
        }
    }

    static void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Throwable whatever) {
            }
        }
    }

    static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Throwable whatever) {
            }
        }
    }
}
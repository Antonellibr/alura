package greenplum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*import java.sql.DriverManager;*/

public class PostgreSQLJDBC {
	public static void main(String args[]) {

		Connection c = null;
		Statement stmt = null;
		String sql = null;

		try {
			/* Connection DB ################ */
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutorial", "user1", "user1");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			/* ################################ */

			/* Drop a Table ################ */
			stmt = c.createStatement();
			sql = "DROP TABLE COMPANY;";
			stmt.executeUpdate(sql);
			stmt.close();
			// c.close();
			System.out.println("Table droped successfully");
			/* ################################ */

			/* Create a Table ################ */
			stmt = c.createStatement();
			sql = "CREATE TABLE COMPANY " +
	    			  "(ID INT PRIMARY KEY     NOT NULL," +
	    			  " NAME           TEXT    NOT NULL, " +
	    			  " AGE            INT     NOT NULL, " +
	    			  " ADDRESS        CHAR(50), " +
	    			  " SALARY         REAL)";
			stmt.executeUpdate(sql);
			stmt.close();
			// c.close();
			System.out.println("Table created successfully");
			/* ################################ */

			/* INSERT Operation ################ */
			stmt = c.createStatement();
			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
					+ "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
			stmt.executeUpdate(sql);
			System.out.println("Insert successfully");
			/* ################################ */

			/* SELECT Operation ################ */
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
			System.out.println("\n-- dados ------------");
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");

				System.out.println("ID = " + id);
				System.out.println("NAME = " + name);

			}
			System.out.println("---------------------\n");
			rs.close();
			stmt.close();
			c.commit();
			// c.close();
			System.out.println("Select done successfully");
			/* ################################ */

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}
}
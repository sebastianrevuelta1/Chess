package core.sebas.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQLUtil {
    public static PreparedStatement getQuery(Connection conn, String username, String password) throws Exception {
    	PreparedStatement sqlStatement = conn.prepareStatement("select username,password from secure_user "
		    + "where username=? and password=SHA1(?)");
		sqlStatement.setString(1, username);
		sqlStatement.setString(2, password);
        return sqlStatement;
    }

    public static String buildQuery(String username, String password) {
        String query = "select * from user where username='" + username + "' and password = '" + password + "'";
	return query;
    }
}

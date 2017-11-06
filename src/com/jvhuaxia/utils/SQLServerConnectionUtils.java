package com.jvhuaxia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnectionUtils {
	public static Connection getConnection(String host, String port, String dbName, String userName, String userPwd)
			throws ClassNotFoundException, SQLException {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName;
		Class.forName(driverName);
		Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		return dbConn;
	}
}

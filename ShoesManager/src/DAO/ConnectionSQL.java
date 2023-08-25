package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionSQL {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=qlcuahanggiaydb";
	static String username = "admin";
	static String password = "123";

	/*
	 * Nạp driver
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Xây dựng PreparedStatement
	 * 
	 * @param sql  là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
	 *             gọi thủ tục lưu
	 * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu
	 *             lệnh sql
	 * @return PreparedStatement tạo được
	 * @throws java.sql.SQLException lỗi sai cú pháp
	 */
	public PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
		Connection connection = DriverManager.getConnection(dburl, username, password);
		PreparedStatement pstmt = null;
		if (sql.trim().startsWith("{")) {
			pstmt = connection.prepareCall(sql);
		} else {
			pstmt = connection.prepareStatement(sql);
		}
		for (int i = 0; i < args.length; i++) {
			pstmt.setObject(i + 1, args[i]);
		}
		return pstmt;
	}

	/**
	 * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu
	 * thao tác dữ liệu
	 * 
	 * @param sql  là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
	 *             gọi thủ tục lưu
	 * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu
	 *             lệnh sql *
	 */
	public void executeUpdate(String sql, Object... args) {
		try {
			PreparedStatement stmt = prepareStatement(sql, args);
			try {
				stmt.executeUpdate();
			} finally {
				stmt.getConnection().close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ liệu
	 * 
	 * @param sql  là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
	 *             gọi thủ tục lưu
	 * @param args là danh sách các giá trị được cung cấp cho các tham số trong câu
	 *             lệnh sql
	 */
	public ResultSet executeQuery(String sql, Object... args) {
		try {
			PreparedStatement stmt = prepareStatement(sql, args);
			return stmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

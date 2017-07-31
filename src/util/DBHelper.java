package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tblrfidinfo;

public class DBHelper {

	// 加载数据库驱动
	private static Connection getConn() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/washingdb";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 增
	public static int DBinsert(Tblrfidinfo tblrfidinfo) {
		Connection conn = getConn();
		int i = 0;
		String sql = "INSERT tbl_rfid_info(RFID_TYPE,RFID_MODE,RFID_ID,RFID_EPC) VALUES(2,1,'"+tblrfidinfo.getRFIDID()+"','"+tblrfidinfo.getRFIDEPC()+"');";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// 查
	public static List<Tblrfidinfo> DBselect() {
		List<Tblrfidinfo> rfidlist = new ArrayList<>();
		Connection conn = getConn();
	    String sql = "select * from tbl_rfid_info";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        //System.out.println("============================");
	        while (rs.next()) {
	        	Tblrfidinfo rfid = new Tblrfidinfo();
	        	rfid.setRFIDTYPE(2);
	        	rfid.setRFIDMODE(1);
	        	rfid.setRFIDID(rs.getString("RFID_ID"));
	        	rfid.setRFIDEPC(rs.getString("RFID_EPC"));
	        	rfidlist.add(rfid);
	        }
	        //System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return rfidlist;
	}
}

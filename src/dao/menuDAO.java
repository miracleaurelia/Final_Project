package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import connectDatabase.koneksi;

public class menuDAO {
	
	Connection connection;
	
	public menuDAO() {
		// TODO Auto-generated constructor stub
		try {
			initconnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void initconnection() throws SQLException {
		connection=koneksi.connect();
		if (connection==null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getMenuData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from menu";	
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void	insertData(String code, String name, int price, int stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "Insert into menu values('"+code+"', '"+name+"', '"+price+"', '"+stock+"')";
			stmt.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(String code, int price, int stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update menu set Harga_Menu = '"+price+"', Stok_Menu = '"+stock+"' where Kode_Menu = '"+code+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(String code) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM menu where Kode_Menu = '"+code+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//jika code digenerate secara acak
	//bukan dimasukkan user seperti yang diminta soal
//	public String generateNewID() {
//		String id = "";
//		String newId ="";
//		try {
//			Statement stmt = connection.createStatement();
//			String sql = "SELECT Customer_ID from customer ORDER BY Customer_ID DESC LIMIT 1";
//			ResultSet rs = stmt.executeQuery(sql);
//			int latestId = 0;
//			while(rs.next()) {
//				id = rs.getString(1);
//				latestId = Integer.parseInt(id.replaceAll("[^0-9]",""));
//			}
//			newId = "CU-" + String.format("%03d",latestId + 1);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return newId;
//	}
}
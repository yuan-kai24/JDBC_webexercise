package com.yk.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MyJdbc {
	private static String sqlurl = "jdbc:sqlserver://localhost:1433;DatabaseName=MyTest;";
	private static String sqlusername = "sa";
	private static String sqlpassword = "w201024..";
	private static Connection con = null;

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(sqlurl, sqlusername, sqlpassword);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public List<SqlInfo> init() {
		List<SqlInfo> sql = new LinkedList<SqlInfo>();
		try {
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery("select * from Table_1");
			while(rst.next())
			{
				SqlInfo sin = new SqlInfo();
				sin.setID(rst.getString("ID"));
				sin.setName(rst.getString("name"));
				sin.setSex(rst.getString("sex"));
				sin.setAge(rst.getString("age"));
				sin.setPhone(rst.getString("phone"));
				sin.setE_mail(rst.getString("e-mail"));
				sql.add(sin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sql;

	}
	
	public void deletInfo(String id)
	{
		Statement stm;
		try {
			stm = con.createStatement();
			stm.execute("delete from Table_1 where id='" + id + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertInfo(Map<String, Object> info)
	{
		String insert = ""+
				"insert into Table_1"+
				"(name,sex,age,phone,[e-mail])"+
				"values(?,?,?,?,?)";
		try {
			PreparedStatement pre = con.prepareStatement(insert);
			pre.setString(1, info.get("name").toString());
			pre.setString(2, info.get("sex").toString());
			pre.setString(3, info.get("age").toString());
			pre.setString(4, info.get("phone").toString());
			pre.setString(5, info.get("[e-mail]").toString());
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateInfo(Map<String, Object> info)
	{
		String insert = ""+
				"update Table_1 set "+
				"name = ?,sex = ?,age = ?,phone = ?,[e-mail] = ? "+
				"where id = ?";
		try {
			PreparedStatement pre = con.prepareStatement(insert);
			pre.setString(1, info.get("name").toString());
			pre.setString(2, info.get("sex").toString());
			pre.setString(3, info.get("age").toString());
			pre.setString(4, info.get("phone").toString());
			pre.setString(5, info.get("[e-mail]").toString());
			pre.setString(6, info.get("id").toString());
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> seleInfo(String id)
	{
		Map<String, Object> info = new HashMap<String, Object>();
		
		String update = "select * from Table_1 where id = ?";
		
		try {
			PreparedStatement pre = con.prepareStatement(update);
			pre.setString(1, id);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				info.put("name",rs.getString("name"));
				info.put("sex",rs.getString("sex"));
				info.put("age",rs.getString("age"));
				info.put("phone",rs.getString("phone"));
				info.put("[e-mail]",rs.getString("e-mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return info;
	}

}












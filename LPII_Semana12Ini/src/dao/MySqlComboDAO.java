package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import beans.ComboBean;

public class MySqlComboDAO implements ComboDao {
	
	public List<ComboBean> ejecutaSQL(String sql) throws Exception{
		ComboBean bean= null;
		
		List<ComboBean> data = new ArrayList<ComboBean>();
		ConexionDB mysql = new ConexionDB();
		Connection con = mysql.getConexion();
		
		
		System.out.println("SQL :" + sql);
		Statement pstm = con.createStatement();
		ResultSet rs= pstm.executeQuery(sql);
		while (rs.next()) {
			bean = new ComboBean(); 
			bean.setValue(rs.getString(1));
			bean.setDescripcion(rs.getString(2));
			data.add(bean);
		}
		
		return data;
	}

}

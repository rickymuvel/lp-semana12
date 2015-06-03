package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import beans.CarreraBean;

public class MySqlCarreraDao implements CarreraDao{

	@Override
	public List<CarreraBean> listaCarrera() {
		Connection con= null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<CarreraBean> data = new ArrayList<CarreraBean>();
		
		try {
			con= new ConexionDB().getConexion();
			String sql="select * FROM carrera";
			pst=con.prepareStatement(sql);
			rs = pst.executeQuery();
			CarreraBean bean = null;
			while(rs.next()){
				bean = new CarreraBean();
				bean.setIdCarrera(rs.getString(1));
				bean.setNombre(rs.getString(2));
				data.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception e2) {}
		}
		return data;
	}

	
}

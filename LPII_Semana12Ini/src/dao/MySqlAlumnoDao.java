package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import beans.AlumnoBean;

public class MySqlAlumnoDao implements AlumnoDao {

	
	@Override
	public List<AlumnoBean> alumnosXCarrera(String idCarrera) {
		Connection con= null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<AlumnoBean> data = new ArrayList<AlumnoBean>();
		
		try {
			con= new ConexionDB().getConexion();
			String sql="select a.*, c.nombre from alumno a, carrera c " +
					   "where a.idcarrera = c.idcarrera AND a.idcarrera = ? ";
			pst=con.prepareStatement(sql);
			pst.setString(1, idCarrera);
			rs = pst.executeQuery();
			AlumnoBean bean = null;
			while(rs.next()){
				bean = new AlumnoBean();
				bean.setIdAlumno(rs.getString(1));
				bean.setNombre(rs.getString(2));
				bean.setApellido(rs.getString(3));
				bean.setIdCarrera(rs.getString(4));
				bean.setDesCarrera(rs.getString(5));
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

	@Override
	public int eliminaAlumno(String idAlumno) {
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= new ConexionDB().getConexion();
			String sql="delete from alumno where idAlumno = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1, idAlumno);
			return pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception e2) {}
		}
		return -1;
	}

}

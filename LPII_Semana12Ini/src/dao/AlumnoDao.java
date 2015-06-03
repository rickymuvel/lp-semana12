package dao;

import java.util.List;

import beans.AlumnoBean;


public interface AlumnoDao {

	public List<AlumnoBean> alumnosXCarrera(String idCarrera);
	public int eliminaAlumno(String idAlumno);
	
}

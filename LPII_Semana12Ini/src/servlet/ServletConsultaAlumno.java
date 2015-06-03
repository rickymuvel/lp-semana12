package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AlumnoBean;
import dao.AlumnoDao;
import dao.Factory;



public class ServletConsultaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	
		String carrera = req.getParameter("carrera");
		
		Factory subFrabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		AlumnoDao usu = subFrabrica.getAlumnoDao();
		
		
		List<AlumnoBean> data = usu.alumnosXCarrera(carrera);
		
		req.setAttribute("alumnos", data);
		req.getRequestDispatcher("/consultaAlumnoSimple.jsp").forward(req, res);
	}

}











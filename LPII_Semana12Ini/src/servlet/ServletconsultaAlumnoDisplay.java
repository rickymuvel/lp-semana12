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

/**
 * Servlet implementation class ServletconsultaAlumnoDisplay
 */
public class ServletconsultaAlumnoDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String carrera = request.getParameter("carrera");
		
		Factory subFrabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		AlumnoDao usu = subFrabrica.getAlumnoDao();
		
		
		List<AlumnoBean> data = usu.alumnosXCarrera(carrera);
		
		request.setAttribute("alumnos", data);
		request.getRequestDispatcher("/consultaAlumnoDisplaytag.jsp").forward(request, response);
	}
}

/*HE CREADO UN SERVLET DE NOMBRE ServletEliminaAlumno, le puse el ALIAS eliminaAlumno y escribí todo el codigo de abajo*/
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
 * Servlet implementation class ServletEliminaAlumno
 */
public class ServletEliminaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Factory subFrabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		AlumnoDao usu = subFrabrica.getAlumnoDao();
		
		
		usu.eliminaAlumno(id);
		request.getRequestDispatcher("/consultaAlumnoDisplaytag.jsp").forward(request, response);			
	}

}

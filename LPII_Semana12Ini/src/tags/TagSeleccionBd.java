package tags;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ComboBean;
import dao.ComboDao;
import dao.Factory;

@SuppressWarnings("serial")
public class TagSeleccionBd extends TagSupport {
	
	private String nombre, aliasSql;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.println("<select name='" + nombre +"'>");
			out.println("<option>[Seleccione]</option>");
			
			Factory fabrica = Factory.getTipo(Factory.TIPO_MYSQL);
			ComboDao dao = fabrica.getComboDao();
			
			//leo el archivo properties de nombre infoSql
			ResourceBundle rb = ResourceBundle.getBundle("infoSql");
			
			//obtengo el SQL
			String sql = rb.getString(aliasSql);
			
			//Se trae data de la base de datos del Sql
			List<ComboBean> data = dao.ejecutaSQL(sql);
			
			for (ComboBean bean : data) {
				out.println("<option value ='" +  bean.getValue() + "'>");
				out.println(bean.getDescripcion());
				out.println("</option>");
			}
			out.println("</select>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return super.doStartTag();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAliasSql() {
		return aliasSql;
	}

	public void setAliasSql(String aliasSql) {
		this.aliasSql = aliasSql;
	}

}

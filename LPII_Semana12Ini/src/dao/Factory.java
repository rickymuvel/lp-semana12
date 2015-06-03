package dao;

public abstract class  Factory {

	public static final int TIPO_MYSQL =1;
	public static final int TIPO_SQL_SERVER =2;

	public abstract AlumnoDao getAlumnoDao();
	public abstract CarreraDao getCarreraDao();
	public abstract ComboDao getComboDao();
	
	public static Factory getTipo(int tipo){
		switch (tipo) {
		case TIPO_MYSQL:
			return new MySqlFactory();
		case TIPO_SQL_SERVER:
			return null;
		}
		return null;
	}
	
	
}

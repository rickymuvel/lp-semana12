package dao;

public class MySqlFactory extends Factory {

	
	

	@Override
	public AlumnoDao getAlumnoDao() {
		return new MySqlAlumnoDao();
	}

	@Override
	public CarreraDao getCarreraDao() {
		return new MySqlCarreraDao();
	}

	@Override
	public ComboDao getComboDao() {
		return new MySqlComboDAO();
	}
}

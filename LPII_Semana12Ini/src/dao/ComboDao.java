package dao;

import java.util.List;

import beans.ComboBean;

public interface ComboDao {

	public List<ComboBean> ejecutaSQL(String sql) throws Exception;	
}

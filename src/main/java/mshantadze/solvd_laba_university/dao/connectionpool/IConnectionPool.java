package mshantadze.solvd_laba_university.dao.connectionpool;

import java.sql.Connection;

public interface IConnectionPool {
	public Connection getConnection();
}

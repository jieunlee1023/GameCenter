public class DB_JAVA {

	Web web;
	MySQLDao dao = new MySQLDao();
	MssqlDao dao2 = new MssqlDao();
	OracleDao dao3 = new OracleDao();

	public DB_JAVA() {
		web = new Web(dao3);
	}

	public static void main(String[] args) {

		DB_JAVA db_JAVA = new DB_JAVA();

		db_JAVA.web.select();

	}

}

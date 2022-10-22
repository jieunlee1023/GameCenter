
public class MySQLDao implements IDBService {

	Web web;

	public MySQLDao() {
//		web = new Web(this);
	}

	@Override
	public void select() {
		System.out.println("MySQLDao 메서드 호출");

	}

}

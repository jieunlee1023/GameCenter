
public class OracleDao implements IDBService {

	Web web;

	public OracleDao() {
//		web = new Web(this);
	}

	@Override
	public void select() {
		System.out.println("Oracle 메서드 호출");
	}

}

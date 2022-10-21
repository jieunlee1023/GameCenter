
public class MssqlDao implements IDBService {

	Web web;

	public MssqlDao() {
		web = new Web(this);
	}

	@Override
	public void select() {
		System.out.println("MssqlDao 메서드 호출");
	}

}

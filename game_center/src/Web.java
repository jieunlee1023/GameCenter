
public class Web {

	IDBService idbService;

	public Web(IDBService idbService) {
		this.idbService = idbService;
	}

	void select() {
		idbService.select();
	}
}

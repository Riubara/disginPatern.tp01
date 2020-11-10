package tp1.entities;

import java.util.ArrayList;
import java.util.List;

public class EntitySingleton {

	private EntitySingleton() {
		this.myList = new ArrayList<Entity1>();

		for (int i = 0; i < 20; i++) {
			Entity1 e1 = new Entity1();
			e1.setId(i);
			e1.setData("data " + i);
			this.myList.add(e1);
		}

	}

	private static EntitySingleton INSTANCE = null;
	private List<Entity1> myList;

	public static synchronized EntitySingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new EntitySingleton();
		}
		return INSTANCE;
	}

	public List<Entity1> getMyList() {
		return myList;
	}
	
	public void setMyList(List<Entity1> myList) {
		this.myList = myList;
	}
	
	public void addEntity(Entity1 e1) {
		e1.setId(getLastId());
		this.myList.add(e1);
	}
	
	public void removeEntity(Entity1 e1) {
		this.myList.remove(e1);
	}
	
	public void removeEntity(int idx) {
		this.myList.remove(idx);
	}
	
	private long getLastId() {
		Entity1 last = this.myList.get(this.myList.size()-1);
		return last.getId() + 1L;
	}
}

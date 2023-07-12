package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Location salvata correttamente");
	}

	public Location findById(long id) {
		Location found = em.find(Location.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {

		Location found = em.find(Location.class, id);
		if (found != null) {

			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			System.out.println("Location eliminata correttamente");
		} else {
			System.out.println("Location non trovata");
		}
	}

	public void refresh(long id) {
		Location found = em.find(Location.class, id);
		found.setId(id);

		System.out.println("PRE REFRESH");
		System.out.println(found);

		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);

	}
}

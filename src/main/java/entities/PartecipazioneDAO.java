package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

	private final EntityManager em;

	public PartecipazioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Partecipazione s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Partecipazione salvata correttamente");
	}

	public Partecipazione findById(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {

		Partecipazione found = em.find(Partecipazione.class, id);
		if (found != null) {

			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			System.out.println("Partecipazione eliminato correttamente");
		} else {
			System.out.println("Partecipazione non trovato");
		}
	}

	public void refresh(long id) {
		Partecipazione found = em.find(Partecipazione.class, id);
		found.setId(id);

		System.out.println("PRE REFRESH");
		System.out.println(found);

		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);

	}
}

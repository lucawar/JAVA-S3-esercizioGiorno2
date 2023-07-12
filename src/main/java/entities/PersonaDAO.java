package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {

	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona s) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(s);

		t.commit();

		System.out.println("Persona salvata correttamente");
	}

	public Persona findById(long id) {
		Persona found = em.find(Persona.class, id);
		return found;
	}

	public void findByIdAndDelete(long id) {

		Persona found = em.find(Persona.class, id);
		if (found != null) {

			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(found);

			t.commit();
			System.out.println("Persona eliminato correttamente");
		} else {
			System.out.println("Persona non trovato");
		}
	}

	public void refresh(long id) {
		Persona found = em.find(Persona.class, id);
		found.setId(id);

		System.out.println("PRE REFRESH");
		System.out.println(found);

		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);

	}
}
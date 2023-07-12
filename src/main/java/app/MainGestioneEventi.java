package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.EventType;
import entities.Evento;
import entities.EventoDAO;
import entities.GenereType;
import entities.Location;
import entities.LocationDAO;
import entities.Partecipazione;
import entities.PartecipazioneDAO;
import entities.PartecipazioneType;
import entities.Persona;
import entities.PersonaDAO;
import util.JpaUtil;

public class MainGestioneEventi {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		System.out.println("CIAO");

		PersonaDAO pd = new PersonaDAO(em);
		LocationDAO lt = new LocationDAO(em);
		EventoDAO sd = new EventoDAO(em);
		PartecipazioneDAO pt = new PartecipazioneDAO(em);

		Persona persona1 = new Persona("Luca", "Guerra", "Luca@yahoo.it", "1992-11-05", GenereType.MASCHIO);
		pd.save(persona1);

		Location location1 = new Location("Villa Borghese", "Roma");
		lt.save(location1);

		Evento evento1 = new Evento("Ricevimento", "2022-03-25", "festa di compleanno", EventType.PRIVATO, 60);
		sd.save(evento1);

		Partecipazione ptc = new Partecipazione();
		ptc.setPersona(persona1);
		ptc.setEvento(evento1);
		ptc.setStato(PartecipazioneType.CONFERMATA);

		evento1.getListaPartecipazioni().add(ptc);

		evento1.setLocation(location1);

		pt.save(ptc);

		// CERCO EVENTI NEL DATEBASE
		// Evento cercaFromDB = sd.findById(1);
		// System.out.println(cercaFromDB);

		// CANCELLO EVENTI
		sd.findByIdAndDelete(7);

		em.close();
		emf.close();
	}

}

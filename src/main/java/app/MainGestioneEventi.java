package app;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.EventType;
import entities.Evento;
import entities.EventoDAO;
import util.JpaUtil;

public class MainGestioneEventi {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		System.out.println("CIAO");

		Evento evento1 = new Evento("Ricevimento", "2022-03-25", "festa di compleanno", EventType.PRIVATO, 60);
		Evento evento2 = new Evento("Pranzo", "2022-05-25", "prenzo aziendale", EventType.PRIVATO, 300);
		Evento evento3 = new Evento("Festa di quartiere", "2022-06-25", "matrimonio Flavio", EventType.PUBBLICO, 500);
		Evento evento4 = new Evento("Addio al celibato", "2022-08-25", "festa per Luca", EventType.PRIVATO, 60);
		EventoDAO sd = new EventoDAO(em);

		sd.save(evento1);
		sd.save(evento2);
		sd.save(evento3);
		sd.save(evento4);

		Evento cercaFromDB = sd.findById(UUID.fromString("a0c14150-ec2f-4faf-930a-79bc3da3692c"));
		System.out.println(cercaFromDB);

		sd.findByIdAndDelete(UUID.fromString("69f9e981-7230-4f13-990b-e577a9ea8268"));

		em.close();
		emf.close();
	}

}

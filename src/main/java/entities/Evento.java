package entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@NoArgsConstructor
public class Evento {

	@Id
	@GeneratedValue
	private long id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private int numeroMassimo;

	@Enumerated(EnumType.STRING)
	private EventType tipoEvento;

	@OneToOne
	private Location location;

	@OneToMany(mappedBy = "evento")
	private Set<Partecipazione> listaPartecipazioni;

	public Evento(String titolo, String dataEvento, String descrizione, EventType tipoEvento, int numeroMassimo) {

		this.titolo = titolo;
		this.dataEvento = LocalDate.parse(dataEvento);
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimo = numeroMassimo;
		this.listaPartecipazioni = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimo=" + numeroMassimo + "]";
	}

}

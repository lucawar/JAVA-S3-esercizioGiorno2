package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partecipazione")
@Getter
@Setter
@NoArgsConstructor

public class Partecipazione {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id", nullable = false)
	private Evento evento;

	@Enumerated(EnumType.STRING)
	private PartecipazioneType stato;

	public Partecipazione(Persona persona, Evento evento, PartecipazioneType stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", stato=" + stato + "]";
	}

}

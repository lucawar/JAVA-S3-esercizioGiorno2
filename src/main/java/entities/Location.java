package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Location {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String citta;

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

}

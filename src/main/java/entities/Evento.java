package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventi")
public class Evento {

	@Id
	@GeneratedValue
	private UUID id;
}

package pl.edu.pk.middle.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATCH_UNIT")
@Access(value = AccessType.FIELD)
public class MatchUnit implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "MATCH_UNIT_ID")
	private Integer id;
	@Column(name = "TEAM_ONE")
	private String teamOne;
	@Column(name = "TEAM_TWO")
	private String teamTwo;
	@Column(name = "DESCRIPTION")
	private String description;

}
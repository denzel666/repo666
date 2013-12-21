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
@Table(name = "MATCH_SET")
@Access(value = AccessType.FIELD)
public class MatchSet implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "MATCH_SET_ID")
	private Integer id;
	@Column(name = "TEAM_ONE")
	private String teamOne;
	@Column(name = "TEAM_TWO")
	private String teamTwo;
	@Column(name = "RESULT")
	private String result;
	@Column(name = "DESCRIPTION")
	private String description;

}

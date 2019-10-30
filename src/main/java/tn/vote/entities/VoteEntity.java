package tn.vote.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vote")
public class VoteEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="id_electeur")
	private long id_electeur;
	
	@Column(name="id_candidat")
	private long id_candidat;
	
	@Column(name="id_election")
	private long id_election;
	
	@Column(name="heure_vote")
	private String  heure_vote;
	
	public VoteEntity() {
		super();
	}
	
	public VoteEntity(long id_candidat , long id_electeur , long id_election , String heure_vote) {
		super();
		this.id_candidat = id_candidat;
		this.id_electeur = id_electeur;
		this.id_election = id_election;
		this.heure_vote=heure_vote;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeure() {
		return heure_vote;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VoteEntity other = (VoteEntity) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
	
}

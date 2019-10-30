package tn.vote.entities;

import java.io.Serializable;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Election")
public class ElectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_election")
	private long id_election;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "heure_deb", nullable = false)
	private String heure_deb;
	
	@Column(name = "heure_fin", nullable = false)
	private String heure_fin;
	
	@Column(name = "etat", nullable = false)
	private String etat;
	
	@Column(name = "type", nullable = false)
	private String type;
	


	public ElectionEntity() {
		super();
	}
	

	public ElectionEntity(Date date, String heure_deb,String heure_fin , String etat , String type) {
		super();
		
		this.date = date;
		this.heure_deb = heure_deb;
		this.heure_fin = heure_fin;
		this.etat = etat;
		this.type = type;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_election ^ (id_election >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectionEntity other = (ElectionEntity) obj;
		if (id_election != other.id_election)
			return false;
		return true;
	}

	public long getId() {
		return id_election;
	}

	public void setId(long id) {
		this.id_election = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getHeuredeb() {
		return heure_deb;
	}

	public void setHeuredeb(String deb) {
		this.heure_deb = deb;
	}
	public String getHeurefin() {
		return heure_fin;
	}

	public void setHeurefin(String fin) {
		this.heure_fin = fin;
	}
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	@Override
	public String toString() {
		return "Election [id=" + id_election + ", date=" + date + ", heure_deb=" + heure_deb + ",heure_fin=" + heure_fin +" ,type=" + type +" ]";
	}


}

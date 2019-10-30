package tn.vote.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "candidat")
public class CandidatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidat_id")
	private long candidat_id;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name = "cin", nullable = false, unique = true)
	@Email(message = "*Please provide a valid Cin")
	@NotEmpty(message = "*Please provide an Cin")
	private String cin;

	@Column(name = "nationnalite")
	@NotEmpty(message = "*Please provide your nationnality")
	@Transient
	private String nationnalite;

	@Column(name = "nom")
	@NotEmpty(message = "*Please provide your name")
	private String nom;

	@Column(name = "prenom")
	@NotEmpty(message = "*Please provide your last name")
	private String prenom;
	
	@Column(name = "date_naissance")
	@NotEmpty(message = "*Please provide your last birthday")
	private Date date_naissance;

	@Column(name = "addresse")
	private String addresse;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "sexe")
	private String sexe;
	
	@Column(name = "situation_familiale")
	private String situation_familiale;
	
	@Column(name = "origine")
	private String origine;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "participation_candidat", joinColumns = @JoinColumn(name = "id_candidat"), inverseJoinColumns = @JoinColumn(name = "id_election"))
	private Set<ElectionEntity> elections;
	
	
	
	

	public CandidatEntity() {
		super();
	}
	
	public CandidatEntity(String email, String cin, String nom, String prenom, String addresse,
			String tel, String origine, String sexe , String situation_familiale , String nationnalite, Date date_naissance) {
		super();
		this.email = email;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.tel = tel;
		this.origine = origine;
		this.sexe= sexe;
		this.situation_familiale = situation_familiale;
		this.nationnalite = nationnalite;
		this.date_naissance=date_naissance;
	}

	public String getNom() {
		return nom;
	}

	public void setName(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddress() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	
	public String getSexe() {
		return addresse;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSituation() {
		return situation_familiale;
	}

	public void setSituation(String situation) {
		this.situation_familiale = situation;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public long getId() {
		return candidat_id;
	}

	public void setId(long id) {
		this.candidat_id = candidat_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (candidat_id ^ (candidat_id >>> 32));
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
		CandidatEntity other = (CandidatEntity) obj;
		if (candidat_id != other.candidat_id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CandidatEntity [id=" + candidat_id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", situation_familiale=" + situation_familiale + ", addresse=" + addresse + ", sexe=" +sexe + ", origine="+origine  + ", nationnalite=" + nationnalite +  "]";
	}

}

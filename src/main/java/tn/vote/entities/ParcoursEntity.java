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


import org.hibernate.validator.constraints.Email;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "parcours")
public class ParcoursEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_parcours")
	private long id_parcours;

	@Column(name = "date", nullable = false)
	@Email(message = "*Please provide a valid Date")
	@NotEmpty(message = "*Please provide an Date")
	private Date date;
	
	@Column(name = "lieu", nullable = false)
	@Email(message = "*Please provide a valid lieu")
	@NotEmpty(message = "*Please provide an lieu")
	private String lieu;

	@Column(name = "description")
	@NotEmpty(message = "*Please provide your description")
	@Transient
	private String description;

	@Column(name = "nom_societe", nullable =true)
	@NotEmpty(message = "*Please provide your name of society")
	private String nom_societe;

	@Column(name = "adresse_societe" , nullable =true)
	@NotEmpty(message = "*Please provide your adress of society")
	private String adresse_societe;
	
	@Column(name = "tel_societe" , nullable =true)
	@NotEmpty(message = "*Please provide your tel of society")
	private String tel_societe;

	@Column(name = "diplome"  , nullable =true)
	private String diplome;
	
	@Column(name = "certification" , nullable =true)
	private String certification;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "id_candidat")
	private long id_candidat;

	public ParcoursEntity() {
		super();
	}
	
	public ParcoursEntity(Date date, String lieu, String description, String type, String nom_societe,
			String adresse_societe, String tel_societe, String diplome,String certification,long id_candidat) {
		super();
		this.date = date;
		this.lieu = lieu;
		this.description = description;
		this.type = type;
		this.nom_societe = nom_societe;
		this.adresse_societe = adresse_societe;
		this.tel_societe = tel_societe;
		this.diplome= diplome;
		this.certification = certification;
		this.id_candidat = id_candidat;
		
	}

	public long getId_parcours() {
		return id_parcours;
	}

	public void setId_parcours(long id_parcours) {
		this.id_parcours = id_parcours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom_societe() {
		return nom_societe;
	}

	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}

	public String getAdresse_societe() {
		return adresse_societe;
	}

	public void setAdresse_societe(String adresse_societe) {
		this.adresse_societe = adresse_societe;
	}

	public String getTel_societe() {
		return tel_societe;
	}

	public void setTel_societe(String tel_societe) {
		this.tel_societe = tel_societe;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId_candidat() {
		return id_candidat;
	}

	public void setId_candidat(long id_candidat) {
		this.id_candidat = id_candidat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse_societe == null) ? 0 : adresse_societe.hashCode());
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((diplome == null) ? 0 : diplome.hashCode());
		result = prime * result + (int) (id_candidat ^ (id_candidat >>> 32));
		result = prime * result + (int) (id_parcours ^ (id_parcours >>> 32));
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((nom_societe == null) ? 0 : nom_societe.hashCode());
		result = prime * result + ((tel_societe == null) ? 0 : tel_societe.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ParcoursEntity other = (ParcoursEntity) obj;
		if (adresse_societe == null) {
			if (other.adresse_societe != null)
				return false;
		} else if (!adresse_societe.equals(other.adresse_societe))
			return false;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (diplome == null) {
			if (other.diplome != null)
				return false;
		} else if (!diplome.equals(other.diplome))
			return false;
		if (id_candidat != other.id_candidat)
			return false;
		if (id_parcours != other.id_parcours)
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (nom_societe == null) {
			if (other.nom_societe != null)
				return false;
		} else if (!nom_societe.equals(other.nom_societe))
			return false;
		if (tel_societe == null) {
			if (other.tel_societe != null)
				return false;
		} else if (!tel_societe.equals(other.tel_societe))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ParcoursEntity [id_parcours=" + id_parcours + ", date=" + date + ", lieu=" + lieu + ", description="
				+ description + ", nom_societe=" + nom_societe + ", adresse_societe=" + adresse_societe
				+ ", tel_societe=" + tel_societe + ", diplome=" + diplome + ", certification=" + certification
				+ ", type=" + type + ", id_candidat=" + id_candidat + "]";
	}

	}

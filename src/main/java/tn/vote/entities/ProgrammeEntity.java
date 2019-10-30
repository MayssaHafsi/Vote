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
@Table(name = "programme")
public class ProgrammeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_prog")
	private long id_prog;

	@Column(name = "date_pub", nullable = false)
	@Email(message = "*Please provide a valid Date")
	@NotEmpty(message = "*Please provide an Date")
	private Date date_pub;
	
	@Column(name = "titre_prog", nullable = false)
	@Email(message = "*Please provide a valid title")
	@NotEmpty(message = "*Please provide an title")
	private String titre_prog;

	@Column(name = "desc_prog")
	@NotEmpty(message = "*Please provide your description")
	@Transient
	private String desc_prog;
		
	@Column(name = "id_candidat")
	private long id_candidat;
	
	@Column(name = "id_cat")
	private long id_cat;

	
	public ProgrammeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ProgrammeEntity(long id_prog, Date date_pub, String titre_prog, String desc_prog, long id_candidat,
			long id_cat) {
		super();
		this.id_prog = id_prog;
		this.date_pub = date_pub;
		this.titre_prog = titre_prog;
		this.desc_prog = desc_prog;
		this.id_candidat = id_candidat;
		this.id_cat = id_cat;
	}


	public long getId_prog() {
		return id_prog;
	}


	public void setId_prog(long id_prog) {
		this.id_prog = id_prog;
	}


	public Date getDate_pub() {
		return date_pub;
	}


	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}


	public String getTitre_prog() {
		return titre_prog;
	}


	public void setTitre_prog(String titre_prog) {
		this.titre_prog = titre_prog;
	}


	public String getDesc_prog() {
		return desc_prog;
	}


	public void setDesc_prog(String desc_prog) {
		this.desc_prog = desc_prog;
	}


	public long getId_candidat() {
		return id_candidat;
	}


	public void setId_candidat(long id_candidat) {
		this.id_candidat = id_candidat;
	}


	public long getId_cat() {
		return id_cat;
	}


	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_pub == null) ? 0 : date_pub.hashCode());
		result = prime * result + ((desc_prog == null) ? 0 : desc_prog.hashCode());
		result = prime * result + (int) (id_candidat ^ (id_candidat >>> 32));
		result = prime * result + (int) (id_cat ^ (id_cat >>> 32));
		result = prime * result + (int) (id_prog ^ (id_prog >>> 32));
		result = prime * result + ((titre_prog == null) ? 0 : titre_prog.hashCode());
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
		ProgrammeEntity other = (ProgrammeEntity) obj;
		if (date_pub == null) {
			if (other.date_pub != null)
				return false;
		} else if (!date_pub.equals(other.date_pub))
			return false;
		if (desc_prog == null) {
			if (other.desc_prog != null)
				return false;
		} else if (!desc_prog.equals(other.desc_prog))
			return false;
		if (id_candidat != other.id_candidat)
			return false;
		if (id_cat != other.id_cat)
			return false;
		if (id_prog != other.id_prog)
			return false;
		if (titre_prog == null) {
			if (other.titre_prog != null)
				return false;
		} else if (!titre_prog.equals(other.titre_prog))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProgrammeEntity [id_prog=" + id_prog + ", date_pub=" + date_pub + ", titre_prog=" + titre_prog
				+ ", desc_prog=" + desc_prog + ", id_candidat=" + id_candidat + ", id_cat=" + id_cat + "]";
	}
	


		}

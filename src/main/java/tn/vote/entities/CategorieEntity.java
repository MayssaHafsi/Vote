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
@Table(name = "categorie")
public class CategorieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cat")
	private long id_cat;

	@Column(name = "cat", nullable = false)
	private String cat;

	public CategorieEntity(long id_cat, String cat) {
		super();
		this.id_cat = id_cat;
		this.cat = cat;
	}

	public CategorieEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId_cat() {
		return id_cat;
	}

	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	
	
	
	

	

}

package br.com.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=64, nullable=false)
	private String name;
	
	@Column(length=64, nullable=false, unique=true)
	private String slug;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Offer> offers;


	public Category(final Integer id, final String name, final String slug) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.offers = new ArrayList<Offer>();
	}
	
	public Category( final String name, final String slug) {
		super();
		this.id = null;
		this.name = name;
		this.slug = slug;
		this.offers = new ArrayList<Offer>();
	}


	public Category() {
		super();
		this.id = null;
		this.name = null;
		this.slug = null;
		this.offers = new ArrayList<Offer>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((slug == null) ? 0 : slug.hashCode());
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (slug == null) {
			if (other.slug != null)
				return false;
		} else if (!slug.equals(other.slug))
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", slug=" + slug + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public void setOffer(Offer offer) {
		this.offers.add(offer);
	}
	
	
	
}

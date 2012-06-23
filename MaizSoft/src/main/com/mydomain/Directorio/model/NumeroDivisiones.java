/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.jboss.seam.annotations.Name;

import com.sun.istack.internal.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version {date}
 */
@Entity
@Name("numeroDivisiones")
@Table(name="numero_divisones")
public class NumeroDivisiones {

	
	private Long id; 
	
	
	private Integer numeroDivision;
	
	
	
	private Actividad actividad;
	
	private GrupoCurso grupoCurso;
	


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the numeroDivision
	 */
	public Integer getNumeroDivision() {
		return numeroDivision;
	}


	/**
	 * @param numeroDivision the numeroDivision to set
	 */
	public void setNumeroDivision(Integer numeroDivision) {
		this.numeroDivision = numeroDivision;
	}


	/**
	 * @return the actividad
	 */
	@ManyToOne
	@NotNull
	public Actividad getActividad() {
		return actividad;
	}


	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}


	/**
	 * @return the grupoCurso
	 */
	@ManyToOne
	@NotNull
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}


	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}


	
	
	
}
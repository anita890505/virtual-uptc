package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
* Descripcion: Esta Clase se encarga de indicar y almacenar informaci�n
* relacionada con los usuarios de los grupos.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 22/06/2012 
*/
@Entity
@Table(name ="grupo_usuarios")
public class GrupoUsuarios {

	/**
	 * Variable que almacena la identificaci�n del grupo de usuarios del curso.
	 */
	private Long idGrupoUsuarios;
	
	/**
	 * Variable encargada de almacenar los datos de los usuarios del curso.
	 * Instancia de la clase Usuario.
	 */
	private Usuario userGrupoCurso;
	
	/**
	 * Variable encargada de hacer referencia a la informaci�n del grupo.
	 * Instancia de la clase GrupoCurso.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Variable que almacena la lista de las notas de las actividades
	 * obtenidas por los usuarios del grupo.
	 */
	private Set<NotaActividad> notaActividades;
	
	/**
	 * Variable que hace referencia a la informaci�n de la cuenta del usuario.
	 * Instancia de la clase CuentasUsuario.
	 */
	private CuentasUsuario userRole;
	
	
	/**
	 * Se obtiene el valor de userGrupoCurso
	 * @return El valor de userGrupoCurso
	 */
	@ManyToOne
	public Usuario getUserGrupoCurso() {
		return userGrupoCurso;
	}

	/**
	 * Se obtiene el valor de idGrupoUsuarios
	 * @return El valor de idGrupoUsuarios
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdGrupoUsuarios() {
		return idGrupoUsuarios;
	}

	/**
	 * Asigna el valor de idGrupoUsuarios
	 * @param idGrupoUsuarios El valor por establecer para idGrupoUsuarios
	 */
	public void setIdGrupoUsuarios(Long idGrupoUsuarios) {
		this.idGrupoUsuarios = idGrupoUsuarios;
	}
	
	/**
	 * Se obtiene el valor de grupoCurso
	 * @return El valor de grupoCurso
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * @param grupoCurso El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * Asigna el valor de userGrupoCurso
	 * @param userGrupoCurso El valor por establecer para userGrupoCurso
	 */
	public void setUserGrupoCurso(Usuario userGrupoCurso) {
		this.userGrupoCurso = userGrupoCurso;
	}

	/**
	 * Se obtiene el valor de notaActividades
	 * @return El valor de notaActividades
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividades() {
		if(notaActividades==null){
			return new HashSet<NotaActividad>();
		}
		return notaActividades;
	}

	/**
	 * Asigna el valor de notaActividades
	 * @param notaActividades El valor por establecer para notaActividades
	 */
	public void setNotaActividades(Set<NotaActividad> notaActividades) {
		this.notaActividades = notaActividades;
	}
	
	/**
	 * Se obtiene el valor de userRole
	 * @return El valor de userRole
	 */
	@NotNull
	@OneToOne(mappedBy="grupoUsuarios")
	public CuentasUsuario getUserRole() {
		return userRole;
	}

	/**
	 * Asigna el valor de userRole
	 * @param userRole El valor por establecer para userRole
	 */
	public void setUserRole(CuentasUsuario userRole) {
		this.userRole = userRole;
	}
}

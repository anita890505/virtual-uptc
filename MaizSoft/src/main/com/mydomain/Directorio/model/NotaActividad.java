package com.mydomain.Directorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Range;
import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de almacenar toda la informaci�n
 * relacionada con las calificaciones obtenidas por los usuarios en las
 * actividades realizadas por cada uno de ellos. Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 23/06/2012
 */
@Entity(name = "NotaActividad")
@Table(name = "nota_actividad")
@Name("notaActividad")
public class NotaActividad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable encargada de almacenar el identificador de las notas o
	 * calificaciones de determinada actividad.
	 */
	private Long idNotaActividad;

	/**
	 * Variable encargada de informar si el estado de la nota de determinada
	 * actividad est� pendiente o ya fue asignada.
	 */
	private boolean estadoPendiente;

	/**
	 * Variable encargada de almacenar la descripci�n de la justificaci�n de
	 * la nota o calificaci�n de determinada actividad.
	 */
	private String justificacion;

	/**
	 * Variable encargada de almacenar lo referente a cargar archivos en la
	 * plataforma. Instancia de la clase GestorCargaArchivos.
	 */
	private GestorCargaArchivos gestorCargaArchivos;

	/**
	 * Variable encargada de guardar la informaci�n relacionada a las
	 * diferentes actividades planteadas en la plataforma. Instancia de la clase
	 * Actividad.
	 */
	private Actividad actividad;
	/**
	 * Variable encargada de almacenar informaci�n competente a los grupos de
	 * usuarios
	 */
	private GrupoUsuarios grupoCurso;

	/**
	 * Variable encargada de almacenar informaci�n relacionada con
	 * mensajer�a. Instancia de la clase GestorMensajeria.
	 */
	private GestorMensajeria gestorMensajeria;

	/**
	 * Variable encargada de guardar las notas o calificaciones obtenidas por
	 * determinado usuario en una actividad dada.
	 */
	private Double nota;

	private Usuario usuario;
	
	private transient Tipo tipo;
	
	private transient Actividad actividad2;
	
	
	private static transient Long idActivida =1L;

	/**
	 * Se obtiene el valor de idNotaActividad
	 * 
	 * @return El valor de idNotaActividad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_nota_actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdNotaActividad() {
		return idNotaActividad;
	}

	/**
	 * Asigna el valor de idNotaActividad
	 * 
	 * @param idNotaActividad
	 *            El valor por establecer para idNotaActividad
	 */
	public void setIdNotaActividad(Long idNotaActividad) {
		this.idNotaActividad = idNotaActividad;
	}

	/**
	 * Se obtiene el valor de estadoPendiente
	 * 
	 * @return El valor de estadoPendiente
	 */
	@Column(name = "estado_pendiente", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "bit(1)")
	public boolean isEstadoPendiente() {
		return estadoPendiente;
	}

	/**
	 * Asigna el valor de estadoPendiente
	 * 
	 * @param estadoPendiente
	 *            El valor por establecer para estadoPendiente
	 */
	public void setEstadoPendiente(boolean estadoPendiente) {
		this.estadoPendiente = estadoPendiente;
	}

	/**
	 * Se obtiene el valor de justificacion
	 * 
	 * @return El valor de justificacion
	 */
	@Length(max = 300)
	@Column(name = "justificacion", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getJustificacion() {
		return justificacion;
	}

	/**
	 * Asigna el valor de justificacion
	 * 
	 * @param justificacion
	 *            El valor por establecer para justificacion
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	/**
	 * Se obtiene el valor de gestorCargaArchivos
	 * 
	 * @return El valor de gestorCargaArchivos
	 */
	@ManyToOne
	@JoinColumn(name = "id_gestor_carga_archivos", unique = false, nullable = true, insertable = true, updatable = true)
	public GestorCargaArchivos getGestorCargaArchivos() {
		return gestorCargaArchivos;
	}

	/**
	 * Asigna el valor de gestorCargaArchivos
	 * 
	 * @param gestorCargaArchivos
	 *            El valor por establecer para gestorCargaArchivos
	 */
	public void setGestorCargaArchivos(GestorCargaArchivos gestorCargaArchivos) {
		this.gestorCargaArchivos = gestorCargaArchivos;
	}

	/**
	 * Se obtiene el valor de actividad
	 * 
	 * @return El valor de actividad
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * Asigna el valor de actividad
	 * 
	 * @param actividad
	 *            El valor por establecer para actividad
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	/**
	 * Se obtiene el valor de grupoCurso
	 * 
	 * @return El valor de grupoCurso
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_grupo_usuarios", unique = false, nullable = false, insertable = true, updatable = true)
	public GrupoUsuarios getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * 
	 * @param grupoCurso
	 *            El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoUsuarios grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * Se obtiene el valor de gestorMensajeria
	 * 
	 * @return El valor de gestorMensajeria
	 */
	@ManyToOne
	@JoinColumn(name = "id_gestor_mensajeria", unique = false, nullable = true, insertable = true, updatable = true)
	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}

	/**
	 * Asigna el valor de gestorMensajeria
	 * 
	 * @param gestorMensajeria
	 *            El valor por establecer para gestorMensajeria
	 */
	public void setGestorMensajeria(GestorMensajeria gestorMensajeria) {
		this.gestorMensajeria = gestorMensajeria;
	}

	/**
	 * Se obtiene el valor de nota
	 * 
	 * @return El valor de nota
	 */
	@NotNull
	@Range(min = 0, max = 5)
	@Column(name = "nota", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "double")
	public double getNota() {
		return nota;
	}

	/**
	 * Asigna el valor de nota
	 * 
	 * @param nota
	 *            El valor por establecer para nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * Se obtiene el valor de usuario
	 * 
	 * @return El valor de usuario
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", unique = false, nullable = false, insertable = true, updatable = true)
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Asigna el valor de usuario
	 * 
	 * @param usuario
	 *            El valor por establecer para usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Se obtiene el valor de tipo
	 * @return El valor de tipo
	 */
	@Transient
	public Tipo getTipo() {
		if(tipo==null)
			return new Tipo();
		return tipo;
	}

	/**
	 * Asigna el valor de tipo
	 * @param tipo El valor por establecer para tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Se obtiene el valor de actividad2
	 * @return El valor de actividad2
	 */
	@Transient
	public Actividad getActividad2() {
		if(actividad2!=null)
			idActivida=actividad2.getIdActividad();
		System.out.println(idActivida +"ID ACTIVIDAD");
		return actividad2;
	}

	/**
	 * Asigna el valor de actividad2
	 * @param actividad2 El valor por establecer para actividad2
	 */
	public void setActividad2(Actividad actividad2) {
		this.actividad2 = actividad2;
	}

	/**
	 * Se obtiene el valor de idActivida
	 * @return El valor de idActivida
	 */
	@Transient
	public static Long getIdActivida() {
		return idActivida;
	}

	/**
	 * Asigna el valor de idActivida
	 * @param idActivida El valor por establecer para idActivida
	 */
	public static void setIdActivida(Long idActivida) {
		NotaActividad.idActivida = idActivida;
	}

	
	
	
	

}

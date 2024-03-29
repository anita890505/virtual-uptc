package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.management.UserEnabled;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;

/**
 * Descripcion: Esta Clase se encarga de almacenar la informaci�n
 * perteneciente a las cuentas de los usuarios de la plataforma. Modulo de
 * Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 23/06/2012
 */
@Entity(name = "UserAccount")
@Name("userAccount")
@Table(name = "user_account")
@Scope(ScopeType.SESSION)
public class UserAccount implements Serializable {

	/**
	 * Representa la version de serealizacion de la clase
	 */
	private static final long serialVersionUID = 6368734442192368866L;

	/**
	 * Id del usuario
	 */
	private Long id;

	/**
	 * Nombre de usuario de identificacion de la plataforma
	 */
	private String username;
	/**
	 * Contrasenia de usuario para logueo de la plataforma
	 */
	private String passwordHash;

	/**
	 * Representa el estado de la cuenta activa/inactiva
	 */
	private boolean enabled;

	/**
	 * Lista de roles que desemplenia el usuario dentro de la plataforma
	 */
	private Set<UserRole> roles;
	/**
	 * Lista de cuentas del usuario dentro de la plataforma.
	 */

	private Set<CuentasUsuario> cuentasUsuarios;
	
	
	private String campoGenerarPassword;
	
	private Date fechaCreacion;

	/**
	 * Constructor de la clase
	 */
	public UserAccount() {
		enabled = true;
	}

	/**
	 * Se obtiene el valor de id
	 * 
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_account", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el valor de id
	 * 
	 * @param id
	 *            El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Se obtiene el valor de username
	 * 
	 * @return El valor de usuername
	 */

	@NotNull
	@UserPrincipal
	@Column(name = "username", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getUsername() {
		return username;
	}

	/**
	 * Asigna el valor de username
	 * 
	 * @param username
	 *            El valor por establecer para id
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Se obtiene el valor de passwordHash
	 * 
	 * @return El valor de passwordHash
	 */
	@UserPassword(hash = "SHA")
	@Column(name = "password_hash", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Asigna el valor de passwordHash
	 * 
	 * @param passwordHash
	 *            El valor por establecer para passwordHash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Se obtiene el valor de enabled
	 * 
	 * @return El valor de enabled
	 */
	@UserEnabled
	@Column(name = "enabled", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "bit(1)")
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Asigna el valor de enabled
	 * 
	 * @param enabled
	 *            El valor por establecer para enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Se obtiene el valor de roles
	 * 
	 * @return El valor de roles
	 */
	@UserRoles
	@ManyToMany
	@JoinTable(name = "user_account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "member_of_role"))
	public Set<UserRole> getRoles() {
		return roles;
	}

	/**
	 * Asigna el valor de roles
	 * 
	 * @param roles
	 *            El valor por establecer para roles
	 */
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * Se obtiene el valor de cuentasUsuarios
	 * 
	 * @return El valor de cuentasUsuarios
	 */
	@OneToMany(mappedBy = "userAccounts", cascade = CascadeType.ALL)
	public Set<CuentasUsuario> getCuentasUsuarios() {
		if (cuentasUsuarios == null) {
			return new HashSet<CuentasUsuario>();
		}
		return cuentasUsuarios;
	}

	/**
	 * Asigna el valor de cuentasUsuarios
	 * 
	 * @param cuentasUsuarios
	 *            El valor por establecer para cuentasUsuarios
	 */
	public void setCuentasUsuarios(Set<CuentasUsuario> cuentasUsuarios) {
		this.cuentasUsuarios = cuentasUsuarios;
	}

	/**
	 * Se obtiene el valor de campoGenerarPasswaord
	 * @return El valor de campoGenerarPasswaord
	 */
	@Column(name = "campo_generar_password", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(60)")
	public String getCampoGenerarPassword() {
		return campoGenerarPassword;
	}

	/**
	 * Asigna el valor de campoGenerarPasswaord
	 * @param campoGenerarPasswaord El valor por establecer para campoGenerarPasswaord
	 */
	public void setCampoGenerarPassword(String campoGenerarPasswaord) {
		this.campoGenerarPassword = campoGenerarPasswaord;
	}

	/**
	 * Se obtiene el valor de fechaCreacion
	 * @return El valor de fechaCreacion
	 */
	@Column(name = "fecha_creacion", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "datetime")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Asigna el valor de fechaCreacion
	 * @param fechaCreacion El valor por establecer para fechaCreacion
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
}

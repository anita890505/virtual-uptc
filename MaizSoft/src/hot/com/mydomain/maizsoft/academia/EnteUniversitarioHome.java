package com.mydomain.maizsoft.academia;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.tipos.TipoHome;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.persister.entity.EntityPersister;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

@Name("enteUniversitarioHome")
public class EnteUniversitarioHome extends EntityHome<EnteUniversitario> {

	@In(create = true)
	EnteUniversitarioHome enteUniversitarioHome;
	@In(create = true)
	TipoHome tipoHome;
	
	@Logger
	private Log log;


	
	public void setEnteUniversitarioIdEnteUniversitario(Long id) {
		setId(id);
	}

	public Long getEnteUniversitarioIdEnteUniversitario() {
		return (Long) getId();
	}

	@Override
	protected EnteUniversitario createInstance() {
		EnteUniversitario enteUniversitario = new EnteUniversitario();
		return enteUniversitario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tipo tipoEnteUniversitario = tipoHome.getDefinedInstance();
		if (tipoEnteUniversitario != null) {
			getInstance().setTipoEnteUniversitario(tipoEnteUniversitario);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipoEnteUniversitario() == null)
			return false;
		return true;
	}

	public EnteUniversitario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Curso> getListaCursosOfrecidos() {
		return getInstance() == null ? null : new ArrayList<Curso>(
				getInstance().getListaCursosOfrecidos());
	}
	public List<EnteUniversitario> getListaEnteUniversitarios() {
		return getInstance() == null ? null : new ArrayList<EnteUniversitario>(
				getInstance().getListaEnteUniversitarios());
	}
	public List<Usuario> getListaUserAccounts() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getListaUserAccounts());
	}
	
	@Factory("listaTiposEnteUniversitarios")
	public List<Tipo> listaTiposEntesUniversitarios() {

		Query q = getEntityManager()
				.createQuery("select t from Tipo t where t.tipo=1");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>)q.getResultList();
	
		return listaTiposEnteUniversitarios;
	}
	
	
	@Factory("listaEnteUniversitariosFacultades")
	public List<EnteUniversitario> listaEntesUniversitarios() {
		
		Query q = getEntityManager()
				.createQuery("select t from EnteUniversitario t where t.tipoEnteUniversitario=19");
		List<EnteUniversitario> listaEntesUniversitarios = (List<EnteUniversitario>)q.getResultList();
	
	
		return listaEntesUniversitarios;
	
	}
	
	public void saveEnteUniversitario(){
		persist();
		crearLog();
	}
	
	public void crearLog() {
		Calendar calendar = Calendar.getInstance();
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);
		log.info("<--" + "[" + ConstantesLog.NOMBRE_PLATAFORMA + "]"
				+ "Acci�n:" + "[" + ConstantesLog.CREAR_ENTE + "]"
				+ "Tipo:" + "[" + instance.getTipoEnteUniversitario().getNombre() + "]"
				+ "Sobre el grupo con ID:" + "[N/A]"
				+ "Realizada por:" + "[" + cre.getUsername() + "]"
				+ "en la fecha:" + "[" + calendar.getTime() + "]" + "-->",
				cre.getUsername());
	}


}

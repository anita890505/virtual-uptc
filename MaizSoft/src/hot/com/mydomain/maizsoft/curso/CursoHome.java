package com.mydomain.maizsoft.curso;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.academia.EnteUniversitarioHome;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cursoHome")
public class CursoHome extends EntityHome<Curso> {

	@In(create = true)
	EnteUniversitarioHome enteUniversitarioHome;
	
	@In(create=true)
	GrupoCursoHome grupoCursoHome;

	public void setCursoCodigo(Long id) {
		setId(id);
	}

	public Long getCursoCodigo() {
		return (Long) getId();
	}

	@Override
	protected Curso createInstance() {
		Curso curso = new Curso();
		return curso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		EnteUniversitario enteUniversitario = enteUniversitarioHome
				.getDefinedInstance();
		if (enteUniversitario != null) {
			getInstance().setEnteUniversitario(enteUniversitario);
		}
	}

	public boolean isWired() {
		if (getInstance().getEnteUniversitario() == null)
			return false;
		return true;
	}

	public Curso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GrupoCurso> getGrupoCursos() {
		return getInstance() == null ? null : new ArrayList<GrupoCurso>(
				getInstance().getGrupoCursos());
	}
	
	public String saveCurso(){
		persist();
		grupoCursoHome.getInstance().setCursoGrupo(getInstance());
		grupoCursoHome.getInstance().setInscritos(0);
		grupoCursoHome.persist();
		return "/CursoList.xhtml";
	}
	
	@Factory("listaEscuelas")
	public List<EnteUniversitario> listaEntesUniversitarios() {

		Query q = getEntityManager()
				.createQuery("select t from EnteUniversitario t where t.tipoEnteUniversitario=20");
		List<EnteUniversitario> listaEntesUniversitarios = (List<EnteUniversitario>)q.getResultList();
		
		return listaEntesUniversitarios;
	
	}

}

package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorEnlacesExternosHome")
public class GestorEnlacesExternosHome
		extends
			EntityHome<GestorEnlacesExternos> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;

	public void setGestorEnlacesExternosIdEnlace(Long id) {
		setId(id);
	}

	public Long getGestorEnlacesExternosIdEnlace() {
		return (Long) getId();
	}

	@Override
	protected GestorEnlacesExternos createInstance() {
		GestorEnlacesExternos gestorEnlacesExternos = new GestorEnlacesExternos();
		return gestorEnlacesExternos;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCurso = grupoCursoHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GestorEnlacesExternos getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}

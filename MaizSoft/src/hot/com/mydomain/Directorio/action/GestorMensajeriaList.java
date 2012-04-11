package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorMensajeriaList")
public class GestorMensajeriaList extends EntityQuery<GestorMensajeria> {

	private static final String EJBQL = "select gestorMensajeria from GestorMensajeria gestorMensajeria";

	private static final String[] RESTRICTIONS = {
			"lower(gestorMensajeria.asunto) like lower(concat(#{gestorMensajeriaList.gestorMensajeria.asunto},'%'))",
			"lower(gestorMensajeria.mensaje) like lower(concat(#{gestorMensajeriaList.gestorMensajeria.mensaje},'%'))",};

	private GestorMensajeria gestorMensajeria = new GestorMensajeria();

	public GestorMensajeriaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}
}

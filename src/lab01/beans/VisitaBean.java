package lab01.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class VisitaBean {

	private String nombres;
	private String correo;
	private String comentarios;
	
	public String cargarLogin() {
		
		return "ir_login";
	}
	
	public String insertarVisita() {
		System.out.println(nombres);
		System.out.println(correo);
		System.out.println(comentarios);
		
		//Guardar un mensaje en REQUEST
		//Accedemos al context del faces, mediante la siguiente linea.
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//Usamos el request.
		HttpServletRequest request = (HttpServletRequest)context.getRequest();
		//Mandamos el mensaje al request.
		request.setAttribute("MSG", "Se registró a: " + correo);
		
		//Limpiando las variables
		nombres = "";
		correo = "";
		comentarios = "";
		
		return "visita_insertado";
	}
	
	//Getters & Setters
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}

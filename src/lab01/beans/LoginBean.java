package lab01.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class LoginBean {

	private String usuario;
	private String clave;
	
	public String logear() {
		String siguiente = "";
		
		if (usuario.equals("admin") && clave.equals("123")) {
			siguiente = "valido";
			System.out.println("se obtuvo 1: " + siguiente);
		} else {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest request = (HttpServletRequest)context.getRequest();
			request.setAttribute("MSG", "Usuario y/o clave incorrectos.") ;
			siguiente = "invalido";
			System.out.println("se obtuvo 2: " + siguiente);
		}
		
		return siguiente;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visit book</title>
</head>
<body>
<f:view>

	<h:form>
		<h2>Libro de Visitas<br></h2>
		Nombres: <h:inputText id="nombres" value="#{visitaBean.nombres}"></h:inputText><br>
		Correo: <h:inputText id="correo" value="#{visitaBean.correo}"></h:inputText><br>
		Comentarios: <h:inputTextarea id="comentarios" value="#{visitaBean.comentarios}"></h:inputTextarea><br>
		<h:commandButton value="Registrar" action="#{visitaBean.insertarVisita}"></h:commandButton><br>
		
		<font color="red"><h:outputText value="#{MSG}"></h:outputText></font>
		<br>
		
		<h:commandLink action="#{visitaBean.cargarLogin}">
			<h:outputText value="Ingresar como Admin"></h:outputText>
		</h:commandLink>

	</h:form>
</f:view>
</body>
</html>
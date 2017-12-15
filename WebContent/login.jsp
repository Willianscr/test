<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to system</title>
</head>
<body>
<f:view>

		<h:form>
			Usuario: <h:inputText id="usu" value="#{loginBean.usuario}"></h:inputText><br>
			Clave: <h:inputSecret id="cla" value="#{loginBean.clave}"></h:inputSecret><br>
			<h:commandButton value="Validar" action="#{loginBean.logear}"></h:commandButton>
		</h:form>
		<font color="red"><h:outputText value="#{MSG}"></h:outputText></font>
	</f:view>
</body>
</html>
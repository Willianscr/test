<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page calculator</title>
</head>
<body>
<f:view>

		<h:form>
			Calculadora<br>
			Operador A: <h:inputText id="opeA" value="#{sumaBean.operadorA}" required="true" requiredMessage="Ingrese operador A"></h:inputText>
			<h:message for="opeA" style="color: red"></h:message> <br>
			Operador B: <h:inputText id="opeB" value="#{sumaBean.operadorB}" required="true" requiredMessage="Ingrese operador B"></h:inputText>
			<h:message for="opeB" style="color: blue"></h:message> <br>
			<h:commandButton value="Sumar" action="#{sumaBean.sumar}"></h:commandButton>
		</h:form>
	</f:view>
</body>
</html>
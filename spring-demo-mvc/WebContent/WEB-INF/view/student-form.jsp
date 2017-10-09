<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Student Registration Form</title>

</head>

<body>
	
	
	<!-- When form is submitted, Spring mvc will call: 
	student.setFirstname(...) student.setLastname(..) -->
	
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
	 
		<br></br>
	
		Last name: <form:input path="LastName" />
	
		<br></br>
		
		Country:
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}"/>
		
		</form:select>
		
		<br></br>
		
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		Python <form:radiobutton path="favoriteLanguage" value="Python"/>
		Javascript <form:radiobutton path="favoriteLanguage" value="Javascript"/>
		
		<br></br>
		
		Operating Systems:
		
		Windows <form:checkbox path="OperatingSystems" value="Windows"/>
		Linux <form:checkbox path="OperatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="OperatingSystems" value="Mac"/>
		
		<br></br>
		
		
		
		<input type = "submit" value="Submit" />
	
	</form:form>
	
</body>

</html>
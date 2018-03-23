<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
	
	<title> Customer Registration</title>
	
	<!-- css template to display error message in red -->
	<style>
		.error{color:red}	
	</style>

</head>


<body>
	
	<b> Fill out the form. Asterisk (*) means required </b>
	
	<br> <br>
	
	<!-- here model attribute is the customer class which we created in previous video -->
	<!-- we use modelAttribute here because we want to use fields created in customer.java -->	
	<!-- make sure the names firstname and lastname are matching the names in customer.java class -->
	<form:form action = "processForm" modelAttribute = "customer" >
	
		First name: <form:input path = "firstname" />
		
		<br><br>
		
		Last name: <form:input path ="lastname"	/>
		
		<!-- this is to show error when last name is left empty
		cssClass points to css error class -->
		<form:errors path = "lastname" cssClass="error" /> 
		
		<br><br>
		
		free passes: <form:input path = "freePasses"/>
		<form:errors path = "freePasses" cssClass="error" /> 
		
		<br><br>
		
		postal code: <form:input path = "postalcode"/>
		<form:errors path = "postalcode" cssClass="error" /> 
		
		<br><br>
		
		
		<input type = "submit" value = "submit" />
	
	</form:form>
	
</body>


</html>







































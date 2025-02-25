<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	
	
	<title>Save Customer</title>
	
		  
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<h3>Save Customer</h3>
		
		<!-- bind the data to theModel.addAttribute("customer", theCustomer) in customerController.java -->
		<form:form action = "saveCustomer" modelAttribute="customer" method="POST">
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
			
			<div style="clear"; both;"></div>
			
			<p>
				<a href="${pageContext.request.contextPath}/customer/List"> Back to List </a>			
			</p>
			
		</form:form>
	</div>
</body>

</html>
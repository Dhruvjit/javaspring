<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title> List Customers </title>
</head>

<body>
	<div id="wrapper">
		<div id = "header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id = "container">
		<div id = "content">
		 
		 <!-- put new button: Add customer -->
		 
		 <!-- call our spring controller mapping on pressing this button -->
		 <input type="button" value="Add Customer"
		 	onclick = "window.location.href='showFormForAdd'; return false;"
		 	class="add-button"
		 />
		 
		 <p>
		 
		 <!-- add our html table here -->
		 
		 <table>
		 	<tr>
		 		<th>First Name</th>
		 		<th>Last Name</th>
		 		<th>Email</th>
		 	</tr>
		 	
		 	<!-- loop over and print our customers -->
		 	<!-- remember, customers is the attribute name 
		 	from Spring mvc model. in our case it is located
		 	in CustomerController.java -->
		 	<c:forEach var="tempCustomer" items ="${customers}">
		 		
		 		<tr>
		 			<!--  -->
		 			<td> ${tempCustomer.firstName} </td>
		 			<td> ${tempCustomer.lastName} </td>
		 			<td> ${tempCustomer.email} </td>
		 		</tr>
		 	
		 	</c:forEach>
		 	
		 </table>
		 
		</div>
	</div>
	
</body>

</html>
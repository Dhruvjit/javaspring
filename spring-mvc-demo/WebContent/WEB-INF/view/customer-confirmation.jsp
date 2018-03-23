<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
	<title>
			customer confirmation
	</title>
	
	<body>
			the customer is confirmed: ${customer.firstname} ${customer.lastname} ${customer.freePasses}		
			
			<!-- here we use customer in small caps because thats how we store it
			in model in customercontroller.java -->
			postal code: ${customer.postalcode}
	</body>

</head>
</html>
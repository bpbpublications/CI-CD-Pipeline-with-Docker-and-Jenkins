<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Sample Webapp</title>
	</head>
	<body>
	
		<p>
			Please select an image file to upload(Max Size 1 MB)
		</p>
		<form:form method="POST" enctype="multipart/form-data" action="FileUploadServlet">
	   		<table>
			    <tr>
			        <td><input type = "file" accept = "image/jpg" name = "name">
			        </td>
			        </tr><tr>
			        <td><input type= "submit" value = "Submit" align = "left" name="submit"></td>
			    </tr>
			   
			</table> 
		</form:form>
		
 
	</body>
</html>
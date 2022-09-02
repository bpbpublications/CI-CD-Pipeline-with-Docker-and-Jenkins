<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Images</title>
</head>
<body>
<h1>List of images</h1>
<h3><a href="fileUpload.html">Add More Images</a></h3>

 
<c:if test="${!empty images}">
	<table align="left" border="1">
		<tr>
			<th>Image Name</th>
			<th>Actions</th>
			
		</tr>

		<c:forEach items="${images}" var="img" >
			<tr>
				<td><c:out value="${img.imageName}"/></td>
				
				
				<td align="center"><a href="DownloadServlet?name=${img.imageName}">Download</a> </td>
			</tr>
		</c:forEach>
	</table>
</c:if> 
</body>
</html>
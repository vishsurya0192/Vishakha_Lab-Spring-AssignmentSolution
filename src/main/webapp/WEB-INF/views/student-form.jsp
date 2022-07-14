<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
<title>student form</title>
</head>

<body>
	<div class="container">
		<hr>

		<p class="h4 mb-4">Student</p>

		<form action="/StudentManagement/student/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${student.id}" />

			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					class="form-control mb-4 col-4" placeholder="firstName">



			</div>
			
			<div class="form-inline">

				<input type="text" name="lastName" value="${student.lastName}"
					class="form-control mb-4 col-4" placeholder="lastName">



			</div>
			
			<div class="form-inline">

				<input type="text" name="course" value="${student.course}"
					class="form-control mb-4 col-4" placeholder="course">



			</div>
			
			<div class="form-inline">

				<input type="text" name="country" value="${student.country}"
					class="form-control mb-4 col-4" placeholder="country">



			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
	</form>
	<hr>
		<a href="/StudentManagement/student/list">Back to Students List</a>
</div>
</body>
</html>
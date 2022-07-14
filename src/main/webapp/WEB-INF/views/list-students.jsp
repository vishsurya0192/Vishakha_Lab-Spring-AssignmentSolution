<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Students Directory</title>
</head>

<body>
	<div class="container">
		<hr>

		<!-- Add a search form -->

		<form action="/StudentManagement/student/save" class="form-inline">

			<!-- Add a button -->
			<a href="/StudentManagement/student/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a> 
			<a href="/StudentManagement/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto"> Logout </a> 
		</form>
		
		<table>
			<thead>
				<tr>
					<th>firstName</th>
					<th>lastName</th>
					<th>course</th>
					<th>country</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${students}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>
						<td><c:out value="${tempStudent.course}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/StudentManagement/student/showFormForUpdate?studentId=${tempStudent.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/StudentManagement/student/delete?studentId=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
			</table>
			</div>

</body>
</html>
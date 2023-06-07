<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO</title>
</head>
<body>
	<h1>Liste TODO</h1>
	<form action="todo" method="post">
		<input type="hidden" value="ajouter" name="action"> 
		<input type="text" size='100' name="tache"> 
		<input type="submit" value="Ajouter">
	</form>
	<br>
	<br> 
	
<c:forEach items="${listeTodo}" var="todo" varStatus="status">
    <form action="todo" method="post">
        <input size="30" type="text" value="${todo}" disabled>
        <input type="hidden" value="supprimer" name="action">
        <input type="hidden" value="${status.index}" name="indice">
        <input type="submit" value="Supprimer">
    </form>
      <form action="todo" method="post">
      	 		<input size='100' type='text' value="${status.index}" name='tache'>
        <input type="hidden" value="modifier" name="action">
        <input type="hidden" value="${status.index}" name="indice">
        <input type="submit" value="modifier">
    </form>
    
</c:forEach>

	
</body>
</html>
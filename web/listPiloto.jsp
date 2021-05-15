<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Mostrar todos os pilotos</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Piloto ID</th>
                <th>Matricula</th>
                <th>Nome</th>
                <th>Pais</th>
                <th>Equipe</th>
                <th>Fabricante Motor</th>
                <th>Pontos Temporada</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pilotos}" var="piloto">
                <tr>
                    <td><c:out value="${piloto.pilotoId}" /></td>
                    <td><c:out value="${piloto.matricula}" /></td>
                    <td><c:out value="${piloto.nome}" /></td>
                    <td><c:out value="${piloto.pais}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${piloto.dataNasc}" /></td>
                    <td><c:out value="${piloto.equipe}" /></td>
                    <td><c:out value="${piloto.fabricMotor}" /></td>
                    <td><c:out value="${piloto.pontosTemp}" /></td>
                    
                    <td><a href="PilotoController?action=edit&pilotoid=<c:out value="${piloto.pilotoId}"/>">Update</a></td>
                    <td><a href="PilotoController?action=delete&pilotoid=<c:out value="${piloto.pilotoId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PilotoController?action=insert">Add Piloto</a></p>
</body>
</html>
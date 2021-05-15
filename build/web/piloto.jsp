<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Adicionar novo piloto</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=datanasc]').datepicker();
        });
    </script>

    <form method="POST" action='PilotoController' name="frmAddPiloto">
        Piloto ID : <input type="text" readonly="readonly" name="pilotoid"
            value="<c:out value="${piloto.pilotoId}" />" /> <br /> 
        
        Matricula : <input 
            type="text" name="matricula"
            value="<c:out value="${piloto.matricula}" />" /> <br /> 
        
        Nome : <input
            type="text" name="nome"
            value="<c:out value="${piloto.nome}" />" /> <br /> 
        
        Pais : <input
            type="text" name="pais"
            value="<c:out value="${piloto.pais}" />" /> <br /> 
        
        Data de Nascimento :  <input
            type="text" name="datanasc"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${piloto.dataNasc}" />" /> <br /> 
        
        Equipe : <input
            type="text" name="equipe"
            value="<c:out value="${piloto.equipe}" />" /> <br /> 
        
        Fabricante Motor : <input
            type="text" name="fabricmotor"
            value="<c:out value="${piloto.fabricMotor}" />" /> <br /> 
        
        Pontos Temporada : <input
            type="text" name="pontostemp"
            value="<c:out value="${piloto.pontosTemp}" />" /> <br /> <input
            type="submit" value="Submit" />
        
    </form>
</body>
</html>

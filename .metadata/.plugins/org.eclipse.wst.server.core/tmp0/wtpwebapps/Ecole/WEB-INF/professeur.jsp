<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sekoliko</title>
    <!-- Bootstrap core CSS -->
	<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
	  <link href="./assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	  <link href="./assets/css/datatables.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg  navbar-dark  bg-primary  shadow container-fluid">

            <a class="navbar-brand lnav h1" href="#" data-scroll="acceuill"><i class="fas fa-home "></i> SEKOLIKO</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNav">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link lnav" href="eleve" data-scroll="professeur"> MPIANATRA <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link lnav" href="professeur" data-scroll="produit"> MPAMPIANATRA</a>
                </li>
                <li class="nav-item">
                        <a class="nav-link lnav" href="classe" data-scroll="inscription"> KILASY</a>
                    </li>
                <li class="nav-item">
                    <a class="nav-link lnav" href="matiere" data-scroll="contact"> TARANJA</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <div class="container mt-5">
    	<div class="card">
    		<div class="card-body">
    		 <div class="container text-right">
    		 	<a href="<%= request.getContextPath()%>/nouveau_prof" class="btn btn-primary"  ><i class ="fas fa-plus"></i> Hanampy mpampianatra</a>
    		 </div>
    		 <h4 class="text-primary mb-5 font-weight-bold">Lisitry ny mpampianatra </h4>	
    			<table class="table mt-3 " id="table_prof">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Anarana</th>
                            <th>Fanampiny</th>
                            <th>Mampianatra</th>
                            <th>Kilasy</th>
                             <th>Atao</th>
                   
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach var="professeur" items="${listProfesseur }">
                            <tr>
                           		 <td><c:out value="${professeur.prof_id }"/></td>
                                <td><c:out value="${professeur.prof_nom }"/></td>
                                <td><c:out value="${professeur.prof_prenom }"/></td>
                                 <td><c:out value="${professeur.mat_nom }"/></td>
                                 <td><c:out value="${professeur.cls_nom }"/></td>
                                 
                                <td> 
                                <a class="btn btn-sm btn-success" href="editer_prof?prof_id=<c:out value="${professeur.prof_id }"/>" ><i class="fas fa-edit"></i></a>
                                <a class="btn btn-sm btn-danger" href="supprimer_prof?prof_id=<c:out value="${professeur.prof_id }"/>" ><i class="fas fa-trash"></i></a>
                                </td>
                            </tr>
                   		</c:forEach>
                    </tbody>
                </table>
    		</div>
    	</div>
    </div>
    <script src="./assets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./assets/js/datatables.min.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
		$('#table_prof').DataTable({
		"language": {
		"url": "./assets/json/French.json"
		}
		});
	});
	</script>
</body>
</html>
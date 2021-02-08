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
                    <a class="nav-link lnav" href="eleve" data-scroll="eleve"> MPIANATRA <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link lnav" href="professeur" data-scroll="produit"> MPAMPIANATRA</a>
                </li>
                <li class="nav-item">
                        <a class="nav-link lnav" href="classe" data-scroll="inscription"> KILASY</a>
                    </li>
                <li class="nav-item">
                    <a class="nav-link lnav" href="eleve" data-scroll="contact"> TARANJA</a>
                </li>
            </ul>
        </div>
    </nav>
    
    <div class="container mt-5">
    	<div class="card mt-3 shadow ">
    		<div class="card-body">
    				<form action="modifier_eleve" method="post">

 
    				<input type="hidden" name="elv_id" value="<c:out value="${eleve.elv_id}"/>">

    			<div class="form-group">
    				<label for="">Anarana</label>
    				<input type="text" class="form-control" name="elv_nom" required value="<c:out value="${eleve.elv_nom}"/>" />
    				<label for="">Fanampiny</label>
    				<input type="text" class="form-control" name="elv_prenom" required value="<c:out value="${eleve.elv_prenom}"/>" />
    				<label for="">Kilasy</label>
    				<input type="text" class="form-control" name="elv_cls_k" required value="<c:out value="${eleve.elv_cls_k}"/>" />
    			</div>
    			<button type="submit" class="btn btn-success">Hanova</button>
    			</form>
    		</div>
    	</div>
    </div>
    
</body>
</html>
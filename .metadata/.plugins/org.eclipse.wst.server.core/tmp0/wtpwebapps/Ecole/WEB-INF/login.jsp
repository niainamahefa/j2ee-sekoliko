<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Sekoly</title>

    <!-- Bootstrap core CSS -->
	<link href="./assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="./assets/css/signin.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
	    <form class="form-signin" method="post">
		  <h1 class="h3 mb-3 font-weight-bold">SEKOLIKO</h1>
		  <div class="badge badge-success mt-3 mb-3"><h4 class="h6  text-center">Anarana : "admin" | Tenimiafina : "sekoliko"</h1></div>
		  <label for="inputEmail" class="sr-only">Anarana</label>
		  <input type="text" id="inputEmail" class="form-control" placeholder="Fenoy ny anarana"  name="anarana" required autofocus>
		  <label for="inputPassword" class="sr-only">Tenimiafina</label>
		  <input type="password" id="inputPassword" class="form-control mt-3" placeholder="Fenoy ny tenimiafina" name="tenimiafina" required>
		  <div class="checkbox mb-3">
		  </div>
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Hiditra</button>
		</form>
	</body>
</html>

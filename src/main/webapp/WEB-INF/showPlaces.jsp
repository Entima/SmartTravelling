<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Place List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="index.html">SmartTravelling</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">

                    </ul>

                    <form class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="button" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Your trip</h1>
                <p class="lead text-muted mb-0">Favourite places</p>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col">
                    <nav aria-label="breadcrumb">

                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col font-weight-bold">name</div>
                <div class="col font-weight-bold">location</div>
        </div>
            <div class="row">
                <div class="col">${place.name}</div>
                <div class="col">
                <div id="map-container-google-3" class="z-depth-1-half map-container" style="height: 200px">
                    <iframe src="https://maps.google.com/maps?q=${place.location}&t=&z=6&ie=UTF8&iwloc=&output=embed" frameborder="0" style="border:0"></iframe>
                </div>
                </div>
            </div>
            <div class="row">
                <div class="col font-weight-bold">description</div>
                <div class="col font-weight-bold">photo</div>
            </div>
            <div class="row">
                <div class="col">${place.description}</div>
                <div class="col"><img src="${place.photo}" class="img-fluid"/></div>
            </div>
        </div>

        <!-- Footer -->
        <footer class="mt-5">

        </footer>



</body>
</html>



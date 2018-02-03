<#ftl encoding="utf-8">
<!DOCTYPE HTML>
<html>

<head>
    <title>Dagenslunch server admin</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="/public/assets/css/bootstrap.css">
    <link rel="stylesheet" href="/public/assets/css/core.css">
    <link rel="stylesheet" href="/public/assets/css/components.css">
    <link rel="stylesheet" href="/public/assets/icons/fontawesome/styles.min.css">
    <link rel="stylesheet" href="/public/lib/css/chartist.min.css">

    <script type="text/javascript" src="/public/lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="/public/lib/js/tether.min.js"></script>
    <script type="text/javascript" src="/public/lib/js/bootstrap.min.js"></script>

    <script type="text/javascript" src="/public/lib/js/chartist.min.js"></script>
    <script type="text/javascript" src="/public/assets/js/app.min.js"></script>

</head>

<body>
    <!-- NAVBAR -->
    <nav class="navbar navbar-toggleable-md">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav">
            <span>
                <i class="fa fa-code-fork"></i>
            </span>
        </button>

        <button class="navbar-toggler navbar-toggler-left" type="button" id="toggle-sidebar">
            <span>
               <i class="fa fa-align-justify"></i>
            </span>
        </button>

        <a class="navbar-brand logo" href="/public/index.html">
            <img src="assets/img/dagenslunch-logo.png" alt="Dagenslunch Server">
        </a>

    </nav>
    <!-- /NAVBAR -->

    <div class="page-container">
        <div class="page-content">
            <!-- inject:SIDEBAR -->

            <div id="sidebar-main" class="sidebar sidebar-default">
                <div class="sidebar-content">
                    <ul class="navigation">

                        <li>
                            <a href="/"><i class="fa fa-home"></i> <span>Dashboard</span></a>
                        </li>

                        <li>
                            <a href="restaurant.html"><i class="fa fa-th"></i> <span>Rstaurants</span></a>
                            <ul>
                                <li><a href="/people/9"><i class="fa fa-file-o"></i>   List All</a></li>
                                <li><a href="add_restaurant.html">Add New</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="user.html"><i class="fa fa-table"></i> <span>Users</span></a>
                            <ul>
                                <li><a href="all_user.html">List All</a></li>
                                <li><a href="add_user.html">Add New</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="login.html"><i class="fa fa-file-o"></i> <span>Login</span></a>
                            <ul>
                                <li><a href="login.html">Login</a></li>
                                <li><a href="register.html">Register</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

            <!-- inject:/SIDEBAR -->

            <!-- PAGE CONTENT -->
            <div class="content-wrapper">
                <div class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="page-title">${name} <small>Resstfull api service</small></h3>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-block">
                                    <h5 class="card-title"><span class="badge badge-pill badge-flat badge-info">List of restaurants</span></h5>
                                    <table class="table table-stripped table-hover table-bordered">
                                        <thead class="table-primary">
                                            <tr>
                                                <td>ID</td>
                                                <td>NAME</td>
                                                <td>CATEGORY</td>
                                                <td>Latitude</td>
                                                <td>Longitude</td>
                                                <td>Opening Hours</td>
                                                <td>Email</td>
                                                <td>Telephone</td>
                                                <td>Rating</td>
                                            </tr>
                                        </thead>

                                        <tbody>
                                        
  											
  											<#list restaurants>
  											<#items as restaurant>
  											<tr>
   												<td>${restaurant.id}</td>
   												<td>${restaurant.name}</td>
   												<td>${restaurant.category}</td>
   												<td>${restaurant.latitude}</td>
   												<td>${restaurant.longitude}</td>
   												<td>${restaurant.openingHours}</td>
   												<td>${restaurant.email}</td>
   												<td>${restaurant.telephone}</td>
   												<td>${restaurant.rating}</td>
   											</tr>
   											</#items>
   											</#list>
  											
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--footer-->
                    <div class="row">
                        <div class="col-md-12">
                            <p class="text-xs-center">&copy; Copyright 2018 - Couldcentrik. All rights reserved.</p>
                        </div>
                    </div>
                    <!-- /footer-->

                </div>
            </div>

            <!-- /PAGE CONTENT -->


        </div>
    </div>
</body>

</html>
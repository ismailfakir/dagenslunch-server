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
            <img src="/public/assets/img/dagenslunch-logo.png" alt="Dagenslunch Server">
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
                                    <h5 class="card-title"><span class="badge badge-pill badge-flat badge-info">${user}</span></h5>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card text-center">
                                <div class="card-block">
                                    <h6 class="text-bold content-group-sm">Restaurants</h6>
                                    <div class="dropdown-menu dropdown-demo" aria-labelledby="dropdownMenuButton">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>
                                        <a class="dropdown-item" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fa fa-bank position-left"></i>Action</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-cloud position-left"></i>Another action</a>
                                        <a class="dropdown-item" href="#"><i class="fa fa-edit position-left"></i>Something else here</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#"><i class="fa fa-envelope position-left"></i>Seperated Link</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                         <div class="col-lg-4">
                            <div class="card text-center">
                                <div class="card-block">
                                    <h6 class="text-bold content-group-sm">User</h6>
                                    <div class="dropdown-menu dropdown-demo" aria-labelledby="dropdownMenuButton">
                                        <h6 class="dropdown-header">Dropdown header</h6>
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Seperated Link</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <div class="card text-center">
                                <div class="card-block">
                                    <h6 class="text-bold content-group-sm">Token</h6>
                                    <div class="dropdown-menu dropdown-demo" aria-labelledby="dropdownMenuButton">
                                        <a class="dropdown-item" href="#">Action</a>
                                        <a class="dropdown-item disabled" href="#">Another Action</a>
                                        <a class="dropdown-item" href="#">Something else here</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Seperated Link</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="form-control-label">Recipient:</label>
            <input type="text" class="form-control" id="recipient-name">
          </div>
          <div class="form-group">
            <label for="message-text" class="form-control-label">Message:</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Send message</button>
      </div>
    </div>
  </div>
</div>
                    <!-- /modal -->
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
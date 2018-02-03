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
    <div class="page-container">
        <!-- PAGE CONTENT -->
        <div class="card-block text-center">
        <div class="jumbotron jumbotron-fluid">
  			<div class="container">
    			<h1 class="display-3">${name}</h1>
    			<p class="lead">A restfull api service</p>
    			<h3><span class="badge badge-flat badge-info">Admininstration Panel</span></h3>
  			</div>
		</div>
		</div>
        <div class="content h-100">
            <div class="row h-100">
                <div class="col-lg-12">
                    <div class="login card auth-box mx-auto my-auto">
                        <div class="card-block text-center">
                            <div class="user-icon">
                                <i class="fa fa-user-circle"></i>
                            </div>

                            <h4 class="text-light">Login</h4>
							<form action="/" method="post">
                            <div class="user-details">
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1">
                                                <i class="fa fa-user-o"></i>
                                            </span>
                                        <input type="text" name="userName" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon1">
                                                <i class="fa fa-key"></i>
                                            </span>
                                        <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary btn-lg btn-block">LOGIN</button>

                            <div class="user-links">
                                <a href="#" class="pull-left">Forgot Password?</a>
                                <a href="#" class="pull-right">Register</a>
                            </div>

                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /PAGE CONTENT -->
    </div>
</body>

</html>
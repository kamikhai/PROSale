<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link rel="stylesheet" href="../assets/style.css">

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6" style="margin-top: 110px">
            <form class="form-horizontal" method="post">
                <span class="heading">РЕГИСТРАЦИЯ</span>
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="Name">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="surname" placeholder="Surname">
                    <i class="fa fa-male"></i>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="E-mail">
                    <i class="fa fa-envelope"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">ЗАРЕГИСТИРОВАТЬСЯ</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
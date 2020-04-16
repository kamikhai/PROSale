<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://vk.com/doc99916294_544558697?hash=c23b98998fd962260c&dl=826844dc49a2e1a0fd">

</head>
<body>
<#include "parts/header.ftl">
<!-- ##### Breadcumb Area Start ##### -->
<div class="breadcumb_area bg-img"
     style="background-image: url(https://sun9-21.userapi.com/c205620/v205620545/cb8bc/Fn_crZrrCh0.jpg);">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="page-title text-center">
                    <h2>Регистрация</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Breadcumb Area End ##### -->

<!-- ##### Checkout Area Start ##### -->
<div class="checkout_area section-padding-80">
    <div class="container">
        <div class="row">


            <div class="col-md-6 offset-md-3">
                <form class="form-horizontal" method="post" action="/registration">

                    <div class="order-details-confirmation" style="text-align: center;">
                        <div class="col-md-12 mb-4">
                            <label for="first_name">Имя <span>*</span></label>
                            <input type="text" class="form-control" id="first_name" value="" required name="name">
                        </div>
                        <div class="col-md-12 mb-4">
                            <label for="last_name">Фамилия <span>*</span></label>
                            <input type="text" class="form-control" id="last_name" value="" required name="surname">
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <div class="col-12 mb-4">
                            <label for="email_address">Email адрес <span>*</span></label>
                            <input type="email" class="form-control" id="email_address" value="" name="email"
                                   required="">
                        </div>
                        <div class="col-12 mb-4">
                            <label for="password">Пароль <span>*</span></label>
                            <input type="password" class="form-control" id="password" value="" name="password"
                                   required="">
                        </div>

                        <button type="submit" class="btn essence-btn" >Регистрация
                        </button>
                        </br></br>
                        <a href="/login">Уже есть аккаунт? Войдите!</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- ##### Checkout Area End ##### -->

</body>
</html>
<!doctype html>
<#import "spring.ftl" as spring />
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
<div class="breadcumb_area bg-img"
     style="background-image: url(https://sun9-21.userapi.com/c205620/v205620545/cb8bc/Fn_crZrrCh0.jpg);">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="page-title text-center">
                    <h2><@spring.message "profile.page.profile"/></h2>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Breadcumb Area End ##### -->

<div class="checkout_area section-padding-80">
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form method="post" class="form-horizontal" id="myform">
                    <div class="order-details-confirmation" style="text-align: center;">
                        <b style="font-size: medium">${(user.surname)!'Фамилия'}</b></br>
                        <b style="font-size: medium">${(user.name)!'Имя'}</b>
                        <p>${(user.email)!'Почта'}</p>
                        <a class="btn essence-btn" href="/logout"
                           onclick="document.getElementById('logout').submit();"><@spring.message "profile.page.logout"/></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div style="text-align: center; margin-top: 50px">

</div>
</body>
</html>
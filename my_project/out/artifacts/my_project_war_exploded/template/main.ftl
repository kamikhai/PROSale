<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Главная</title>
</head>
<style>
    a {
        text-decoration: none;
        outline: none;
        display: inline-block;
        width: 200px;
        height: 45px;
        line-height: 45px;
        border-radius: 45px;
        margin-top: 330px;
        font-family: 'Montserrat', sans-serif;
        font-size: 14px;
        text-transform: capitalize;
        text-align: center;
        letter-spacing: 1px;
        font-weight: 600;
        color: #ffffff;
        background: #00b4ef;
        transition: .3s;
    }

    .center {
        text-align: center;
    }
</style>
<body>
<div class="center">
    <#if auth!false>
        <h1>Главная страница</h1>
    <#else>
        <a href="/signIn">Войти</a>
    </#if>

</div>
</body>
</html>
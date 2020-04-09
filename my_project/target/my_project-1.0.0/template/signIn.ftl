<#import "parts/header.ftl" as h>
<@h.header title="Вход">
    <!-- ##### Breadcumb Area Start ##### -->
    <div class="breadcumb_area bg-img"
         style="background-image: url(https://sun9-21.userapi.com/c205620/v205620545/cb8bc/Fn_crZrrCh0.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="page-title text-center">
                        <h2>Вход</h2>
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
                    <form class="form-horizontal" id="myform">
                        <div class="order-details-confirmation" style="text-align: center;">

                            <div class="col-12 mb-4">
                                <label for="email_address">Email адрес <span>*</span></label>
                                <input type="email" class="form-control" id="email_address" value="" name="email">
                            </div>
                            <div class="col-12 mb-4">
                                <label for="password">Пароль <span>*</span></label>
                                <input type="password" class="form-control" id="password" value="" name="password">
                            </div>

                            <button type="button" class="btn essence-btn" onclick="signIn()">Войти</button> </br></br>
                            <a href="/signUp">Еще не с нами? Зарегистрийруйтесь!</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Checkout Area End ##### -->
<script>
    function signIn() {
        var email = document.getElementById("email_address").value;
        var password = document.getElementById("password").value;

        const toSend = {
            email: email,
            password: password
        }
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "/signIn");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(toSend));
    }
</script>
</@h.header>
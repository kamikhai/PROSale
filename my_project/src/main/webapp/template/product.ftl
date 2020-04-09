<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://vk.com/doc99916294_544558697?hash=c23b98998fd962260c&dl=826844dc49a2e1a0fd">
    <#--    <script type='text/javascript'>-->
    <#--        function submitForm(){-->
    <#--            document.getElementById('myform').submit();-->
    <#--        }-->
    <#--    </script>-->
    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script>
        var count = 1;

        function sort() {
            var e = document.getElementById("sortByselect");
            var sort = e.options[e.selectedIndex].value;
            var param = window.location.search;
            if (sort != 1) {
                if (param == "") {
                    // window.location.search = "?sort=" + sort;
                    targetURL = "/api/products-management/products/${who}" + "?sort=" + sort;
                } else {
                    // window.location.search = param.split('&')[0] + "&sort=" + sort;
                    targetURL = "/api/products-management/products/${who}/" + param.split('&')[0].split('=')[1] + "?sort=" + sort;
                }
            } else {
                if (param == "") {
                    // window.location.search = "?sort=" + sort;
                    targetURL = "/api/products-management/products/${who}";
                } else {
                    // window.location.search = param.split('&')[0] + "&sort=" + sort;
                    targetURL = "/api/products-management/products/${who}/" + param.split('&')[0].split('=')[1];
                }
            }
                // alert(targetURL);
                $.ajax({
                    url: targetURL,
                    method: "GET",
                    dataType: "json",
                    contentType: "application/json",
                    success: function (response) {
                        createView(response)
                    }
                })

        }


        function reload() {
            isFirstLoad = true;
            receiveProducts()
        }
        var isFirstLoad = true;

        function receiveProducts() {
            // alert(count);
            if (isFirstLoad) {
                $.ajax({
                    url: "/api/products-management/products/${who}",
                    method: "GET",
                    dataType: "json",
                    contentType: "application/json",
                    success: function (response) {
                        createView(response)
                    }
                });
                isFirstLoad = false;
            }
            // count++;
        }

        function chooseStore(store) {
            $.ajax({
                url: "/api/products-management/products/${who}/" + store,
                method: "GET",
                dataType: "json",
                contentType: "application/json",
                success: function (response) {
                    createView(response)
                },
                error: function () {
                    alert('error!');
                }
            })
        }

        function createView(response) {
            document.getElementById('products').innerHTML = "";
            document.getElementById('size').innerHTML = "";
            $('#size').first().append(response['data'].length);
            $.each(response['data'], function () {
                $('#products').first().append('                            <div class="col-12 col-sm-6 col-lg-4">\n' +
                    '                                <div class="single-product-wrapper">\n' +
                    '                                    <div class="product-img">\n' +
                    '                                        <img src=' + this.imgUrl + ' alt="">\n' +
                    '                                        <div class="product-favourite">\n' +
                    '                                            <a href="#"><img\n' +
                    '                                                        src="https://sun9-15.userapi.com/c857136/v857136859/13b39f/1ipItgUShrw.jpg"\n' +
                    '                                                        alt="" style="height: 60%; width: auto;"></a>\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                    <div class="product-description">\n' +
                    '                                        <span>' + this.site.store_name + '</span>\n' +
                    '                                        <a href=' + this.productUrl + '>\n' +
                    '                                            <h6>' + this.productName + '</h6>\n' +
                    '                                        </a>\n' +
                    '                                        <p class="product-price"><span\n' +
                    '                                                    class="old-price">' + this.oldPrice + '</span>' + this.newPrice + '</p>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>');
            });
        }


    </script>
</head>
<body onload="receiveProducts()">
<#include "parts/header.ftl">

<!-- ##### Breadcumb Area Start ##### -->
<div class="breadcumb_area bg-img"
     style="background-image: url(https://sun9-21.userapi.com/c205620/v205620545/cb8bc/Fn_crZrrCh0.jpg);">

</div>
<!-- ##### Shop Grid Area Start ##### -->
<section class="shop_grid_area section-padding-80">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-4 col-lg-3">
                <div class="shop_sidebar_area">
                    <!-- ##### Single Widget ##### -->
                    <div class="widget brands mb-50">
                        <!-- Widget Title 2 -->
                        <p class="widget-title2 mb-30">Бренды</p>
                        <div class="widget-desc">
                            <ul>
                                <li><a onclick="reload()">Все бренды</a></li>
                                <#list sites as s>
                                    <li><a onclick="chooseStore(${s.id})">${s.store_name}</a></li>
                                </#list>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-8 col-lg-9">
                <div class="shop_grid_product_area">
                    <div class="row">
                        <div class="col-12">
                            <div class="product-topbar d-flex align-items-center justify-content-between">
                                <!-- Total Products -->
                                <div class="total-products">
                                    <p>Найдено <span id="size">0</span> товаров</p>
                                </div>
                                <!-- Sorting -->
                                <div class="product-sorting d-flex">
                                    <p>Отсортировать по:</p>
                                    <form method="get" id="myform" name="myform">
                                        <select name="select" id="sortByselect" onchange="sort()">
                                            <option value="1">-------------------</option>
                                            <option value="2">Цена по убыванию</option>
                                            <option value="3">Цена по возрастанию</option>
                                        </select>
                                        <input type="submit" class="d-none" value="">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row" id="products">

                        <#--                        <#list products as p>-->
                        <#--                            <div class="col-12 col-sm-6 col-lg-4">-->
                        <#--                                <div class="single-product-wrapper">-->
                        <#--                                    <div class="product-img">-->
                        <#--                                        <img src=${p.imgUrl!empty} alt="">-->
                        <#--                                        <div class="product-favourite">-->
                        <#--                                            <a href="#"><img-->
                        <#--                                                        src="https://sun9-15.userapi.com/c857136/v857136859/13b39f/1ipItgUShrw.jpg"-->
                        <#--                                                        alt="" style="height: 60%; width: auto;"></a>-->
                        <#--                                        </div>-->
                        <#--                                    </div>-->
                        <#--                                    <div class="product-description">-->
                        <#--                                        <span>${p.site.store_name}</span>-->
                        <#--                                        <a href=${p.productUrl}>-->
                        <#--                                            <h6>${p.productName}</h6>-->
                        <#--                                        </a>-->
                        <#--                                        <p class="product-price"><span-->
                        <#--                                                    class="old-price">${p.oldPrice}</span> ${p.newPrice}</p>-->
                        <#--                                    </div>-->
                        <#--                                </div>-->
                        <#--                            </div>-->
                        <#--                        </#list>-->


                    </div>
                </div>
                <!-- Pagination -->
                <nav aria-label="navigation">
                    <ul class="pagination mt-50 mb-70">
                        <li class="page-item"><a class="page-link" href="#"><img
                                        src="https://sun9-4.userapi.com/c857136/v857136859/13b391/k8YcdUW7f8A.jpg"
                                        alt="" style="height: 60%; width: auto"></a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                        <li class="page-item"><a class="page-link" href="#">20</a></li>
                        <li class="page-item"><a class="page-link" href="#"><img
                                        src="https://sun9-53.userapi.com/c857136/v857136859/13b3ad/TKDFbeAhpj0.jpg"
                                        alt="" style="height: 60%; width: auto;"></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>


</body>
</html>
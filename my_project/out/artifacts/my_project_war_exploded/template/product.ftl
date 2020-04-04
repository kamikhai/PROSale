<#import "parts/header.ftl" as h>
<@h.header title="Товары">
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
                                <li><a href="${url}">Все бренды</a></li>
                                <#list sites as s>
                                <li><a href="?store=${s.id}">${s.store_name}</a></li>
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
                                    <p>Найдено <span>${size}</span> товаров</p>
                                </div>
                                <!-- Sorting -->
                                <div class="product-sorting d-flex">
                                    <p>Отсортировать по:</p>
                                    <form method="get" id="myform" name="myform">
                                        <select name="select" id="sortByselect" onchange="submitForm()">
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

                    <div class="row">

                        <#list products as p>
                            <div class="col-12 col-sm-6 col-lg-4">
                                <div class="single-product-wrapper">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src=${p.imgUrl!empty} alt="">
                                        <!-- Favourite -->
                                        <div class="product-favourite">
                                            <a href="#"><img
                                                        src="https://sun9-15.userapi.com/c857136/v857136859/13b39f/1ipItgUShrw.jpg"
                                                        alt="" style="height: 60%; width: auto;"></a>
                                        </div>
                                    </div>

                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <span>${p.site.store_name}</span>
                                        <a href=${p.productUrl}>
                                            <h6>${p.productName}</h6>
                                        </a>
                                        <p class="product-price"><span
                                                    class="old-price">${p.oldPrice}</span> ${p.newPrice}</p>
                                    </div>
                                </div>
                            </div>
                        </#list>


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
                        <li class="page-item"><a class="page-link" href="#">${size/30}</a></li>
                        <li class="page-item"><a class="page-link" href="#"><img
                                        src="https://sun9-53.userapi.com/c857136/v857136859/13b3ad/TKDFbeAhpj0.jpg"
                                        alt="" style="height: 60%; width: auto;"></a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</section>
</@h.header>

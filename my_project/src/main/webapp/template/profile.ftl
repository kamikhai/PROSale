<#import "parts/header.ftl" as h>
<@h.header title="Профиль">
    <form action="/logout" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <a class="btn essence-btn" href="#" onclick="document.getElementById('logout').submit();">Logout</a>
</@h.header>
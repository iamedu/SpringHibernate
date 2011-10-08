<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:url var="authUrl" value="/j_spring_security_check" />
<form method="POST" action="${authUrl}">
    
    <legend>Submit de usuario</legend>
    <div class="clearfix">
        <label for="username">Nombre de usuario</label>
        <div class="input">
            <input type="text" name="j_username" id="username" />
        </div>
    </div>
    <div class="clearfix">
        <label for="password">Password</label>
        <div class="input">
            <input type="text" name="j_password" id="password" />
        </div>
    </div>
    <div class="actions">
        <input type="submit" class="btn primary" value="Entrar" />
    </div>
</form>
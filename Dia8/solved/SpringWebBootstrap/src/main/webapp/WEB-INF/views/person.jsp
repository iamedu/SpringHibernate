<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form method="POST" modelAttribute="personDTO">
    <div class="alert-message error">
        <sf:errors path="*" element=""  />
    </div>
    
    <legend>Submit de usuario</legend>
    <div class="clearfix">
        <label for="username">Nombre de usuario</label>
        <div class="input">
            <sf:input path="username" id="username" />
        </div>
    </div>
    <div class="actions">
        <input type="submit" class="btn primary" value="Guardar cambios" />
    </div>
</sf:form>
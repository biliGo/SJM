<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h3>添加${table.Label}</h3>
<form:form action="/users" method="POST" validate="true"
           modelAttribute="user" cssClass="basic-form form-horizontal">
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">提交</button>
        </div>
    </div>
</form:form>
<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>

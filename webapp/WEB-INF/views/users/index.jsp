<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://taglib.bjcathay.com" prefix="b" %>
<div class="row-fluid clearfix">
    <div class="pull-left">
        <h3>${table.Label}查询</h3>
    </div>
    <div class="pull-right">
        <a class="btn btn-primary" href="<c:url value="/users/new"/>">创建${table.Label}</a>
    </div>
</div>
<div class="row-fluid">
    <form:form action="/users" method="GET"
               modelAttribute="qf" cssClass="basic-form form-horizontal">
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">查询</button>
            </div>
        </div>
    </form:form>
</div>
<display:table name="users.data" id="user_" class="table table-striped table-bordered">
    <display:column title="ID">
        <a href="/users/${user_.id}">${user_.id}</a>
    </display:column>
</display:table>
<b:pagination name="users"/>

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>

<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>${table.Label}信息</h3>
<table class="table table-striped table-bordered">
    <tr>
        <td>ID</td>
        <td>${user.id}</td>
    </tr>
</table>

<a href="<c:url value="/users/${user.id}/edit"/>">编辑</a>
<a href="<c:url value="/users/${user.id}"/>" data-method="DELETE" data-remote="true"
   data-redirect="<c:url value="/users"/>">删除</a>
<a href="<c:url value="/users"/>">返回</a>
<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>

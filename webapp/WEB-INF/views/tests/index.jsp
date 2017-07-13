<jsp:include page="/WEB-INF/views/layouts/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://taglib.bjcathay.com" prefix="b"%>
<div class="row-fluid clearfix">
  <div class="pull-left">
    <h3>${table.Label}查询</h3>
  </div>
  <div class="pull-right">
    <a class="btn btn-primary" href="<c:url value="/tests/new"/>">创建${table.Label}</a>
  </div>
</div>
<div class="row-fluid">
<form:form action="/tests" method="GET"
	modelAttribute="qf" cssClass="basic-form form-horizontal">
	<div class="control-group">
		<div class="controls">
			<button type="submit" class="btn">查询</button>
		</div>
	</div>
</form:form>
</div>
<display:table name="tests.data" id="test_" class="table table-striped table-bordered">
	<display:column title="ID">
		<a href="/tests/${test_.id}">${test_.id}</a>
	</display:column>
</display:table>
<b:pagination name="tests" />

<jsp:include page="/WEB-INF/views/layouts/footer.jsp"/>

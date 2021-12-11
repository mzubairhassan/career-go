<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div class="container mt-5 pt-5">

    <form:form modelAttribute="dumb" method="POST"  action="/careergo/dumbSave">
        <form:input path="dumbName" />
        <form:input path="dumbType" />

        <button type="submit">Submit</button>

    </form:form>



</div>>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
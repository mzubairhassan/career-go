<%-- 
    Document   : viewJobs
    Created on : Sep 21, 2020, 1:03:14 AM
    Author     : M Zubair Ul Hassan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/header.jsp" %>
<style>
    .list-card-item:hover, .list-card-item:focus{
        background: #ebebeb;
        cursor: pointer;
    }
</style>
<div class="container" style="padding-top: 100px;">
    <c:if test="${not empty param.msg }">
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <strong> <c:out value="${param.msg}" /> </strong>

            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button> 
        </div>
    </c:if>
    <hr />
    <div class="row">
        <div class="col-md-4">
            <c:forEach var="job" items="${jobs}">

                <div class="card list-card-item" style="width: 18rem;">
                    <div class="card-body" onclick="populate(`${job}`)">
                        <h5 class="card-title"><c:out value="${job.jobTitle}" /></h5>
                        <h6 class="card-subtitle mb-2 text-muted"><c:out value="${job.empType}" /></h6>
                        <p class="card-text"><c:out value="${job.jobDesc}" /></p>

                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
                <br />
            </c:forEach>  
        </div>
        <div class="col-md-8">
             <div class="card" id="jobDetail">
                    <div class="card-body">
                        <h5 class="card-title">JOB TITLE</h5>
                        <h6 class="card-subtitle mb-2 text-muted">SOME S</h6>
                        <p class="card-text">Some Thing</p>

                        <a href="#" class="btn btn-primary">Apply</a>
                    </div>
                </div>
        </div>
    </div>

</div>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
<script>
    
    function populate(job) {
        console.log(job);
        var build = "{"+job+"}";
        var newbuild = build.replace(/[']/g, '"');
        var finalBuild = JSON.parse(newbuild);
        
        
        
        $("#jobDetail").find(".card-title").text(finalBuild.jobTitle);
        $("#jobDetail").find(".card-subtitle").text(finalBuild.empType);
        $("#jobDetail").find(".card-text").text(finalBuild.jobDesc);
    }
    
    </script>
</body>
</html>

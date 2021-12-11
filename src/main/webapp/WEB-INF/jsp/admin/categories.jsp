<%@ include file="/WEB-INF/jsp/header.jsp" %>

<style>
    table {
        width: 716px; /* 140px * 5 column + 16px scrollbar width */
        border-spacing: 0;
    }

    tbody, thead tr { display: block; }

    .thead-dark tr {
        display: table !important;
        width: 100% !important;
    }
    
    tbody {
        height: 600px;
        overflow-y: auto;
        overflow-x: hidden;
    }


    
    thead th:nth-child(1), tbody tr th {
        width: 10%;
    }
    thead th:nth-child(2), tbody tr td:nth-child(2) {
        width: 30%;
    }
    thead th:nth-child(3),  tbody tr td:nth-child(3) {
        width: 60%;
    }
    
    

</style>


<div class="container mt-5 pt-5">

    <div class="row">

        <div class="col-2">
            <ul class="list-group" style="position: fixed;">
                <a href="#" class="list-group-item list-group-item-action" style="background: #000; color: white;">MENU</a>
                <a href="/careergo/admin/categories" class="list-group-item list-group-item-action active">Categories</a>
                <a href="#" class="list-group-item list-group-item-action">Skills</a>
                <a href="#" class="list-group-item list-group-item-action">Users</a>
                <a href="#" class="list-group-item list-group-item-action">Applications</a>
                <a href="#" class="list-group-item list-group-item-action">Jobs</a>
                <a href="#" class="list-group-item list-group-item-action">Companies</a>
            </ul>
        </div>

        <div class="col-10">

            <div class="row">
                <form:form modelAttribute="catform" action="/careergo/admin/saveCategory">


                    <div class="form-group">
                        <label for="inputEmail4">Name</label>
                        <form:input class="form-control" path="catName" />

                    </div>
                    <div class="form-group">
                        <label for="empType">Description</label>
                        <form:textarea class="form-control" path="catDesc" />
                    </div>


                    <button class="btn btn-primary">Save</button>

                </form:form>
            </div>




            <br />
            <hr />
            <br />
            <h2>List of Categories</h2>
            <br />
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                   
                    <c:if test="${not empty cats}" >
                        <c:choose >
                            <c:when test="${true}">
                                <c:forEach var="cat" items="${cats}" varStatus="loop">
                                    <tr <c:if test="${param.savedCat == cat.id}"> style="background: green; color: white;"</c:if> >
                                        <th scope="row">${loop.index}</th>
                                        <td>${cat.catName}</td>
                                        <td>${cat.catDesc}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr >
                                    <th scope="row"></th>
                                    <td>Record Not Found</td>
                                    <td></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </c:if>



                </tbody>
            </table>


        </div>

    </div>
</div>










<%@ include file="/WEB-INF/jsp/footer.jsp" %>
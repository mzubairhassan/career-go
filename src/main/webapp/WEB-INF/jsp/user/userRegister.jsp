<%@ include file="/WEB-INF/jsp/header.jsp" %>


<div class="container pt-5 mt-5">
    <h2>Registration</h2>
    <hr />
     <form:form modelAttribute="appUser" action="/careergo/saveUser" >
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="username">Username</label>
                <form:input  Class="form-control" path="username" />
            </div>
            <div class="form-group col-md-6">
                <label for="pwd">Password</label>
                <form:input type="password" class="form-control" path="password" />
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">Email</label>
                <form:input type="email" class="form-control" path="email" />
            </div>
            <div class="form-group col-md-6">
                <label for="userType">User Type</label>
               <form:select path="userType"  class="form-control">
                        <form:option label="Applicant" value="applicant"/>
                        <form:option label="Company" value="company"/>
                </form:select>
            </div>
        </div>
        <div class="form-group">
                <label for="address">Address</label>
                 <form:textarea  path="address" placeholder="street,city,country"  class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
     </form:form>


</div>






<%@ include file="/WEB-INF/jsp/footer.jsp" %>




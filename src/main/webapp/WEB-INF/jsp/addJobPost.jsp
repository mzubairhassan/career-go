
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<div class="container" style='padding-top: 100px;'>
    <h1>Career Go</h1>
    <hr />
    <h4>Fill in all details required for job posting below</p>
        <form:form modelAttribute="jobPostUiObj"  action="/careergo/saveJobPost" method="POST"  >
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Job Title</label>
                    <form:input  Class="form-control" path="jobTitle" />
                </div>
                <div class="form-group col-md-6">
                    <label for="empType">Contract Type</label>
                    <form:input   Class="form-control" path="empType" id="empType" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">jobDesc</label>
                <form:textarea type="text" path="jobDesc" class="form-control" />
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">noOfPos</label>
                    <form:input  type="number" class="form-control" path="noOfPos" />
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">careerLevel</label>
                    <form:select path="careerLevel"  class="form-control">
                        <form:option label="Entry Level" value="Entry Level"/>
                        <form:option label="Experienced Professional" value="Entry Level"/>
                        <form:option label="Department Head" value="Department Head"/>
                        <form:option label="Intern/Student" value="Intern/Student"/>
                        <form:option label="GM / CEO / Country Head / President" value="CEO"/>


                    </form:select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">yearOfExp</label>
                    <form:input type="number" step="0.0" class="form-control" path="yearOfExp" />
                </div>

            </div>

            <div class="form-group">
                <label for="inputZip">skills</label>
                <form:input type="text" placeholder="Enter skills e.g drawing,painting,..." class="form-control" path="skillText" />
            </div>

            <div class="form-row">

                <div class="form-group col-md-8">
                    <label for="Category">Category</label>
                    <form:select class="form-control" path="categoryId">
                        <form:options items="${cats}" itemLabel="catName" itemValue="id" />

                    </form:select>

                </div>

                <div class="form-group col-md-2">
                    <label for="salary">salary</label>
                    <form:input type="number" class="form-control" path="salary" />
                </div>

            </div>
            <div id="questionares">


            </div>

                <button type="button" class="btn btn-secondary" onclick="addQuestions(this)" id="qAddId">Add Question</button>

            <button  type="submit" class="btn btn-primary">Add Job</button>
        </form:form>
</div>
<script>
     var inputNodes=0;
    function addQuestions(e) {
            
            let parentNode = document.querySelector("#questionares");
            let deleteSvg = `<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
</svg>`;
            if (inputNodes < 3) {
                qAddId.disabled = false;
                inputNodes = parentNode.childElementCount + 1;
                let newInput = document.createElement('input');
                let inputLabel = document.createElement('label');
                let deleteButton = document.createElement('button');
                deleteButton.type = "button"
                deleteButton.id = "btnDQ"+inputNodes;
                deleteButton.classList.add('btn');
                deleteButton.classList.add('btn-outline-danger');
                deleteButton.style.display = "inline";
                deleteButton.style.margin = "0px 20px";
                deleteButton.innerHTML = deleteSvg;
                
                inputLabel.innerText = "Question " + inputNodes;
                inputLabel.htmlFor = "q"+inputNodes;
                inputLabel.append(deleteButton);
                newInput.name = "q"+inputNodes;
                newInput.id = "q"+inputNodes;
                newInput.placeholder = "Enter your question"
                newInput.classList.add("form-control");
                let formGroup = document.createElement('div');
                formGroup.classList.add('form-group')
                formGroup.classList.add('col-md-12')
                formGroup.append(newInput);
                formGroup.insertBefore(inputLabel, newInput);
                parentNode.appendChild(formGroup);
                deleteButton.addEventListener("click", removeQuestion);
            } else {
                let qAddId = document.querySelector('#qAddId');
                qAddId.disabled = true;
                
            }
        }
    function removeQuestion(e) {
        console.log(e.target)
        let somen  = e.target;
        somen.parentElement.parentElement.remove()
        inputNodes--;
        qAddId.disabled = false;
    }


</script>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
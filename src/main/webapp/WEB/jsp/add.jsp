<%@ include file="common/head.jsp"%>
<%@ include file="common/nav.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Add Employee</h3>
    </div>
    <form action="/employees/add" modelAttribute="employeeForm" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>

        </div>
        <div class="mb-3">
            <label for="department" class="form-label">Department</label>
            <input type="text" class="form-control" id="department" name="department" required>
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">Salary</label>
            <input type="number" step="any" class="form-control" id="salary" name="salary" required>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary btn-sm me-3">Submit</button>
        </div>
    </form>
</div>
<%@ include file="common/footer.jsp"%>
<%@ include file="common/head.jsp"%>
<%@ include file="common/nav.jsp"%>
    <div class="container">
        <div class="text-center m-5">
            <h1>Employee System</h1>
        </div>
        <div class="container">
            <table class="table table-striped table-hover table-bordered align-middle">
                <thead class="table-dark text-center">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Department</th>
                        <th scope="col">Salary</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody class="text-center">
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <th scope="row">${employee.id}</th>
                        <td>${employee.name}</td>
                        <td>${employee.department}</td>
                        <td>
                            <fmt:setLocale value="en_US" />
                            <fmt:formatNumber type="currency" value="${employee.salary}" />
                        </td>
                         <td>
                         <c:set var="urlEdit" >
                            <c:url value="${application.contextPath}/edit">
                              <c:param name="id"
                              value="${employee.id}" />
                              </c:url>
                             </c:set>
                             <a href="${urlEdit}" class="btn btn-warning btn-sm me-3">Edit</a>
                         </td>
                        <td>
                            <c:set var="urlDelete" >
                                <c:url value="${application.contextPath}/delete">
                                    <c:param name="id"
                                    value="${employee.id}" />
                                </c:url>
                            </c:set>
                            <a href="${urlDelete}" class="btn btn-danger btn-sm me-3">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
<%@ include file="common/footer.jsp"%>
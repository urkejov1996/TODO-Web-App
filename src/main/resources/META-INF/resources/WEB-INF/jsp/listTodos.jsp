
   <%@ include file="common/navigation.jspf" %>
   <%@ include file="common/header.jspf" %>
    <div class="container">
        <h1> Your todos </h1>
        <table class="table">
            <thead>
                <tr>
                     <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var ="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-primary">UPDATE</td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo"  class="btn btn-success">Add TODO </a>
    </div>
   <%@ include file="common/footer.jspf" %>

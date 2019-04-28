<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add new customer</h3>
        <form:form action="addCustomer" modelAttribute="customer" method="POST">
            <table>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName" /></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName" /></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"/></td>
                </tr>
            </table>
        </form:form>

        <div style="clear: both;"></div>

        <p>
            <a href="list">back to list</a>
        </p>
    </div>
</body>
</html>
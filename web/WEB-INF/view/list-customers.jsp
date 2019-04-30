<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <input type="button" value="Add customer"
                onclick="window.location.href='addCustomerForm'; return false;" class='add-button'/>
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="searchStr" />
                <input type="submit" value="search" />
            </form:form>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="customer" items="${customers}">

                    <c:url var="updateLink" value="/customer/updateCustomerForm">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/deleteCustomer">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>

                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td><a href="${updateLink}">Update</a> |
                            <a href="${deleteLink}" onclick="if (!(confirm('Are you sure?'))) return false">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
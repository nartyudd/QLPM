<%-- 
    Document   : employee
    Created on : Sep 10, 2023, 9:17:24 PM
    Author     : duytr
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">DANH SÁCH NHÂN VIÊN</h1>

<c:url value="/employee" var="employee" />
<section class="container">
<form method="post" action="${employee}">
    
    <table class="table table-hover">
        <tbody>
        <div class="row">
            <c:forEach items="${employee}" var="e">
                <div class="col">
                    <div class="card" style="width: 300px">
                        <div class="card-body">
                            <h4 class="card-title">${e.tennhanvien}</h4>
                            <p class="card-text">${e.vitricongviec}</p>
                            <p>
                                <c:url value="/employee/${e.employeesId}" var="api" />
                                <c:url value="/api/employee/${e.employeesId}" var="apiDel" />

                                <a href="${api}" class="btn btn-info">Cập nhật</a>
                                <button class="btn btn-danger" onclick="deleteEmployee('${apiDel}')">Xóa</button>

                            </p>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>
        </tbody>
    </table>
</form:form>
</section>

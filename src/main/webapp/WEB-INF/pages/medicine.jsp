<%-- 
    Document   : medicines
    Created on : Jul 22, 2023, 3:18:13 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">DANH SÁCH THUỐC</h1>

<c:url value="/medicine" var="action" />
<form:form modelAttribute="medicine" method="post" action="${action}" enctype="multipart/form-data">
    
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="medicineName" id="name" placeholder="Tên thuốc" name="name" />
        <label for="name">Tên thuốc</label>
        <form:errors path="medicineName" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating">
        <form:textarea class="form-control" id="des" name="des" path="description" placeholder="thông tin thuốc"></form:textarea>
            <label for="des">thông tin thuốc</label>
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="unitPrice" id="price" placeholder="Giá thuốc" name="price" />
        <label for="name">Giá thuốc</label>
        <form:errors path="unitPrice" element="div" cssClass="text-danger" />
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="image"/>
        <label for="image">Ảnh sản phẩm</label>
        <c:if test="${medicine.image != null}">
            <<img src="${medicine.image}"  style="width: 120px"/>
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                    <c:when test="${medicine.id != null}">Cập nhật sản phẩm</c:when>
                    <c:otherwise>Thêm sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
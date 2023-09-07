<%-- 
    Document   : products
    Created on : Jul 22, 2023, 3:18:13 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info mt-1">DANH SÁCH THUỐC</h1>

<c:url value="/medicines" var="action" />
<form:form modelAttribute="medicine" method="post" action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id" />
    <form:hidden path="image" />
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
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="cate" name="cate" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == medicine.categoryId.id}"><option value="${c.id}" selected>${c.name}</option></c:when>
                    <c:otherwise><option value="${c.id}">${c.name}</option></c:otherwise>
                </c:choose>
                
            </c:forEach>
        </form:select>
        <label for="cate" class="form-label">Danh mục sản phẩm</label>
    </div>
        <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="image"/>
        <label for="image">Ảnh sản phẩm</label>
        <c:if test="${medicine.image != null}">
            <img src="${medicine.image}" width="120" />
        </c:if>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info">
            <c:choose>
                <c:when test="${medicne.id != null}">Cập nhật sản phẩm</c:when>
                <c:otherwise>Thêm sản phẩm</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
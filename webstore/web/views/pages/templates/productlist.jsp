<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 12-Jul-19
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-sm-12">
        <c:choose>
            <c:when test="${products.size() > 0}">
                <c:forEach items="${products}" var="product">
                    <div class="col-sm-3 home-product">
                        <div class="card card-blog">
                            <div class="">
                                <a href="<c:url value='/viewProduct'><c:param name='product' value='${product.getId()}' /></c:url>">
                                    <img class="img" alt="product"
                                         src="<c:url value='./views/assets/images/products/${product.getId()}.png'/>"/>
                                </a>
                            </div>
                            <div class="card-content">
                                <h4 class="card-title" style="font-size: 1em;"><c:out
                                        value="${product.getName()}"/></h4>
                                <div class="description">
                                    <p style="color:white;"><c:out value="$${product.getPrice()}"/></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3 class="section-title" style="text-transform:capitalize;">No Product on display yet.</h3>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<%--<div class="row">--%>
<%--    <div class="col-sm-12">--%>
<%--        <h2 class="section-title" style="text-transform:capitalize;">--%>
<%--            <span class="pull-right btn btn-sm">  <a style="color:white;" href="#">View More</a></span>--%>
<%--        </h2>--%>

<%--    </div>--%>
<%--</div>--%>
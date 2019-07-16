<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./templates/head.jsp" %>
<%@ include file="./templates/header.jsp" %>

<div class="page-header header-filter header-small" style="background-image: url('<c:url value="/views/assets/images/banner.png"/>');">
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-center">
                <div class="brand">
                    <h1 class="title">Search Results</h1>
                    <div>
                        <form class="navbar-form" role="search" method="get" action="<c:url value='/search'/>">
                            <div class="form-group form-white is-empty">
                                <input id="homesearch" type="text" class="form-control" required=""
                                       placeholder="Search for other products" name="product"
                                       style="color:#FFF;text-align: center;">
                                <span class="material-input"></span></div>
                            <button type="submit" class="btn btn-white btn-raised btn-fab btn-fab-mini"><i
                                    class="material-icons">search</i></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


    </div>
</div>

<div id="categories">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <c:choose>
                        <c:when test="${products.size() >0}">
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
                            <h3 class="section-title" style="text-transform:capitalize;">No Matching Product found.</h3>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <h2 class="section-title" style="text-transform:capitalize;">
                        <a class="text text-success" href="javascript::void(0)">You May Also Like</a></h2>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <c:forEach items="${advertisedproducts}" var="advertisedproduct">
                        <div class="col-sm-3 home-product">
                            <div class="card card-blog">
                                <div class="">
                                    <a href="<c:url value='/viewProduct'><c:param name='product' value='${advertisedproduct.getId()}' /></c:url>">
                                        <img class="img" alt="product"
                                             src="<c:url value='./views/assets/images/products/${advertisedproduct.getId()}.png'/>"/>
                                    </a>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title" style="font-size: 1em;"><c:out
                                            value="${advertisedproduct.getName()}"/></h4>
                                    <div class="description">
                                        <p style="color:white;"><c:out value="$${advertisedproduct.getPrice()}"/></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div><!-- section -->
</div>
<!-- end-main-raised -->

<%@ include file="./templates/modals.jsp" %>
<%@ include file="./templates/footer.jsp" %>
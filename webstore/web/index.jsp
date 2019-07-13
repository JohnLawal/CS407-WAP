<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 12-Jul-19
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ include file="./views/pages/templates/head.jsp" %>
<%@ include file="./views/pages/templates/header.jsp" %>


<div class="page-header header-filter header-small"
     style="background-image: url('<c:url value='./views/assets/images/banner.png'/>');">
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-center">
                <div class="brand">
                    <h1 class="title">Good Software, Good Life!</h1>
                    <h4>Brilliant, lab-fresh, naturally developed software solutions for your enjoyment</h4>
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
                    <h2 class="section-title" style="text-transform:capitalize;"><a class="text text-success" href="#">Latest
                        Products</a></h2>

                </div>
            </div>
            <%@ include file="./views/pages/templates/productlist.jsp" %>



        </div>
    </div><!-- section -->
</div>
<!-- end-main-raised -->
<%@ include file="./views/pages/templates/modals.jsp" %>

<%@ include file="./views/pages/templates/footer.jsp" %>

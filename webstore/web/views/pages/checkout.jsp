<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 12-Jul-19
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./templates/head.jsp" %>
<%@ include file="./templates/header.jsp" %>

<div id="categories">
    <div class="section">
        <div class="container" style="margin-top: 110px">
            <div class="row">
                <div class="col-sm-12">
                    <h2 class="section-title" style="text-transform:capitalize;"><a class="text text-success" href="#">Checkout</a>
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="col-sm-7 home-product" id="leftSide">
                        <c:choose>
                            <c:when test="${isloggedIn}">
                                <form role="form" action="#" onsubmit="checkout(); return false;" id="frmCheckout">
                                    <div class="col-md-6">
                                        <label for="txtName">Username</label><br />
                                        <div class="form-group name">
                                            <input class="form-control" readonly="" id="txtName" name="name" type="text" value="${user.getUsername()}" aria-invalid="false" aria-required="true" required>
                                        </div>
                                        <label for="txtPhone">Phone</label><br />
                                        <div class="form-group phone">
                                            <input class="form-control" readonly="" id="txtPhone" name="phone" type="tel" value="${user.getPhone()}" aria-invalid="false" aria-required="true" required>
                                        </div>
                                        <label for="optCity">Location</label><br />
                                        <div class="form-group city">
                                            <select id="optCity" required class="form-control select2" style="width: 100%;">
                                                <c:forEach items="${locations}" var="location">
                                                    <option value="${location}">${location}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <label for="optPayment">Payment Option</label><br />
                                        <div class="form-group payment">
                                            <select id="optPayment" required class="form-control select2" style="width: 100%;">
                                                <option value='delivery'>Pay on Delivery</option>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="col-md-6" >
                                        <label for="txtEmail">E-mail</label><br />
                                        <div class="form-group email">
                                            <input class="form-control" readonly="" id="txtEmail" name="email" type="email" value="${user.getEmail()}" aria-invalid="false" aria-required="true" required>
                                        </div>
                                        <label for="txtAddress">Address</label><br />
                                        <div class="form-group message">
                                            <input class="form-control" id="txtAddress" name="address" type="text" value="${user.getAddress()}" aria-invalid="false" aria-required="true" required>
                                        </div>
                                        <label for="txtState">State</label><br />
                                        <div class="form-group state">
                                            <div class="form-group message">
                                                <input class="form-control" id="txtState" readonly="" name="state" value="Iowa" type="text" aria-invalid="false" aria-required="true" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p>
                                            <div class="form-group">
                                                <div>
                                                    <input class="btn-lg btn btn-primary" type="submit" value="Proceed To Checkout">
                                                </div>
                                            </div>
                                            </p>
                                        </div>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <p>You need to </p>
                                <button type="button" class="btn btn-primary btn-md" data-toggle="modal" data-target="#signInModal">Sign In </button>
                                <p>In order to checkout</p>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="col-sm-5 home-product">
                        <div class="card card-pricing card-raised">
                            <div class="card-content content-success">

                                <h3 class="category text-info"><b id="containerTitle">Your Cart</b></h3>
                                <ul class="checkout-items">

                                </ul>
                                <div id="purchaselist">

                                </div>


                                <hr>

                                <div class="calculate">
                                    <ul id="cartamounts">
                                        <li><b>Sub-total : </b>$<span class="sub-total">0</span>

                                    </ul>
                                    <ul id="purchaseamounts">

                                    </ul>
                                </div>
                                <hr>

                                <a id="continuebtn" href="<c:url value='/welcome'/>" class="btn btn-rose btn-raised btn-round">
                                    Continue Shopping
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div><!-- section -->
</div>
<!-- end-main-raised -->
<%@ include file="./templates/modals.jsp" %>

<%@ include file="./templates/footer.jsp" %>

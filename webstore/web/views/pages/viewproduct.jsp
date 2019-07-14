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
                    <div class="col-sm-3 home-product">
                        <div class="card card-blog">
                            <div class="">
                                <a href="javascript:void(0)">
                                    <img class="img" alt="product"
                                         src="<c:url value='./views/assets/images/products/${product.getId()}.png'/>"/>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 home-product">
                        <h3>${product.getName()}</h3>
                        <h4>Unit
                            Price: $${product.getPrice()}</h4>
                        <h5>Total in stock: Unlimited</h5>
                        <div style="text-align: justify;">
                            ${product.getName()} is one of our amazing products. You will definitely enjoy making use of it
                            while we protect your data.
                        </div>
                        <form role="form" action="#"
                              onsubmit="addToCart('${product.getId()}'); return false;">
                            <input id="txtQuantity" required="" class="form-control col-md-6" style="width: 50%;"
                                   placeholder="Quantity" type="number" min="1" max="10"/>
                            <button type="submit" class="btn btn-success">
                                Add to Cart
                            </button>
                        </form>

                    </div>


                    <div class="col-sm-5 home-product">
                        <div class="card card-pricing card-raised">
                            <div class="card-content content-success">

                                <h3 class="category text-info"><b>Your Cart</b></h3>
                                <ul class="checkout-items">

                                </ul>


                                <hr>

                                <div class="calculate">
                                    <ul>
                                        <li><b>Sub-total : </b>$<span class="sub-total">0</span><input
                                                type="hidden" name="sub-total" class="hidden1"></li>

                                    </ul>
                                </div>
                                <hr>

                                <a href="<c:url value='/checkout'/>"
                                   class="cart_checkout btn btn-white btn-raised btn-round" disabled="disabled">
                                    Checkout
                                </a><br>
                                <a href="<c:url value='/welcome'/>"
                                   class="btn btn-rose btn-raised btn-round">
                                    Continue Shopping
                                </a>

                            </div>
                        </div>
                    </div>
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

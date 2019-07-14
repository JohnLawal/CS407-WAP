<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 13-Jul-19
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="allmodals">
    <c:choose>
        <c:when test="${!isloggedIn}">
            <div id="signInModal" class="modal fade" role="dialog">
                <div class="modal-dialog modal-sm signIn">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;
                            </button>
                            <h4 class="modal-title">Sign In</h4>
                        </div>
                        <div class="modal-body">
                            <form role="form" action="#" onsubmit="signIn(); return false;" id="frmSignIn">
                                <div class="row">
                                    <div class="form-group col-sm-12" id="signinNotice">

                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label for="txtUsernameSignIn">Username</label>
                                        <input class="form-control required" type="text" required="required"
                                               id="txtUsernameSignIn">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label for="txtPasswordSignIn">Password</label>
                                        <input class="form-control" type="password" required="required"
                                               id="txtPasswordSignIn">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group col-sm-12">
                                        <label for="chkRememberMe">
                                            <input class="form-control required" value="Remember Me" type="checkbox" id="chkRememberMe">
                                            <span>Remember Me</span>
                                        </label>

                                    </div>
                                </div>
                                <div class="signIn-foot">
                                    <button type="submit" class="btn btn-success signIn">SIGN IN</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div id="accountaccess" class="modal fade" role="dialog">
                <div class="modal-dialog modal-sm " >
                    <div class="modal-content" style="background-color: #e2c70b;">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h2 class="text-center"><b>Your Account</b></h2>
                        </div>
                        <div class="modal-body text-center">
                            <form id="formx" action="#" method="POST">
                                <div class="card-content content-rose">
                                    <a href="<c:url value='/logout'/> " class="btn btn-default btn-raised btn-round">
                                        Log Out
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>


    <div id="cart" class="modal fade" role="dialog">
        <div class="modal-dialog modal-sm cart">
            <div class="modal-content" style="background-color: #D93600; color: #fff">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 class="text-center"><b>Your Cart</b></h2>
                </div>
                <div class="modal-body text-center">
                    <form id="form2" action="#" method="POST">
                        <div class="card-content content-rose">
                            <ul class="checkout-items">
                            </ul>
                            <hr>
                            <div class="calculate">
                                <ul>
                                    <li><b>Sub-total : </b>&#x20A6;<span class="sub-total">0</span><input type="hidden"
                                                                                                          name="sub-total"
                                                                                                          class="hidden1">
                                    </li>
                                </ul>
                            </div>
                            <hr>
                            <a href="<c:url value='/checkout'/>"
                               class="cart_checkout btn btn-white btn-raised btn-round">
                                Check Out
                            </a>

                            <a href="javascript:void(0)" onclick="clearCart();"
                               class="cart_checkout btn btn-success btn-raised btn-round">
                                Clear cart
                            </a>


                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>


</div>

<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 12-Jul-19
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body class="section-white">

<div class="header-2">
    <nav class="navbar navbar-primary navbar-fixed-top" id="sectionsNav">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<?= base_url() ?>"><img
                        src="<c:url value='./views/assets/images/favicontext.png' />" style="width: 60px;"/></a>
            </div>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">

                    <c:choose>
                        <c:when test="${isloggedIn}">
                            <li>
                                <button type="button" class="btn btn-primary btn-md ontline" data-toggle="modal"
                                        data-target="#accountaccess">${username}</button>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li style="margin: 1px">
                                <button type="button" class="btn btn-primary btn-md" data-toggle="modal"
                                        data-target="#signInModal">Sign In
                                </button>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li style="margin: 1px">
                        <button class="btn btn-white" data-toggle="modal" data-target="#cart"><i
                                class="fa fa-shopping-cart"></i> <span id="cartno"
                                                                       data-no="<c:out value='${cart.size()}'/>"><c:out
                                value='${cart.size()}'/></span> Items
                        </button>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

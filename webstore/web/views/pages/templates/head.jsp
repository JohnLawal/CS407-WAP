<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="Description" content="My WAP Servlet assignment"/>

    <title><c:out value="${pageTitle}"/></title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <link rel="icon" type="image/png" href="<c:url value='./views/assets/images/favicon.png' />">

    <!-- jQuery Confirm -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.css">

    <!-- CSS Files -->
    <link rel='stylesheet' href="<c:url value='./views/assets/plugins/preloader/preloader.css'/>">
    <link rel='stylesheet' href="<c:url value='./views/assets/plugins/bootstrap/bootstrap.min.css'/>">
    <link rel='stylesheet' href="<c:url value='./views/assets/css/material-kit.min3f71.css?v=1.1.1'/>">
    <link rel='stylesheet' href="<c:url value='./views/assets/plugins/datatables/dataTables.bootstrap.css'/>">
    <link rel='stylesheet' href="<c:url value='./views/assets/css/creative_main.css'/>">
    <link rel='stylesheet' href="<c:url value='./views/assets/css/main.css'/>">

    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>

    <c:out value="${pageStyle}"/>


</head>

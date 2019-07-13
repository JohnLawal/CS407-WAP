<%--
  Created by IntelliJ IDEA.
  User: JOHN LAWAL IMHONIKHE
  Date: 12-Jul-19
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<footer class="footer">
    <div class="container">
        <div class="col-md-12">
            <div class="col-md-3">
                    <a href="#" target="_blank"><img src="<c:url value='./views/assets/images/favicontext.png'/>"
                                                     alt="JLawal" class="img-responsive" height="200" width="200"></a>
            </div>
            <div class="col-md-3">
                <h3 class="footer-head">ABOUT JLawal</h3>
                <p>We deliver brilliant, lab-fresh, naturally developed software solutions for your enjoyment.</p>
            </div>
            <div class="col-md-3">
                <p>
                <h3 class="footer-head">TERMS</h3></p>
                <a href="#" class="link-me"><p>Terms and Conditions</p></a>
                <a href="#" class="link-me"><p>Delivery Information</p></a>
                <a href="#" class="link-me"><p>Privacy Policy</p></a>
            </div>
            <div class="col-md-3">
                <p>
                <h3 class="footer-head">CONTACT US</h3></p>
                <p>1000 N 4th Street,</p>
                <p>Fairfield, IA USA</p>
                <p>For all enquiries, please contact:</p>
                <p><i class="fa fa-envelope-o"></i> jilawal@mum.edu</p>
                <p>
            </div>
        </div>
    </div>
</footer>

<nav class="offices-menu">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h4 class="pre-header">Our Social Media Accounts:</h4>
                <a href="#" target="_blank"
                   class="btn btn-sm btn-primary">
                    <img src="https://farm360.org/assets/content/uploads/facebook.png" alt="Facebook">
                    Facebook </a>
                <a href="#" class="btn btn-sm btn-primary" target="_blank">
                    <img src="https://farm360.org/assets/content/uploads/instagram.png" alt="Instagram">
                    Instagram </a>
                <a href="#" class="btn btn-sm btn-primary" target="_blank">
                    <img src="https://farm360.org/assets/content/uploads/twitter.png" alt="Twitter">
                    Twitter </a>
            </div>
        </div>
    </div>
</nav>


<footer class="content-info" role="contentinfo">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <span class="pull-right hidden-sm">
                    <a href="https://jlawal.com/" target="_blank">
                        <span style="color:#fff">Webdesign-</span>
                    </a>
                    John Lawal
                </span>
                <span class="pull-left"> © 2019 Copyright  <a style="color:#eee" href="https://jlawal.com"
                                                              target="_blank">John Lawal</a> </span>
            </div>
        </div>
    </div>
</footer>


<script src="<c:url value='./views/assets/plugins/bootstrap/bootstrap.min.js' />" type="text/javascript"></script>
<script src="<c:url value='./views/assets/js/material.min.js' />"></script>
<script src="<c:url value='./views/assets/plugins/bootstrap/bootstrap-notify.js' />"></script>
<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="<c:url value='./views/assets/js/material-kit.min.js' />"></script>
<script src="<c:url value='./views/assets/plugins/datatables/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='./views/assets/plugins/datatables/dataTables.bootstrap.min.js' />"></script>
<!-- JQuery Confirm -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>
<script type='text/javascript' src="<c:url value='./views/assets/plugins/preloader/jquery.preloader.min.js' />"></script>
<script type='text/javascript' src="<c:url value='./views/assets/js/cart.js' />"></script>

<%--<c:out value="${pageScript}"/>--%>


</body>
</html>


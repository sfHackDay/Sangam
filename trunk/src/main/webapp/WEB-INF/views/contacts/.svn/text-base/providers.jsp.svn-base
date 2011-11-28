<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<style>
#contacts { padding: 20px 10px;}
#contacts a img{ border:none;}
#contacts a {padding:10px 10px 5px 0px;display:inline-block;}
#contacts .title {padding:10px 5px 5px 0px; font-size: 18px; font-weight:bold; border-bottom:1px solid #ccc;}
#composeMsg span{padding:2px 0px; font-weight:bold; }
#composeMsg {padding:10px;}
#addressBlock{position:absolute;border:1px solid #bbb;	max-height:200px;overflow:auto;	z-index:100;background-color:#ffffff;	display: none;width:98%;}
#addressBlock ul {margin:0px; list-style-type:none; padding:5px;  }
#addressBlock ul li {padding:5px 0px;margin:0px; width:100%}
#addressList{padding-bottom:5px;}
#addressList .cross {padding:0px 6px 0px 2px;font-weight:bold;color:#0000cc;text-decoration: none;}
.fullLengthInput{width:300px;display:block;height:21px; line-height:21px;border-top:1px solid #bbb;border-radius:6px;font-size: medium;}

.addressBtn {
background-color:#98d2ff;
border:1px solid #91ceff;
padding: 4px 8px;
margin:10px 0px;
font-family: "Trebuchet MS",Arial,Verdana,sans-serif;
font-size: 13px;
font-weight: bold;
cursor: pointer;
display: inline-block;
color: #444444;
background: url("http://localhost:8181/sangam/images/btn_aqua_active.gif") repeat;
background-position: 0 50%;

}
</style>
</head>
<body>

<div id="contacts">
	<div class="title">Please choose the provider: </div>
	<div align="center">
	<c:forEach items="${providers}" var="provider">
       <a href="${provider.authTokenUrl}">
			<c:if test="${provider.providerId=='yahoo'}">
			<img src="http://localhost:8181/sangam/images/yahoo.jpg" alt="Yahoo"/>
			</c:if>
			<c:if test="${provider.providerId=='google'}">
			<img src="http://localhost:8181/sangam/images/google.jpg" alt="Gmail"/>
			</c:if>
			  <c:if test="${provider.providerId=='hotmail'}">
			<img src="http://localhost:8181/sangam/images/hotmail.jpg" alt="Hotmail"/>
			</c:if>
			  <c:if test="${provider.providerId=='linkedin'}">
			<img src="http://localhost:8181/sangam/images/linkedIn.jpg" alt="Linked In"/>
			</c:if>
        </a>
      </c:forEach>
	</div>
</div>


</body>
</html>

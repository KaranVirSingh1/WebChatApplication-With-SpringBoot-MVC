<!-- 
	if user inserting wrong input like null insertion , blank insertion 
	so Controller moves user on this page and he having only option to login again with proper information
 -->


<%@ page isELIgnored="false" %>

<br>
<br>
Login Status :: ${resultMsg}
<br>
<br>
<a class="opcion"  href="<%= request.getContextPath()%>/backToHomePage">Go To Home Page</a>
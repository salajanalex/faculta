<!DOCTYPE html>
<html>
<%--<script type="text/javascript" src="client.js"></script>--%>
<script>
    function logout(){
        session.invalidate();
        response.sendRedirect("login");
    }
</script>
<head>

</head>

<body>

<%
    session.invalidate();
    response.sendRedirect("login");
%>

<form action="/logout" method="get">
    <button type="submit" onclick="logout()">Log Out</button>
</form>

</body>
</html>
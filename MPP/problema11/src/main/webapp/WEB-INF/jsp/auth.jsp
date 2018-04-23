
<%--<%--%>
    <%--//User user = request.getParameter("user");--%>
    <%--//String user = request.getParameter("uname");--%>

   <%--// HttpSession session = request.getSession();--%>
    <%--//session.setAttribute("user", user);--%>
    <%--HttpSession session = request.getSession();--%>
    <%--session.setAttribute("user", request.getParameter("user"));--%>

<%--%>--%>

<!DOCTYPE html>
<html>
<head>

    <%

        String uname = request.getParameter("uname");
        session.setAttribute("uname",uname);

        if (uname!=null){
            String redirectURL = "curse";
            response.sendRedirect(redirectURL);
        }

        else {
            %>
    <script type="text/javascript">
        window.onload = function(){
            alert('LogIn failed. Try again.');
        }
    </script>
             <%
            response.sendRedirect("login");
        }



    %>






</head>
<body>

</body>
</html>
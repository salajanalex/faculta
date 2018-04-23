<%@page language="java" session="true" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.Random"%>


<c:forEach items="${ion}" var="cur">
    ${cur.nume}<br>
</c:forEach>

<%
    String user = (String)request.getSession().getAttribute("uname");
    String user1 = (String) session.getAttribute("uname");

    if (user1==null){
        String redirectURL = "login";
        response.sendRedirect(redirectURL);
    }
%>

<script type="text/javascript" src="../../../resources/static/client.js"></script>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">

    <script src="/webjars/sockjs-client/1.0.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3/stomp.min.js"></script>
    <script src="/client.js"></script>


    <style>

        #title {
            font-family: 'Open Sans', sans-serif;
            color: #555;
            text-decoration: none;
            text-transform: uppercase;
            font-size: 75px;
            font-weight: 800;
            letter-spacing: -3px;
            line-height: 1;
            text-shadow: #EDEDED 3px 2px 0;
            position: relative;
        }

        #div {
            position: absolute;
            /*width: 300px;*/
            height: 620px;
            z-index: 15;
            top: 30%;
            left: 50%;
            padding: 0 50px 0 50px;
            margin: -150px 0 0 -200px;
            background: white;
            opacity: 0.93;
        }

        p, text{
            font-family: arial, sans-serif;
            size: A3;
        }

        h3, h2{
            font-family: arial, sens-serif;
            size: auto;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 110%;
        }

        thead, tbody { display: block; }

        tbody {
            max-height: 300px;       /* Just for the demo          */
            overflow-y: auto;    /* Trigger vertical scroll    */
            overflow-x: hidden;  /* Hide the horizontal scroll */
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        input{
            font-size: 100%;

            width: auto;
        }
    </style>

</head>

<body onload="connect()" background="https://i.pinimg.com/originals/70/67/75/70677500e847add7d36742979d770e68.jpg">
<%--<div style="float: left">--%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<%--</div>--%>

<div align="right">
    <jsp:include page="header.jsp"></jsp:include>
</div>

<h2 id="title">Inscrieri<br/>Motocross<br/>2018</h2>
<div id="div" >
<h2>Lista curse disponibile</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Nume</th>
        <th>Capacitate</th>
        <th>Nr. participanti</th>
    </tr>
    <c:forEach items="${curseList}" var="cursa">
        <tr>
            <td>${cursa.id}</td>
            <td>${cursa.nume}</td>
            <td>${cursa.capacitate} cm3</td>
            <td id=${cursa.id}>${cursa.listaParticipant.size()}</td>
        </tr>
    </c:forEach>
</table>

    <%--//incercare de session--%>
  <%--<%  public void doGet(HttpServletRequest request, HttpServletResponse response) {--%>

    <%--HttpSession session = request.getSession();--%>
    <%--String uname = (String)request.getAttribute("uname");--%>
    <%--session.setAttribute("uname", uname);--%>
    <%--}--%>
    <%--%>--%>
<h3>Cauta participant dupa echipa:</h3>
<form action="/partbyechipa" method="get">
    <p>Numele echipei <input type="text" name="echipa"><p/>
    <button class="pure-button pure-button-primary" type="submit">Cauta!</button><br>
</form>
<br/>
<br/>
<form action="/participanti" method="get">
    <button class="pure-button pure-button-primary" type="submit">Administrare participanti</button><br>
</form>
</div>

</body>
</html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--<c:forEach items="${participantList}" var="list">--%>
    <%--${list.nume}<br>--%>
<%--</c:forEach>--%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">

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
            width: 300px;
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

<body background="https://i.pinimg.com/originals/70/67/75/70677500e847add7d36742979d770e68.jpg">
<div id="div">

<h2>Lista Participantilor dupa echipa ${echipa}</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Nume</th>
        <th>Echipa</th>
        <th>Capacitate</th>
    </tr>
    <c:forEach items="${participantList}" var="participant">
        <tr>
            <td>${participant.id}</td>
            <td>${participant.nume}</td>
            <td>${participant.echipa}</td>
            <td>${participant.capacitate}</td>
        </tr>
    </c:forEach>
</table>

<h3>Cauta dupa alta echipa:</h3>
<form action="/partbyechipa" method="get">
    Numele echipei <input type="text" name="echipa">
    <button class="pure-button pure-button-primary" type="submit">Cauta!</button><br>
</form>
<br/>
<br/>
<form action="/curse" method="get">
    <button class="pure-button pure-button-primary" type="submit">Inapoi la curse</button><br>
</form>

</div>
</body>

</html>
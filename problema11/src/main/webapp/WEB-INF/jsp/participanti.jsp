<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%--<c:forEach items="${participantList}" var="list">--%>
<%--${list.nume}<br>--%>
<%--</c:forEach>--%>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="functions.js"></script>
    <script type="text/javascript">addPopup()</script>
    <script>
    function addPopup() {
    window.alert("Participantul a fost adaugat cu succes!")
    }
    </script>

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
            height: 730px;
            z-index: 15;
            top: 22%;
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
<br/>

<h3>Adaugare participant nou</h3>
<form action="/participanti/add" method="post">
    <p>Nume: <input type="text" name="nume" placeholder="Nume complet participant"></p>
    <p>Echipa: <input type="text" name="echipa" placeholder="Echipa participantului"></p>
    <p>Capacitate: <select name="capacitate">
                        <option value="500">500 cm3</option>
                        <option value="750">750 cm3</option>
                        <option value="1000">1000 cm3</option>
                    </select></p>
    <p>Alegeti Cursa: </p> <select name="idcursa">
    <c:forEach items="${cursaList}" var="cursa">
        <option value="${cursa.id}">${cursa.nume}  ${cursa.capacitate}</option>
    </c:forEach>
</select>
    <button class="pure-button pure-button-primary" onclick="addPopup()" type="submit">Adauga!</button><br>
</form>

<br/>
<form action="/curse" method="get">
    <button class="pure-button pure-button-primary" type="submit">Inapoi la curse</button><br>
</form>

</div>
</body>
</html>

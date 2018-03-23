<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:forEach items="${ion}" var="cur">
    ${cur.nume}<br>
</c:forEach>
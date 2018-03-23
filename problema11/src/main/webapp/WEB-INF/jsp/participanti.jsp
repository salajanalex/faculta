<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<c:forEach items="${participantList}" var="list">
    ${list.nume}<br>
</c:forEach>


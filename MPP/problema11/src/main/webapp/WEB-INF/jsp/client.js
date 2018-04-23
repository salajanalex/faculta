var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility
        = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('/spring-mvc-java/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var nume = document.getElementById('nume').value;
    var echipa = document.getElementById('echipa').value;
    var cap = document.getElementById("capacitate");
    var capacitate = cap.options[cap.selectedIndex].value; //asa e cand e select in jsp
    var e = document.getElementById("idcursa");
    var idcursa = e.options[e.selectedIndex].value;

    stompClient.send("/app/curse", {},
        JSON.stringify({'nume':nume, 'echipa':echipa, 'capacitate': capacitate, 'idcursa':idcursa}));
    window.alert("Participantul a fost adaugat cu succes!");
}

function showMessageOutput(messageOutput) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.from + ": "
        + messageOutput.text + " (" + messageOutput.time + ")"));
    response.appendChild(p);
}

function logout(){
    session.invalidate();
    response.sendRedirect("login");
}
var stompClient = null;


function connect() {
    var socket = new SockJS('/curse');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
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
    console.log("Disconnected");
}

function sendMessage() {
    var nume = document.getElementById('nume').value;
    var echipa = document.getElementById('echipa').value;
    var cap = document.getElementById("capacitate");
    var capacitate = cap.options[cap.selectedIndex].value;
    var e = document.getElementById("idcursa");
    var idcursa = e.options[e.selectedIndex].value;

    stompClient.send("/app/curse", {},
        JSON.stringify({'nume':nume, 'echipa':echipa, 'capacitate': capacitate, 'idCursa':idcursa}));
    window.alert("Participantul a fost adaugat cu succes!");
}

function showMessageOutput(messageOutput) {
    var clientid=messageOutput.cursaId;
    var nrparticipanti=messageOutput.nrParticipanti;
    var celula=document.getElementById(clientid);
    celula.innerHTML=nrparticipanti;
}
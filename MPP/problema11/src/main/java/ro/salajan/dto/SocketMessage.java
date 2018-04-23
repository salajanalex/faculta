package ro.salajan.dto;

public class SocketMessage {
    private int cursaId;
    private int nrParticipanti;

    public SocketMessage(int cursaId, int nrParticipanti){
        this.cursaId = cursaId;
        this.nrParticipanti = nrParticipanti;
    }

    public int getCursaId() {
        return cursaId;
    }

    public void setCursaId(int cursaId) {
        this.cursaId = cursaId;
    }

    public int getNrParticipanti() {
        return nrParticipanti;
    }

    public void setNrParticipanti(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
    }



}

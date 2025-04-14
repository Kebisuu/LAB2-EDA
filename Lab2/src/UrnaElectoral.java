import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
private String obtenerTimestamp() { //Ya que votante no cuenta con timestamp copilot me hizo crear esto ns q opinan?
    return java.time.LocalTime.now().toString();
}
public class UrnaElectoral {
    private LinkedList<Candidato> listaCandidatos;
    private Stack<Voto> historialVotos;
    private Queue<Voto> votosReportados;
    private int idCounter;
    // Este me recomienda usarlo cuando quiero ocupar valores antiguos por lo que entendí
    /*public UrnaElectoral(LinkedList<Candidato> listaCandidatos, Stack<Voto> historialVotos,  Queue<Voto> votosReportados, int idCounter) {
        this.listaCandidatos = listaCandidatos;
        this.historialVotos = historialVotos;
        this.votosReportados = votosReportados;
        this.idCounter = idCounter;
    }
    // No sé cual usar, copilot me recomienda este para cuando se inicializa en cero, con datos nuevos
    public UrnaElectoral() {
        this.listaCandidatos = new LinkedList<>();
        this.historialVotos = new Stack<>();
        this.votosReportados = new LinkedList<>();
        this.idCounter = 1;
    } */
    public boolean verificarVotante(Votante votante){
        votante.getYaVoto();
    }
    public boolean registrarVoto(Votante votante, int candidatoID) {
        if(votante.getYaVoto()==true){
            System.out.println("Votante ya registrado");
            return false;
        }
        else{
            Voto nuevoVoto = new Voto(idCounter++, votante.getID(), candidatoID, obtenerTimestamp());
            for( Candidato candidato : listaCandidatos){
                if(candidato.getID() == candidatoID){
                    candidato.agregarVoto(nuevoVoto);
                    break;
                }
            }
            historialVotos.push(nuevoVoto);
            votante.marcarComoVotado();
            return true;
        }
    }
    public boolean reportarVoto(Candidato candidato, int idVoto) {
        Queue<Voto> votos = candidato.getVotosRecibidos();
        for(Voto voto : votos){
            if(voto.getID() == idVoto){
                votosReportados.add(voto);
                votos.remove(voto);
                return true;
            }
        }
        System.out.println("El voto reportado no se ha encontrado");
        return false;
    }
    public String obtenerResultados() { // no lo entiendo bien pero copilot me dice que hay que hacer esto para el metodo
        StringBuilder resultados = new StringBuilder();
        for (Candidato candidato : listaCandidatos) {
            resultados.append("Candidato ").append(candidato.getNombre())
                    .append(" (").append(candidato.getPartido()).append("): ")
                    .append(candidato.getVotosRecibidos().size()).append(" votos.\n");
        }
        return resultados.toString();
    }
}
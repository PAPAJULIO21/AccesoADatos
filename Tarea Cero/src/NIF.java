
public class NIF extends Documentacion{

    private String numero;
    private char letraFinal;

    public NIF(){

    }

    public NIF(String numero, char letraFinal) {
        this.numero = numero;
        this.letraFinal = letraFinal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(char letraFinal) {
        this.letraFinal = letraFinal;
    }

    @Override
    public boolean validar(){
        return numero.matches("\\d{8}") && Character.isLetter(letraFinal);
    }

    @Override
    public String mostrar(){
        return numero + letraFinal;
    }

    @Override
    public String toString() {
        return "NIF [numero=" + numero + ", letraFinal=" + letraFinal + "]";
    }

    

    
    
}

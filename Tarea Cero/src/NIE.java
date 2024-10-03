
public class NIE extends Documentacion{

    private String numero;
    private char letraInicial;
    private char letraFinal;

    public NIE(){

    }

    public NIE(String numero, char letraInicial, char letraFinal) {
        this.numero = numero;
        this.letraInicial = letraInicial;
        this.letraFinal = letraFinal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public char getLetraInicial() {
        return letraInicial;
    }

    public void setLetraInicial(char letraInicial) {
        this.letraInicial = letraInicial;
    }

    public char getLetraFinal() {
        return letraFinal;
    }

    public void setLetraFinal(char letraFinal) {
        this.letraFinal = letraFinal;
    }

    @Override
    public boolean validar(){
        return (letraInicial == 'X' || letraInicial == 'Y' || letraInicial == 'Z')
                && numero.matches("\\d{7}")
                && Character.isLetter(letraFinal);
    }

    @Override
    public String mostrar(){
        return letraInicial + numero + letraFinal;
    }

    @Override
    public String toString() {
        return "NIE [numero=" + numero + ", letraInicial=" + letraInicial + ", letraFinal=" + letraFinal + "]";
    }

    

    
    
}

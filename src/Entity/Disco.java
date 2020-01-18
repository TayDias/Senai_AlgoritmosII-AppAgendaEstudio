
package Entity;


public class Disco extends Gravacao{
    protected int id;
    private String nome;
    private String artista;
    private EnumGenero genero;
    private String duracao;
    private int faixas;
    private double custoPorFaixas;
    private int copiasProduzidas;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
   
     public Disco(){
        custoPorFaixas = 10;
    }

    public int getCopiasProduzidas() {
        return copiasProduzidas;
    }

    public void setCopiasProduzidas(int copiasProduzidas) {
        this.copiasProduzidas = copiasProduzidas;
    }
     
    public void incluirCopias(int numero){
        copiasProduzidas+= numero;
    }
     
    @Override
    public String toString() {
        return nome + " ("+artista+") - ";
       
    } 
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public EnumGenero getGenero() {
        return genero;
    }

    public void setGenero(EnumGenero Genero) {
        this.genero = Genero;
    }

    public int getFaixas() {
        return faixas;
    }

    public void setFaixas(int Faixas) {
        this.faixas = Faixas;
    }
    
}

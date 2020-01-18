
package Entity;

    public enum EnumGenero {
    ROCK (1, "Rock"),
    POP (2, "Pop"),
    REGGAE (3, "Reggae"),
    SERTANEJO (4, "Sertanejo"),
    ELETRONICA (5, "Eletronica");
    
    private String descricao;
    private int codigo;

    EnumGenero(int codigo,String descricao) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCodigo() {
        return codigo;
    }
    
   public EnumGenero getGenero(int codigo) {
       for (EnumGenero enumGenero : EnumGenero.values()) {
           if(enumGenero.getCodigo()==codigo){
               return enumGenero;
           }
       }
       return null;
   }
    
    @Override
    public String toString(){
        return descricao;
    }
}

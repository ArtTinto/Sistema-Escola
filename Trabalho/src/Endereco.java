public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;

    public Endereco(String estado, String cidade, String bairro, String rua, int numero) {
        if (estado != null && cidade != null && bairro != null && rua != null && numero > 0) {
            this.estado= estado;
            this.cidade = cidade;
            this.bairro = bairro;
            this.rua = rua;
            this.numero = numero;
        }
    }
}

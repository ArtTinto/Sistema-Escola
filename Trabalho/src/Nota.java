package escola;
public class Nota {
    private Disciplina disciplina;
    private Matricula matricula;
    private float valor;

    private Nota(Disciplina disciplina, Matricula matricula, float valor) {
        if (disciplina != null && matricula != null && valor > 0 && valor <= 100) {
            this.disciplina = disciplina;
            this.matricula = matricula;
            this.valor = valor;
        }
    }

    public static Nota getInstance(Disciplina disciplina, Matricula matricula, float valor) {
        return new Nota(disciplina, matricula, valor);
    }

    public float getValor() {
        return valor;
    }
}

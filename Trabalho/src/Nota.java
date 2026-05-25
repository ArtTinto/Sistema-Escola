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

    public void printaNotadoAluno(int larguraColuna) {
        for (int i = 0; i < larguraColuna; i++) {
            System.out.print("-");
        }
        System.out.println("\n| Aluno | Disciplina | Nota |");
        for (int i = 0; i < larguraColuna; i++) {
            System.out.print("-");
        }
        System.out.printf("\n| %s | %s | %.2f |\n", matricula.getAluno().getNome(), disciplina.getNomeDisciplina(), valor);
        for (int i = 0; i < larguraColuna; i++) {
            System.out.print("-");
        }
    }

    public float getValor() {
        return valor;
    }
}
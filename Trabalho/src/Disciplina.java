package escola;
public class Disciplina {
    private static long qtdDisciplinas = 0;
    private long id;
    private String nomeDisciplina;
    private String nomeProfessor;

    private Disciplina(String nomeDisciplina, String nomeProfessor) {
        if (nomeDisciplina != null && nomeProfessor != null) {
            Disciplina.qtdDisciplinas++;
            this.id = qtdDisciplinas;
            this.nomeDisciplina = nomeDisciplina;
            this.nomeProfessor = nomeProfessor;
        }
    }

    public static Disciplina getInstance(String nomeDisciplina, String nomeProfessor) {
        return new Disciplina(nomeDisciplina, nomeProfessor);
    }

    public boolean alterar(String nomeDisciplina, String nomeProfessor) {
        if (nomeDisciplina != null && nomeProfessor != null) {
            this.nomeDisciplina = nomeDisciplina;
            this.nomeProfessor = nomeProfessor;
            return true;
        }
        return false;
    }

    public static long getQtdDisciplinas(){
        return qtdDisciplinas;
    }

    public long getId() {
        return id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
}

public class Disciplina {
    private static long qtdDisciplinas = 0;
    private long idDisiciplina;
    private String nomeDisciplina;
    private String nomeProfessor;

    public Disciplina(String nomeDisciplina, String nomeProfessor) {
        if (nomeDisciplina != null || nomeProfessor != null) {
            Disciplina.qtdDisciplinas++;
            this.idDisiciplina = qtdDisciplinas;
            this.nomeDisciplina = nomeDisciplina;
            this.nomeProfessor = nomeProfessor;
        }
    }

    public boolean alterarDisciplina(String nomeDisciplina, String nomeProfessor) {
        if (nomeDisciplina != null || nomeProfessor != null) {
            this.nomeDisciplina = nomeDisciplina;
            
            this.nomeProfessor = nomeProfessor;
            
            return true;
        }
        return false;
    }

    public long getIdDisciplina(){
        return this.idDisiciplina;
    }

    public String getNomeDisciplina(){
        return this.nomeDisciplina;
    }

    public String getNomeProfessor(){
        return this.nomeProfessor;
    }
}
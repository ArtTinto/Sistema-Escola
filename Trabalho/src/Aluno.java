public class Aluno {
    private static int qtdAlunos = 0;
    private int codigoAluno; 
    private String nomeAluno;
    private double rendimentoGlobal; 

    public Aluno(String nomeAluno) {
        if (nomeAluno != null && !nomeAluno.trim().isEmpty()) {
            Aluno.qtdAlunos++;
            this.codigoAluno = Aluno.qtdAlunos;
            this.nomeAluno = nomeAluno;
        } else {
            throw new IllegalArgumentException("O nome do aluno não pode ser nulo ou vazio.");
        }
    }

    public boolean setNomeAluno(String nomeAluno) {
        if (nomeAluno != null && !nomeAluno.trim().isEmpty()) {
            this.nomeAluno = nomeAluno;
            return true;
        }
        return false;
    }

    public int getCodigoAluno() {
        return this.codigoAluno;
    }

    public String getNomeAluno() {
        return this.nomeAluno;
    }

    public double getRendimentoGlobal() {
        return this.rendimentoGlobal;
    }

    
    public void setRendimentoGlobal(double novaNota) {
        if (novaNota >= 0.0 && novaNota <= 100.0) {
            this.rendimentoGlobal = novaNota;
        } else {
            throw new IllegalArgumentException("Nota inválida! O valor deve estar entre 0.0 e 100.0. Valor informado: " + novaNota);
        }
    }
}

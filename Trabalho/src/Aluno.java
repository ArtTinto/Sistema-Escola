package escola;

public class Aluno {
    private static long qtdAlunos = 0;
    private long codigoAluno;
    private String nome;
    private String cpf;
    private float rg;
    private Matricula matricula;

    private Aluno(String nome, String cpf) {
        if (nome != null && !nome.isEmpty() && cpf != null && !cpf.isEmpty()) {
            Aluno.qtdAlunos++;
            this.codigoAluno = Aluno.qtdAlunos;
            this.nome = nome;
            this.cpf = cpf;
        }
    }

    private Aluno(Aluno outro) {
        if (outro != null) {
            this.codigoAluno = outro.codigoAluno;
            this.nome = outro.nome;
            this.cpf = outro.cpf;
            this.rg = outro.rg;
            this.matricula = outro.matricula;
        }
    }

    public static Aluno getInstance(String nome, String cpf) {
        return new Aluno(nome, cpf);
    }

    public static Aluno getInstance(Aluno outro) {
        return new Aluno(outro);
    }

    public void alterar(String nome) {
        this.nome = nome;
    }

    public float getRg() {
        return rg;
    }

    public void setRg(float rg) {
        this.rg = rg;
    }

    public long getCodigoAluno() {
        return codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public Matricula getMatricula() {
        return Matricula.getInstance(matricula);
    }

    public boolean verificaNomeigual(String nome) {
        if (nome != null) {
            if (nome.equals(this.nome)) {
                return true;
            }
        }
        return false;
    }
}

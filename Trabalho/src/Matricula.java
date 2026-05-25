import java.sql.Date;

public class Matricula {
    private Date dataMatricula; 
    private Aluno aluno;

    public Matricula(Date dataMatricula, Aluno aluno) {
       
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno não pode ser nulo para criar uma matrícula.");
        }
        
     
        if (dataMatricula == null) {
            throw new IllegalArgumentException("A data da matrícula não pode ser nula.");
        }

        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return this.dataMatricula;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

  
    public void setDataMatricula(Date dataMatricula) {
        if (dataMatricula == null) {
            throw new IllegalArgumentException("A nova data da matrícula não pode ser nula.");
        }
        this.dataMatricula = dataMatricula;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("O aluno da matrícula não pode ser nulo.");
        }
        this.aluno = aluno;
    }
}

    private Date dataMatricula;
    private Aluno aluno;
    private Turma turma;

    private Matricula(Date dataMatricula, Aluno aluno) {
        this.dataMatricula = dataMatricula;
        this.aluno = aluno;
    }

    private Matricula(Matricula outro) {
        if (outro != null) {
            this.dataMatricula = outro.getDataMatricula();
            this.aluno = outro.aluno;
            this.turma = outro.turma;
        }
    }

    public static Matricula getInstance(Date dataMatricula, Aluno aluno) {
        return new Matricula(dataMatricula, aluno);
    }

    public static Matricula getInstance(Matricula outro) {
        return new Matricula(outro);
    }

    public Date getDataMatricula() {
        return this.dataMatricula;
    }

    public Aluno getAluno() {
        return Aluno.getInstance(aluno);
    }

    public Turma getTurma() {
        return Turma.getInstance(turma);
    }

    public void setTurma(Turma turma) {
        if (turma != null) {
            this.turma = turma;
        }
    }
}
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

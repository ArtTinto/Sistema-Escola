package escola;

import java.util.Random;

public class Turma {
    private static long qtdTurmas = 0;
    private long id;
    private int ano;
    private int qtdVagas;
    private Disciplina disciplinas[];
    private Matricula matriculas[];

    private Turma(int ano, int qtdVagas, int qtdDisciplinas) {
        if (ano > 2000 && ano < 2100 && qtdVagas >= 10 && qtdDisciplinas > 0) {
            Turma.qtdTurmas++;
            id = qtdTurmas;
            this.ano = ano;
            this.qtdVagas = qtdVagas;
            disciplinas = new Disciplina[qtdDisciplinas];
            matriculas = new Matricula[qtdVagas];
        }
    }

    private Turma(Turma outro) {
        if (outro != null) {
            this.id = outro.id;
            this.ano = outro.ano;
            this.qtdVagas = outro.qtdVagas;
            this.disciplinas = outro.clonaDisciplinas();
            this.matriculas = outro.clonaMatriculas();
        }
    }

    public static Turma getInstance(int ano, int qtdVagas, int qtdDisciplinas) {
        return new Turma(ano, qtdVagas, qtdDisciplinas);
    }

    public static Turma getInstance(Turma outro) {
        return new Turma(outro);
    }

    public void alterar(int qtdVagas, int ano, int qtdDisciplinas) {
        if (qtdVagas > this.qtdVagas && ano > 2000 && ano < 2100 && qtdDisciplinas > disciplinas.length) {
            this.qtdVagas = qtdVagas;
            this.ano = ano;

            Disciplina[] novoDisciplinas = new Disciplina[qtdDisciplinas];
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null) {
                    novoDisciplinas[i] = disciplinas[i];
                }
            }
            this.disciplinas = novoDisciplinas;

            Matricula[] novoMatriculas = new Matricula[qtdVagas];
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null) {
                    novoMatriculas[i] = matriculas[i];
                }
            }
            this.matriculas = novoMatriculas;
        }
    }

    public Disciplina buscaDisciplina(long id) {
        if (id > 0) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getId() == id) {
                    return disciplinas[i];
                }
            }
        }
        return null;
    }

    public Matricula buscaAluno(long codigoAluno) {
        if (codigoAluno > 0) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null && matriculas[i].getAluno().getCodigoAluno() == codigoAluno) {
                    return matriculas[i];
                }
            }
        }
        return null;
    }

    public boolean addDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null && disciplinas[i].getId() == disciplina.getId()) {
                    return false;
                }
            }

            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] == null) {
                    disciplinas[i] = disciplina;
                    Random random = new Random();

                    for (int j = 0; j < matriculas.length; j++) {
                        if (matriculas[j] != null) {
                            float notaValor = random.nextFloat() * 100;
                            Nota.getInstance(disciplina, matriculas[j], notaValor);
                            
                            float novoRg = matriculas[j].getAluno().getRg();
                            novoRg = (novoRg + notaValor) / disciplinas.length;
                            matriculas[j].atualizaRg(novoRg);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addMatricula(Matricula matricula) {
        if (matricula != null) {
            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] != null
                        && matriculas[i].getAluno().getNome().equals(matricula.getAluno().getNome())) {
                    return false;
                }
            }

            for (int i = 0; i < matriculas.length; i++) {
                if (matriculas[i] == null) {
                    Random random = new Random();
                    matriculas[i] = matricula;
                    matricula.setTurma(this);

                    float somaNotas = 0;
                    int qtdDisciplinas = 0;

                    for (int j = 0; j < disciplinas.length; j++) {
                        if (disciplinas[j] != null) {
                            float notaValor = random.nextFloat() * 100;
                            Nota.getInstance(disciplinas[j], matricula, notaValor);
                            somaNotas += notaValor;
                            qtdDisciplinas++;
                        }
                    }

                    if (qtdDisciplinas > 0) {
                        matriculas[i].atualizaRg(somaNotas / qtdDisciplinas);
                    } else {
                        matriculas[i].atualizaRg(0f);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public Disciplina[] getDisciplinas() {
        return clonaDisciplinas();
    }

    public Matricula[] getMatriculas() {
        return clonaMatriculas();
    }

    private Disciplina[] clonaDisciplinas() {
        Disciplina[] cloneDisciplinas = new Disciplina[disciplinas.length];
        for (int i = 0; i < cloneDisciplinas.length; i++) {
            cloneDisciplinas[i] = disciplinas[i];
        }
        return cloneDisciplinas;
    }

    private Matricula[] clonaMatriculas() {
        Matricula[] cloneMatriculas = new Matricula[matriculas.length];
        for (int i = 0; i < cloneMatriculas.length; i++) {
            cloneMatriculas[i] = matriculas[i];
        }
        return cloneMatriculas;
    }
}

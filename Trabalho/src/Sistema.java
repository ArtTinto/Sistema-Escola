public class Sistema {
    private static Sistema sistema;
    private static Aluno[] allAlunos;
    private static Disciplina[] allDisciplinas;
    private static Turma[] allTurmas;

    private Sistema() {
        allAlunos = new Aluno[80];
        allDisciplinas = new Disciplina[30];
        allTurmas = new Turma[10];
    }

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }

    public boolean addDisciplina(Disciplina disciplina) {
        for (int i = 0; i < allDisciplinas.length; i++) {
            if (allDisciplinas[i] == null) {
                allDisciplinas[i] = disciplina;
                return true;
            }
        }
        return false;
    }

    public boolean addAluno(Aluno aluno) {
        for (int i = 0; i < allAlunos.length; i++) {
            if (allAlunos[i] == null) {
                allAlunos[i] = aluno;
                return true;
            }
        }
        return false;
    }

    public boolean addTurma(Turma turma) {
        for (int i = 0; i < allTurmas.length; i++) {
            if (allTurmas[i] == null) {
                allTurmas[i] = turma;
                return true;
            }
        }
        return false;
    }

    public Aluno buscaAluno(long codigoAluno) {
        if (codigoAluno > 0) {
            for (int i = 0; i < allAlunos.length; i++) {
                if (allAlunos[i] != null && allAlunos[i].getCodigoAluno() == codigoAluno) {
                    return allAlunos[i];
                }
            }
        }
        return null;
    }

    public Turma buscaTurma(long idTurma) {
        if (idTurma > 0) {
            for (int i = 0; i < allTurmas.length; i++) {
                if (allTurmas[i] != null && allTurmas[i].getId() == idTurma) {
                    return allTurmas[i];
                }
            }
        }
        return null;
    }

    public Disciplina buscaDisciplina(long idDisiciplina) {
        if (idDisiciplina > 0) {
            for (int i = 0; i < allDisciplinas.length; i++) {
                if (allDisciplinas[i] != null && allDisciplinas[i].getId() == idDisiciplina) {
                    return allDisciplinas[i];
                }
            }
        }
        return null;
    }

    public boolean removeAluno(Aluno aluno) {
        if (aluno != null) {
            for (int i = 0; i < allAlunos.length; i++) {
                if (allAlunos[i] != null && allAlunos[i].getCodigoAluno() == aluno.getCodigoAluno()) {
                    if (aluno.getMatricula() != null) {
                        for (int j = i; j < allAlunos.length - 1; j++) {
                            allAlunos[j] = allAlunos[j + 1];
                        }
                        allAlunos[allAlunos.length - 1] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            for (int i = 0; i < allDisciplinas.length; i++) {
                if (allDisciplinas[i] != null && allDisciplinas[i].getId() == disciplina.getId()) {
                    allDisciplinas[allDisciplinas.length - 1] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeTurma(Turma turma) {
        if (turma != null) {
            for (int i = 0; i < allTurmas.length; i++) {
                if (allTurmas[i] != null && allTurmas[i].getId() == turma.getId()) {
                    Matricula[] matriculas = turma.getMatriculas();
                    for (int j = 0; j < matriculas.length; j++) {
                        if (matriculas[j] != null) {
                            for (int k = i; k < allTurmas.length - 1; k++) {
                                allTurmas[k] = allTurmas[k + 1];
                            }
                            allTurmas[allTurmas.length - 1] = null;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void printaDisiciplinas(int larguraColuna) {
        if (larguraColuna < 40 || larguraColuna > 100) {
            System.out.println("Largura inválida");
            return;
        }

        int larguraTotal = 18 + (larguraColuna * 2);

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.printf(
                "| %-8s | %-" + larguraColuna + "." + larguraColuna + "s | %-" + larguraColuna + "."
                        + larguraColuna + "s |\n",
                "CÓDIGO", "NOME DA DISCIPLINA", "PROFESSOR");

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < allDisciplinas.length; i++) {
            if (allDisciplinas[i] != null) {
                System.out.printf(
                        "| %-8d | %-" + larguraColuna + "." + larguraColuna + "s | %-" + larguraColuna
                                + "." + larguraColuna + "s |\n",
                        allDisciplinas[i].getId(),
                        allDisciplinas[i].getNomeDisciplina(),
                        allDisciplinas[i].getNomeProfessor());

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void printaTurmas(int larguraColuna) {
        if (larguraColuna < 40 || larguraColuna > 100) {
            System.out.println("Largura inválida");
            return;
        }

        int larguraTotal = 18 + (larguraColuna * 2);
        int larguraConteudo = larguraTotal - 4;

        for (int i = 0; i < allTurmas.length; i++) {
            if (allTurmas[i] != null) {
                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                System.out.printf("| %-10s | %-10s | %-" + (larguraConteudo - 24) + "s |\n", "ID TURMA", "ANO",
                        "VAGAS TOTAIS");

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                System.out.printf("| %-10d | %-10d | %-" + (larguraConteudo - 24) + "d |\n",
                        allTurmas[i].getId(),
                        allTurmas[i].getAno(),
                        allTurmas[i].getQtdVagas());

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                System.out.printf("| %-" + larguraConteudo + "s |\n", "DISCIPLINAS DA TURMA");
                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                Disciplina[] discs = allTurmas[i].getDisciplinas();
                boolean temDisciplina = false;
                for (int j = 0; j < discs.length; j++) {
                    if (discs[j] != null) {
                        System.out.printf("| - %-" + (larguraConteudo - 4) + "s |\n", discs[j].getNomeDisciplina());
                        temDisciplina = true;
                    }
                }
                if (!temDisciplina) {
                    System.out.printf("| %-" + larguraConteudo + "s |\n", "Nenhuma disciplina cadastrada.");
                }

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                System.out.printf("| %-" + larguraConteudo + "s |\n", "ALUNOS MATRICULADOS");
                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();

                Matricula[] mats = allTurmas[i].getMatriculas();
                boolean temAluno = false;
                for (int j = 0; j < mats.length; j++) {
                    if (mats[j] != null && mats[j].getAluno() != null) {
                        System.out.printf("| - %-" + (larguraConteudo - 4) + "s |\n", mats[j].getAluno().getNome());
                        temAluno = true;
                    }
                }
                if (!temAluno) {
                    System.out.printf("| %-" + larguraConteudo + "s |\n", "Nenhum aluno matriculado.");
                }

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.println();
            }
        }
    }

    public void printaAlunos(int larguraColuna) {
        if (larguraColuna < 40 || larguraColuna > 100) {
            System.out.println("Largura inválida");
            return;
        }

        int larguraTotal = 18 + (larguraColuna * 2);
        int larguraNome = larguraTotal - 15;

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.printf("| %-10s | %-" + larguraNome + "." + larguraNome + "s |\n", "MATRÍCULA", "NOME DO ALUNO");

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < allAlunos.length; i++) {
            if (allAlunos[i] != null) {
                System.out.printf("| %-10d | %-" + larguraNome + "." + larguraNome + "s |\n",
                        allAlunos[i].getCodigoAluno(),
                        allAlunos[i].getNome());

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void innit() {
        java.util.Random random = new java.util.Random();

        String[] arrNomeDisciplinas = {
                "BANCO DE DADOS",
                "ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES",
                "INTEGRAÇÃO E SÉRIES",
                "PROGRAMAÇÃO ORIENTADA A OBETO",
                "GEOMETRIA ANALÍTA E ÁLGEBRA LINEAR"
        };

        String[] arrDocentes = {
                "MARCELO BALBINO",
                "BRUNO",
                "MATEUS",
                "LUCIANO",
                "JOSÉ JOZELMO"
        };

        int limiteDisc = 5;
        Disciplina[] disciplinasCriadas = new Disciplina[3];

        for (int i = 0; i < 3; i++) {
            int sorteado = random.nextInt(limiteDisc);

            Disciplina disc = Disciplina.getInstance(arrNomeDisciplinas[sorteado], arrDocentes[sorteado]);
            addDisciplina(disc);
            disciplinasCriadas[i] = disc;

            for (int j = sorteado; j < limiteDisc - 1; j++) {
                arrNomeDisciplinas[j] = arrNomeDisciplinas[j + 1];
                arrDocentes[j] = arrDocentes[j + 1];
            }
            limiteDisc--;
        }

        Turma turma = Turma.getInstance(2026, 40, 5);

        for (int i = 0; i < disciplinasCriadas.length; i++) {
            if (disciplinasCriadas[i] != null) {
                turma.addDisciplina(disciplinasCriadas[i]);
            }
        }
        addTurma(turma);

        String[] nomesAlu = { "RENATO", "VITOR", "ARTHUR", "THALES", "YURI" };
        int limiteAlu = 5;

        for (int i = 0; i < 5; i++) {
            int sorteado = random.nextInt(limiteAlu);
            String nome = nomesAlu[sorteado];
            String cpf = "0001112223" + i;

            Aluno aluno = Aluno.getInstance(nome, cpf);
            addAluno(aluno);

            Matricula matricula = Matricula.getInstance(new java.sql.Date(System.currentTimeMillis()), aluno);
            turma.addMatricula(matricula);

            for (int j = sorteado; j < limiteAlu - 1; j++) {
                nomesAlu[j] = nomesAlu[j + 1];
            }
            limiteAlu--;
        }
    }

    // Funções de controle
    private Aluno[] expandirVetorAlunos() {
        Aluno[] novoVetor = new Aluno[allAlunos.length * 2];

        for (int i = 0; i < allAlunos.length; i++) {
            novoVetor[i] = allAlunos[i];
        }

        return novoVetor;
    }

    private Disciplina[] expandirVetorDisciplinas() {
        Disciplina[] novoVetor = new Disciplina[allDisciplinas.length + 10];

        for (int i = 0; i < allDisciplinas.length; i++) {
            novoVetor[i] = allDisciplinas[i];
        }

        return novoVetor;
    }

    private Turma[] expandirVetorTurmas() {
        Turma[] novoVetor = new Turma[allTurmas.length + 5];

        for (int i = 0; i < allTurmas.length; i++) {
            novoVetor[i] = allTurmas[i];
        }

        return novoVetor;
    }

    public Turma[] getTurmas() {
        Turma[] nTurmas = new Turma[allTurmas.length];
        for (int i = 0; i < allTurmas.length; i++) {
            if (allTurmas[i] != null) {
                nTurmas[i] = Turma.getInstance(allTurmas[i]);
            }
        }
        return nTurmas;
    }

}
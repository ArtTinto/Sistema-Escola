package escola;

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
                    if (aluno.getMatricula() == null) {
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
                    if (matriculas[0] != null) {
                        return false;
                    } else {
                        for (int k = i; k < allTurmas.length - 1; k++) {
                            allTurmas[k] = allTurmas[k + 1];
                        }
                        allTurmas[allTurmas.length - 1] = null;
                        return true;

                    }
                }
            }
        }
        return false;
    }

    public void printaDisiciplinas(int larguraColuna) {
        if (larguraColuna < 40 || larguraColuna > 80) {
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
        if (larguraColuna < 40 || larguraColuna > 80) {
            System.out.println("Largura inválida");
            return;
        }

        int larguraTotal = 18 + (larguraColuna * 2);
        int larguraConteudo = larguraTotal - 4;

        for (int i = 0; i < allTurmas.length; i++) {
            if (allTurmas[i] != null) {
                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                int colId = 10;
                int colAno = 10;
                int colVagas = larguraConteudo - colId - colAno - 6;

                System.out.printf(
                        "| %-" + colId + "." + colId + "s | %-" + colAno + "." + colAno + "s | %-" + colVagas + "."
                                + colVagas + "s |\n",
                        "ID TURMA", "ANO", "VAGAS TOTAIS");

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                System.out.printf("| %-" + colId + "d | %-" + colAno + "d | %-" + colVagas + "d |\n",
                        allTurmas[i].getId(),
                        allTurmas[i].getAno(),
                        allTurmas[i].getQtdVagas());

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                System.out.printf("| %-" + larguraConteudo + "." + larguraConteudo + "s |\n", "DISCIPLINAS DA TURMA");
                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                Disciplina[] discs = allTurmas[i].getDisciplinas();
                boolean temDisciplina = false;
                for (int j = 0; j < discs.length; j++) {
                    if (discs[j] != null) {
                        int largDisc = larguraConteudo - 4;
                        System.out.printf("| - %-" + largDisc + "." + largDisc + "s |\n", discs[j].getNomeDisciplina());
                        temDisciplina = true;
                    }
                }
                if (!temDisciplina) {
                    System.out.printf("| %-" + larguraConteudo + "." + larguraConteudo + "s |\n",
                            "Nenhuma disciplina cadastrada.");
                }

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                System.out.printf("| %-" + larguraConteudo + "." + larguraConteudo + "s |\n", "ALUNOS MATRICULADOS");
                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                Matricula[] mats = allTurmas[i].getMatriculas();
                boolean temAluno = false;

                int larguraMat = 10;
                int larguraMed = 10;
                int larguraNome = larguraConteudo - larguraMat - larguraMed - 6;

                System.out.printf(
                        "| %-" + larguraMat + "." + larguraMat + "s | %-" + larguraNome + "." + larguraNome + "s | %-"
                                + larguraMed + "." + larguraMed + "s |\n",
                        "MATRÍCULA", "NOME", "MÉDIA(RG)");

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();

                for (int j = 0; j < mats.length; j++) {
                    if (mats[j] != null && mats[j].getAluno() != null) {
                        Aluno a = mats[j].getAluno();
                        System.out.printf(
                                "| %-" + larguraMat + "d | %-" + larguraNome + "." + larguraNome + "s | %-" + larguraMed
                                        + ".2f |\n",
                                a.getCodigoAluno(), a.getNome(), a.getRg());
                        temAluno = true;
                    }
                }
                if (!temAluno) {
                    System.out.printf("| %-" + larguraConteudo + "." + larguraConteudo + "s |\n",
                            "Nenhum aluno matriculado.");
                }

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
                System.out.println();
                System.out.println();
            }
        }
    }

    public void printaAlunos(int larguraColuna) {
        if (larguraColuna < 40 || larguraColuna > 80) {
            System.out.println("Largura inválida");
            return;
        }

        int larguraTotal = 18 + (larguraColuna * 2);
        int larguraMatricula = 10;
        int larguraMedia = 10;

        int larguraNome = larguraTotal - larguraMatricula - larguraMedia - 10;

        for (int i = 0; i < larguraTotal; i++)
            System.out.print("-");
        System.out.println();

        System.out.printf(
                "| %-" + larguraMatricula + "s | %-" + larguraNome + "." + larguraNome + "s | %-" + larguraMedia
                        + "s |\n",
                "MATRÍCULA", "NOME DO ALUNO", "MÉDIA (RG)");

        for (int i = 0; i < larguraTotal; i++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < allAlunos.length; i++) {
            if (allAlunos[i] != null) {
                System.out.printf(
                        "| %-" + larguraMatricula + "d | %-" + larguraNome + "." + larguraNome + "s | %-" + larguraMedia
                                + ".2f |\n",
                        allAlunos[i].getCodigoAluno(),
                        allAlunos[i].getNome(),
                        allAlunos[i].getRg());

                for (int j = 0; j < larguraTotal; j++)
                    System.out.print("-");
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

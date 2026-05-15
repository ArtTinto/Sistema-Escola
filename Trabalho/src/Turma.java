public class Turma {
    private int ano;
    private int qtdVagas;
    private Disciplina disciplinas[];
    private Matricula matriculas[];

    public Turma(int ano, int qtdVagas, int qtdDisciplinas, int qtdMatriculas) {
        if (ano > 2000 && ano < 2100 && qtdVagas >= 10 && qtdDisciplinas > 0 && qtdMatriculas > 0) {
            this.ano = ano;
            this.qtdVagas = qtdVagas;
            disciplinas = new Disciplina[qtdDisciplinas];
            matriculas = new Matricula[qtdMatriculas];
        }
    }

    public void printaDisiciplinas(int larguraColuna) {
        if (larguraColuna >= 40 || larguraColuna <= 100) {
            System.out.println("Largura inválida");
            return;
        }

        // Cálculo da largura total fixa para as bordas
        int larguraTotal = (larguraColuna * 2) + 10 + 7 + 5 + 16;

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.printf(
                "| %-10s | %-" + larguraColuna + "." + larguraColuna + "s | %-7s | %-5s | %-" + larguraColuna + "."
                        + larguraColuna + "s |\n",
                "CÓDIGO", "NOME", "SIGLA", "ANO", "PROFESSOR");

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null) {
                // Garante que o texto não ultrapasse a largura configurada
                System.out.printf(
                        "| %-10d | %-" + larguraColuna + "." + larguraColuna + "s | %-7s | %-5d | %-" + larguraColuna
                                + "." + larguraColuna + "s |\n",
                        disciplinas[i].getIdDisciplina(),
                        disciplinas[i].getNomeDisciplina(),
                        disciplinas[i].getNomeProfessor(),
                        qtdVagas,
                        ano);

                for (int j = 0; j < larguraTotal; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public boolean addDisciplina(Disciplina disciplina) {
        // Função para adicionar as disciplinas no array de disciplinas Ex:
        // disciplinas[0] = "Banco de dados"; "BD"; ...
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] == null) {
                disciplinas[i] = disciplina;

                return true;
            }
        }
        return false;
    }

    public int getAno() {
        return ano;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public Matricula[] getMatriculas() {
        return matriculas;
    }
}
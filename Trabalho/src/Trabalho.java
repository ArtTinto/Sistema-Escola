import java.util.Scanner;

public class Trabalho {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int escolha;

        Disciplina allDisiciplinas[] = new Disciplina[100];

        do {
            int innerEscolha; // Inicia a variável a cada ciclo

            System.out.println("\nDigite 0 para Sair");
            System.out.println("Digite 1 para Cadastrar");
            System.out.println("Digite 2 para Consultar");
            System.out.println("Digite 3 para Atualizar");
            System.out.println("Digite 4 para Deletar");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Adicionar um aluno ou disciplinas
                    do {
                        System.out.println("\nDigite 0 voltar");
                        System.out.println("Digite 1 para o cadastro de Disiciplinas");
                        System.out.println("Digite 2 para o cadastro de Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        Disciplina dadosDisciplina = dadosDisciplina();

                        addDisciplina(allDisiciplinas, dadosDisciplina);
                    } else if (innerEscolha == 2) {

                    }

                    break;

                case 2:
                    // Consultar os alunos ou Disciplinas
                    do {
                        System.out.println("\nDigite 0 voltar");
                        System.out.println("Digite 1 para o consultar as Disiciplinas");
                        System.out.println("Digite 2 para os alunos de Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                    } else if (innerEscolha == 2) {

                    }

                    break;

                case 3:
                    //
                    break;

                case 4:
                    break;

                default:
                    break;
            }

        } while (escolha != 0);
        // Como o
    }

    static Disciplina dadosDisciplina() {
        Disciplina cadDisiciplina = new Disciplina();

        cadDisiciplina.codigoDisiciplina++;

        scanner.nextLine();

        System.out.println("Digite o nome da disciplina");
        cadDisiciplina.nomeDisciplina = scanner.nextLine();

        System.out.println("Digite a sigla");
        cadDisiciplina.sigla = scanner.nextLine();

        System.out.println("Digite o ano da disciplina");
        cadDisiciplina.anoDisciplina = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o nome do Docente");
        cadDisiciplina.nomeProfessor = scanner.nextLine();

        return cadDisiciplina;
    }

    static boolean addDisciplina(Disciplina[] arrDisciplinas, Disciplina objeto) {
        if (arrDisciplinas != null) {
            for (int i = 0; i < arrDisciplinas.length; i++) {
                if (arrDisciplinas[i] == null) {
                    arrDisciplinas[i] = objeto;

                    return true;
                }
            }
        }

        return false;
    }

    static void printaDisiciplinas(Disciplina[] disciplinas) {
        if (disciplinas != null) {
            for (int i = 0; i < disciplinas.length; i++) {
                if (disciplinas[i] != null) {

                    System.out.println("\nCodigo da Disciplina: " + disciplinas[i].codigoDisiciplina);

                    System.out.println("\nNome: " + disciplinas[i].nomeDisciplina);

                    System.out.println("\nSigla: " + disciplinas[i].sigla);

                    System.out.println("\nAno disciplina: " + disciplinas[i].anoDisciplina);

                    System.out.println("\nNome do Professor: " + disciplinas[i].nomeProfessor);

                    System.out.println();
                }
            }
        }
    }

    static void removeDisiciplina(int posicao, Disciplina[] disciplinas) {
        if (disciplinas == null) {
            System.out.println("Não há disciplinas cadastradas, impossível remover");
            return;
        }

        if (posicao > disciplinas.length || posicao < 0) {
            System.out.println("Impossível remover, posição inexistente");
            return;
        }

        if (disciplinas[posicao - 1] == null) {
            System.out.println("Impossível remover, essa disciplina não existe");
            return;
        }

        disciplinas[posicao - 1] = null;

        for (int i = posicao; i < disciplinas.length - 1; i++) {
            disciplinas[i] = disciplinas[i + 1];
        }

        disciplinas[disciplinas.length - 1] = null;

        System.out.println("Disciplina removida com sucesso!");
    }

    static void alterarDisciplina(int posicao, Disciplina[] disciplinas) {
        if (disciplinas == null) {
            System.out.println("Não há disciplinas cadastradas, impossível remover");
            return;
        }

        if (posicao > disciplinas.length || posicao < 0) {
            System.out.println("Impossível remover, posição inexistente");
            return;
        }

        if (disciplinas[posicao - 1] == null) {
            System.out.println("Impossível remover, essa disciplina não existe");
            return;
        }

        disciplinas[posicao - 1] = null;

        for (int i = posicao; i < disciplinas.length - 1; i++) {
            disciplinas[i] = disciplinas[i + 1];
        }

        disciplinas[disciplinas.length - 1] = dadosDisciplina();

        System.out.println("Disciplina alterada com sucesso!");
    }

}
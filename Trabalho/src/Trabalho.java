import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                        Disciplina dadosDisciplina = dadosDisciplina(scanner);

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

    static Disciplina dadosDisciplina(Scanner scanner) {
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

                    System.out.println("Candidato: " + disciplinas[i].codigoDisiciplina);

                    System.out.println("Nome: " + disciplinas[i].nomeDisciplina);

                    System.out.println("Sigla: " + disciplinas[i].sigla);

                    System.out.println("Ano disciplina: " + disciplinas[i].anoDisciplina);

                    System.out.println("Nome do Professor: " + disciplinas[i].nomeProfessor);

                    System.out.println();
                }
            }
        }
    }
}
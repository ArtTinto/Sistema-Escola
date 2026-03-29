import java.util.Random;
import java.util.Scanner;

public class Trabalho {

    static int contador = 1;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();

        int escolha;

        Disciplina allDisiciplinas[] = new Disciplina[100];

        innit(random, allDisiciplinas);

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
                    printaDisiciplinas(allDisiciplinas);

                    System.out.println("\nDigite o número da disciplina que quer alterar: ");
                    innerEscolha = scanner.nextInt();

                    alterarDisciplina(innerEscolha, allDisiciplinas);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("\nOpção inválida\n");
                    break;
            }

        } while (escolha != 0);
        // Como o
    }

    static Disciplina dadosDisciplina() {
        // Função para receber os dados das disciplinas
        Disciplina cadDisiciplina = new Disciplina();

        cadDisiciplina.codigoDisiciplina = contador++;

        scanner.nextLine();

        System.out.println("\nDigite o nome da disciplina");
        cadDisiciplina.nomeDisciplina = scanner.nextLine();

        System.out.println("\nDigite a sigla");
        cadDisiciplina.sigla = scanner.nextLine();

        System.out.println("\nDigite o ano da disciplina");
        cadDisiciplina.anoDisciplina = scanner.nextInt();

        scanner.nextLine();

        System.out.println("\nDigite o nome do Docente");
        cadDisiciplina.nomeProfessor = scanner.nextLine();

        return cadDisiciplina;
    }

    static boolean addDisciplina(Disciplina[] arrDisciplinas, Disciplina objeto) {
        // Função para adicionar as disciplinas no array de disciplinas Ex
        // disciplinas[0] = "Banco de dados"; "BD"; ...
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
        // Funcao para o Read do CRUD

        for (int i = 0; i < 123; i++) {
            System.out.print(
                    "-");
        }
        System.out.println();

        System.out.printf("| %-7s | %-50s | %-10s | %-5s | %-35s |\n",
                "Codígo", "Disciplina", "Sigla", "Ano", "Docente");

        for (int i = 0; i < 123; i++) {
            System.out.print(
                    "-");
        }
        System.out.println();

        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null) {

                System.out.printf("| %-7d | %-50s | %-10s | %-5d | %-35s |\n",
                        disciplinas[i].codigoDisiciplina,
                        disciplinas[i].nomeDisciplina,
                        disciplinas[i].sigla,
                        disciplinas[i].anoDisciplina,
                        disciplinas[i].nomeProfessor);

                for (int j = 0; j < 123; j++) {
                    System.out.print(
                            "-");
                }
                System.out.println();
            }
        }
    }

    static void alterarDisciplina(int posicao, Disciplina[] disciplinas) {
        //
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

        disciplinas[posicao - 1] = dadosDisciplina();

        System.out.println("\nDisciplina alterada com sucesso !!");
    }

    static void innit(Random random, Disciplina[] disciplinas) {
        // Inicializa o vetor de disciplinas com 3 disciplinas que não se repetem com
        // seus dados sempre fixos exceto o ano que varia por execução e pode repetir
        String[] nomeDisciplina = { "Banco de Dados", "Arquitetura e Organização de Computadores",
                "Integração e Séries", "Programação Orientada a Obeto", "Geometria Analíta e Álgebra Linear" };

        String[] sigla = { "BD", "AOC", "IS", "POO", "GAAL" };

        int[] ano = { 2023, 2024, 2025, 2026 };

        String[] docente = { "Marcelo Balbino", "Bruno", "Mateus", "Luciano", "José Jozelmo" };

        for (int i = 0; i < 3; i++) {
            Disciplina objeto = new Disciplina();

            int sorteado = random.nextInt(5 - i);

            objeto.codigoDisiciplina = contador++;

            objeto.nomeDisciplina = nomeDisciplina[sorteado];

            objeto.sigla = sigla[sorteado];

            objeto.anoDisciplina = ano[random.nextInt(4)];

            objeto.nomeProfessor = docente[sorteado];

            for (int j = sorteado; j < nomeDisciplina.length - 1; j++) {
                nomeDisciplina[j] = nomeDisciplina[j + 1];

                sigla[j] = sigla[j + 1];

                docente[j] = docente[j + 1];
            }

            disciplinas[i] = objeto;
        }

    }
}
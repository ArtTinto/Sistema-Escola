
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int escolha;
        int larguraColuna = 40;
        Scanner scanner = new Scanner(System.in);

        Sistema sis = Sistema.getInstance();

        sis.innit();

        do {
            // if (allAlunos[allAlunos.length - 1] != null) {
            // allAlunos = expandirVetorAlunos(allAlunos);
            // }

            // if (allDisiciplinas[allDisiciplinas.length - 1] != null) {
            // allDisiciplinas = expandirVetorDisciplinas(allDisiciplinas);
            // }

            System.out.println("\n============================================");
            System.out.println("|           SISTEMA DE MATRÍCULAS          |");
            System.out.println("============================================");
            System.out.println("| [1] Cadastrar (Disciplina/Aluno/Turma)   |");
            System.out.println("| [2] Consultar (Listagens)                |");
            System.out.println("| [3] Atualizar (Editar Dados)             |");
            System.out.println("| [4] Deletar   (Remover Dados)            |");
            System.out.println("| [5] Cadastrar Disciplina em Turma        |");
            System.out.println("| [6] Matricular Aluno em Turma            |");
            System.out.println("| [7] Configurar Largura das Colunas       |");
            System.out.println("| [0] Sair do Programa                     |");
            System.out.println("============================================");
            System.out.print("Sua opção > ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    System.exit(0);
                    break;

                case 1:
                    // Cadastra novos alunos e disciplinas
                    System.out.println("\n---------- SUBMENU: CADASTRO ----------");
                    System.out.println("| [1] Nova Disciplina                 |");
                    System.out.println("| [2] Novo Aluno                      |");
                    System.out.println("| [3] Nova Turma                      |");
                    System.out.println("| [0] Voltar ao Menu Principal        |");
                    System.out.println("---------------------------------------");
                    System.out.print("Opção > ");
                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 0:
                            escolha= -1;
                            break;
                        case 1:
                            scanner.nextLine();
                            System.out.println("Qual é o nome da Disciplina");
                            String nomeDisciplina = scanner.nextLine();

                            System.out.println("Qual é o nome do Docente");
                            String nomeProfessor = scanner.nextLine();

                            Disciplina disciplina = Disciplina.getInstance(nomeDisciplina, nomeProfessor);

                            sis.addDisciplina(disciplina);
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("Qual é o nome do Aluno");
                            String nomeAluno = scanner.nextLine();

                            System.out.println("Qual é o CPF");
                            String cpf = scanner.nextLine();

                            Aluno aluno = Aluno.getInstance(nomeAluno, cpf);

                            sis.addAluno(aluno);
                            break;
                        case 3:
                            System.out.println("Qual o ano da disciplina");
                            int ano = scanner.nextInt();

                            System.out.println("Qual a quantidade de vagas");
                            int vagas = scanner.nextInt();

                            System.out.println("Qual a quantidade de disciplinas");
                            int qtdDisciplinas = scanner.nextInt();

                            Turma turma = Turma.getInstance(ano, vagas, qtdDisciplinas);

                            sis.addTurma(turma);
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 2:
                    // Printa a tabela de alunos e disciplinas
                    System.out.println("\n---------- SUBMENU: CONSULTA ----------");
                    System.out.println("| [1] Listar Disciplinas               |");
                    System.out.println("| [2] Listar Alunos                    |");
                    System.out.println("| [3] Listar Turmas                    |");
                    System.out.println("| [0] Voltar ao Menu Principal         |");
                    System.out.println("---------------------------------------");
                    System.out.print("Opção > ");
                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 0:
                            escolha=-1;
                            break;
                        case 1:
                            sis.printaDisiciplinas(larguraColuna);
                            break;
                        case 2:
                            sis.printaAlunos(larguraColuna);
                            break;
                        case 3:
                            sis.printaTurmas(larguraColuna);
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 3:
                    // Altera aluno ou disciplina
                    System.out.println("\n---------- SUBMENU: ATUALIZAÇÃO ----------");
                    System.out.println("| [1] Editar Disciplina                    |");
                    System.out.println("| [2] Editar Aluno                         |");
                    System.out.println("| [3] Editar Turma                         |");
                    System.out.println("| [0] Voltar ao Menu Principal             |");
                    System.out.println("------------------------------------------");
                    System.out.print("Opção > ");
                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 0:
                            escolha=-1;
                            break;
                        case 1:
                            sis.printaDisiciplinas(escolha);
                            System.out.print("\nDigite o CÓDIGO da disciplina para editar: ");
                            long id = scanner.nextLong();
                            Disciplina disc = sis.buscaDisciplina(id);

                            scanner.nextLine();
                            System.out.println("Digite o nome a ser alterado");
                            String nome = scanner.nextLine();

                            System.out.println("Digite o nome do Docente a ser alterado");
                            String nomeDocente = scanner.nextLine();
                            disc.alterar(nome, nomeDocente);
                            break;
                        case 2:
                            sis.printaAlunos(larguraColuna);
                            System.out.print("\nDigite a MATRÍCULA do aluno para editar: ");
                            long codigoAluno = scanner.nextInt();
                            Aluno aluno = sis.buscaAluno(codigoAluno);

                            scanner.nextLine();
                            System.out.println("Digite o nome para ser alterado");
                            nome = scanner.nextLine();
                            aluno.alterar(nome);
                            break;
                        case 3:
                            sis.printaTurmas(larguraColuna);
                            System.out.print("\nDigite o Id da Turma para editar: ");
                            id = scanner.nextInt();
                            Turma turma = sis.buscaTurma(id);

                            System.out.println("Digite a quantidade de vagas a ser alterada");
                            int qtdVagas = scanner.nextInt();

                            System.out.println("Digite o ano a ser alterado");
                            int ano = scanner.nextInt();

                            System.out.println("Digite a nova quantidade de disciplinas");
                            int qtdDisciplinas = scanner.nextInt();

                            turma.alterar(qtdVagas, ano, qtdDisciplinas);
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;

                case 4:
                    // Remove aluno ou Disciplina
                    System.out.println("\n---------- SUBMENU: EXCLUSÃO ----------");
                    System.out.println("| [1] Remover Disciplina                |");
                    System.out.println("| [2] Remover Aluno                     |");
                    System.out.println("| [3] Remover Turma                     |");
                    System.out.println("| [0] Voltar ao Menu Principal          |");
                    System.out.println("---------------------------------------");
                    System.out.print("Opção > ");
                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 0:
                            escolha=-1;
                            break;
                        case 1:
                            sis.printaDisiciplinas(larguraColuna);
                            System.out.print("\nDigite o CÓDIGO da disciplina para remover: ");
                            long idDisiciplina = scanner.nextLong();
                            Disciplina disciplina = sis.buscaDisciplina(idDisiciplina);

                            if (sis.removeDisciplina(disciplina)) {
                                System.out.println("Disciplina removida com sucesso !!!");
                            } else {
                                System.out.println("Disciplina não pode ser removida !!!");
                            }
                            break;
                        case 2:
                            sis.printaAlunos(larguraColuna);
                            System.out.print("\nDigite a MATRÍCULA do aluno para desmatricular: ");
                            long codigoAluno = scanner.nextLong();
                            Aluno aluno = sis.buscaAluno(codigoAluno);

                            if (sis.removeAluno(aluno)) {
                                System.out.println("Aluno removido com sucesso !!!");
                            } else {
                                System.out.println("Aluno não pode ser removido !!!");
                            }
                            break;
                        case 3:
                            sis.printaTurmas(larguraColuna);
                            System.out.print("\nDigite o ID da Turma para remover: ");
                            long idTurma = scanner.nextLong();
                            Turma turma = sis.buscaTurma(idTurma);

                            if (sis.removeTurma(turma)) {
                                System.out.println("Turma removida com sucesso !!!");
                            } else {
                                System.out.println("Turma não pode ser removida !!!");
                            }

                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                            break;
                    }
                    break;
                case 5:
                    // Matricular aluno em turma
                    sis.printaTurmas(larguraColuna);
                    System.out.print("\nDigite o ID da Turma: ");
                    long idTurma = scanner.nextLong();
                    Turma turma = sis.buscaTurma(idTurma);

                    sis.printaDisiciplinas(larguraColuna);
                    System.out.print("\nDigite o ID da disciplina para cadastrar: ");
                    long id = scanner.nextLong();
                    Disciplina disciplina = sis.buscaDisciplina(id);

                    turma.addDisciplina(disciplina);

                    break;
                case 6:
                    // Matricular aluno em turma
                    System.out.println("Qual a data de inscrição");
                    int data = scanner.nextInt();
                    Date dateMatricula = new Date(data);

                    sis.printaTurmas(larguraColuna);
                    System.out.print("\nDigite o ID da Turma: ");
                    idTurma = scanner.nextLong();
                    turma = sis.buscaTurma(idTurma);

                    sis.printaAlunos(larguraColuna);
                    System.out.print("\nDigite a MATRÍCULA do aluno para cadastrar: ");
                    long codigoAluno = scanner.nextLong();
                    Aluno aluno = sis.buscaAluno(codigoAluno);

                    Matricula matricula = Matricula.getInstance(dateMatricula, aluno);

                    turma.addMatricula(matricula);

                    break;
                case 7:
                    // Configura o tamanho das tabelas
                    System.out.println("\n--- CONFIGURAÇÃO DAS TABELAS ---");
                    do {
                        System.out.print("Defina a largura das colunas (Mín 40, Máx 100): ");
                        larguraColuna = scanner.nextInt();
                        if (larguraColuna < 40 || larguraColuna > 100)
                            System.out.println("Valor inválido!");
                    } while (larguraColuna < 40 || larguraColuna > 100);
                    System.out.println("Largura atualizada com sucesso!");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
            try {
                Thread.sleep(700);
            } catch (Exception e) {
                System.err.println("Erro no timer");
            }
        } while (escolha != 0);
        scanner.close();
    }
}

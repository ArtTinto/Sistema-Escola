import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        int escolha;

        Disciplina allDisiciplinas[] = new Disciplina[30];
        Aluno[] allAlunos = new Aluno[80];

        innit(random, allDisiciplinas, allAlunos);

        do {
            if (allAlunos[allAlunos.length - 1] != null) {
                allAlunos = expandirVetorAlunos(allAlunos);
            }

            if (allDisiciplinas[allDisiciplinas.length - 1] != null) {
                allDisiciplinas = expandirVetorDisciplinas(allDisiciplinas);
            }

            System.out.println("\n============================================");
            System.out.println("|           SISTEMA DE MATRÍCULAS          |");
            System.out.println("============================================");
            System.out.println("| [1] Cadastrar (Aluno/Disciplina)         |");
            System.out.println("| [2] Consultar (Listagens)                |");
            System.out.println("| [3] Atualizar (Editar Dados)             |");
            System.out.println("| [4] Deletar   (Remover Dados)            |");
            System.out.println("| [5] Matricular Aluno em Disciplina       |");
            System.out.println("| [6] Listar Matrículas                    |");
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
                    do {
                        System.out.println("\n---------- SUBMENU: CADASTRO ----------");
                        System.out.println("| [1] Nova Disciplina                 |");
                        System.out.println("| [2] Novo Aluno                      |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        escolha = scanner.nextInt();
                    } while (escolha > 2 || escolha < 0);

                    if (escolha == 1) {
                        Disciplina dadosDisciplina = new Disciplina(null, null);
                        if (addDisciplina(allDisiciplinas, dadosDisciplina)) {
                            System.out.println("\n>>> Disciplina cadastrada com sucesso!");
                        } else {
                            System.out.println("\n>>> Erro ao cadastrar a disciplina!");
                        }

                    } else if (escolha == 2) {
                        Aluno dadosAlunos = dadosAlunos();

                        if (verificaNomeigual(allAlunos, dadosAlunos)) {
                            if (addAluno(allAlunos, dadosAlunos)) {
                                System.out.println("\n>>> Aluno cadastrado com sucesso!");
                            } else {
                                System.out.println("\n>>> Erro ao cadastrar o aluno");
                            }
                        } else {
                            System.out.println("\n>>> Alunos com mesmo nome não podem ser cadastrados");
                        }
                    }
                    break;

                case 2:
                    // Printa a tabela de alunos e disciplinas
                    do {
                        System.out.println("\n---------- SUBMENU: CONSULTA ----------");
                        System.out.println("| [1] Listar Disciplinas              |");
                        System.out.println("| [2] Listar Alunos                   |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        escolha = scanner.nextInt();
                    } while (escolha > 2 || escolha < 0);

                    if (escolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                    } else if (escolha == 2) {
                        do {
                            System.out.println("\n>>> MODO DE LISTAGEM DE ALUNOS:");
                            System.out.println("[1] Por Ordem de Cadastro");
                            System.out.println("[2] Por Média (Decrescente)");
                            System.out.print("Opção > ");
                            escolha = scanner.nextInt();
                        } while (escolha < 1 || escolha > 2);
                        printaAlunos(allAlunos, escolha);
                    }
                    break;

                case 3:
                    // Altera aluno ou disciplina
                    do {
                        System.out.println("\n---------- SUBMENU: ATUALIZAÇÃO ----------");
                        System.out.println("| [1] Editar Disciplina                  |");
                        System.out.println("| [2] Editar Aluno                       |");
                        System.out.println("| [0] Voltar ao Menu Principal           |");
                        System.out.println("------------------------------------------");
                        System.out.print("Opção > ");
                        escolha = scanner.nextInt();
                    } while (escolha > 2 || escolha < 0);

                    if (escolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.print("\nDigite o CÓDIGO da disciplina para editar: ");
                        escolha = scanner.nextInt();

                        alterarDisciplina(escolha, allDisiciplinas);

                    } else if (escolha == 2) {
                        printaAlunos(allAlunos, 1);
                        System.out.print("\nDigite a MATRÍCULA do aluno para editar: ");
                        escolha = scanner.nextInt();

                        alterarAluno(escolha, allAlunos);
                    }
                    break;

                case 4:
                    // Remove aluno ou Disciplina
                    do {
                        System.out.println("\n---------- SUBMENU: EXCLUSÃO ----------");
                        System.out.println("| [1] Remover Disciplina              |");
                        System.out.println("| [2] Remover Aluno                   |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        escolha = scanner.nextInt();
                    } while (escolha > 2 || escolha < 0);

                    if (escolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.print("\nDigite o CÓDIGO da disciplina para remover: ");
                        escolha = scanner.nextInt();

                        removeDisciplina(escolha, allDisiciplinas, allAlunos);

                    } else if (escolha == 2) {
                        printaAlunos(allAlunos, 1);
                        System.out.print("\nDigite a MATRÍCULA do aluno para remover: ");
                        escolha = scanner.nextInt();

                        removeAluno(escolha, allAlunos);
                    }
                    break;

                case 5:
                    // Inicializa matricula, printando os alunos e disciplinas
                    printaAlunos(allAlunos, 1);
                    printaDisiciplinas(allDisiciplinas);
                    matricular(allAlunos, allDisiciplinas);
                    break;

                case 6:
                    printaMatriculas(allAlunos);
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
    }

    // Parte dos Alunos

    static Aluno dadosAlunos() {
        Aluno cadAluno = new Aluno();

        cadAluno.CodigoAluno = contadorAluno++;

        scanner.nextLine();

        System.out.println("\nDigite o nome do Aluno:");
        cadAluno.nomeAluno = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite o estado do Aluno:");
        cadAluno.endereco.estado = scanner.nextLine();

        System.out.println("\nDigite a cidade do Aluno:");
        cadAluno.endereco.cidade = scanner.nextLine();

        System.out.println("\nDigite o bairro do Aluno:");
        cadAluno.endereco.bairro = scanner.nextLine();

        System.out.println("\nDigite a rua do Aluno:");
        cadAluno.endereco.rua = scanner.nextLine();

        System.out.println("\nDigite o número da residência do Aluno:");
        cadAluno.endereco.numero = scanner.nextInt();

        return cadAluno;
    }

    static boolean verificaNomeigual(Aluno[] alunos, Aluno objeto) {
        // Não deve ser possível inserir aluno com mesmo nome
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].nomeAluno.equals(objeto.nomeAluno)) {
                System.out.println("Já existe um aluno com este nome!");
                return false;
            }
        }
        return true;
    }

    static boolean addAluno(Aluno[] arrAluno, Aluno objeto) {
        if (arrAluno != null) {
            for (int i = 0; i < arrAluno.length; i++) {
                if (arrAluno[i] == null) {
                    arrAluno[i] = objeto;
                    return true;
                }
            }
        }
        return false;
    }

    public static void printaAlunos(Aluno[] alunos, int tipo) {
        // Copia alunos para nao mexer no array original
        Aluno[] copia = new Aluno[alunos.length];
        int total = 0;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                copia[total++] = alunos[i];
            }
        }

        // Se for o tipo 2 faz o buble sorte pro RG dos alunos
        if (tipo == 2) {
            for (int i = 0; i < total - 1; i++) {
                for (int j = 0; j < total - 1 - i; j++) {
                    if (copia[j].rg < copia[j + 1].rg) {
                        Aluno temp = copia[j];
                        copia[j] = copia[j + 1];
                        copia[j + 1] = temp;
                    }
                }
            }
        }

        int larguraTotal = (larguraColuna * 2) + 10 + 5 + 10 + 16;

        for (int i = 0; i < larguraTotal; i++)
            System.out.print("-");
        System.out.println();

        System.out.printf(
                "| %-10s | %-" + larguraColuna + "." + larguraColuna + "s | %-5s | %-" + larguraColuna + "."
                        + larguraColuna + "s | %-10s |\n",
                "MATRÍCULA", "NOME", "QTD", "DISCIPLINAS", "RG (MÉDIA)");

        for (int i = 0; i < larguraTotal; i++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < total; i++) {
            String listaSiglas = "";
            for (int j = 0; j < copia[i].qtdDisciplinas; j++) {
                listaSiglas += copia[i].matriculas[j].disciplina.sigla;
                
                // Substituição do "if reduzido" (operador ternário) por if padrão
                if (j < copia[i].qtdDisciplinas - 1) {
                    listaSiglas += ", ";
                }
            }

            System.out.printf(
                    "| %-10d | %-" + larguraColuna + "." + larguraColuna + "s | %-5d | %-" + larguraColuna + "."
                            + larguraColuna + "s | %-10.2f |\n",
                    copia[i].CodigoAluno,
                    copia[i].nomeAluno,
                    copia[i].qtdDisciplinas,
                    listaSiglas,
                    copia[i].rg);

            for (int j = 0; j < larguraTotal; j++)
                System.out.print("-");
            System.out.println();
        }
    }
    static void alterarAluno(int matricula, Aluno[] alunos) {
        // Altera o aluno baseado no seu numero de matricula
        if (alunos == null) {
            System.out.println("Não há alunos cadastrados, impossível alterar.");
            return;
        }

        if (matricula > alunos.length || matricula <= 0) {
            System.out.println("Impossível alterar, matricula inexistente.");
            return;
        }

        Aluno aln = null;

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && matricula == alunos[i].CodigoAluno) {
                aln = alunos[i];
                break;
            }
        }

        if (aln == null) {
            System.out.println("Aluno não encontrado");
            return;
        }

        scanner.nextLine();

        System.out.println("\nDigite o novo nome do Aluno:");
        aln.nomeAluno = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite o novo estado do Aluno:");
        aln.endereco.estado = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite a nova cidade do Aluno:");
        aln.endereco.cidade = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite o novo bairro do Aluno:");
        aln.endereco.bairro = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite a nova rua do Aluno:");
        aln.endereco.rua = scanner.nextLine().toUpperCase();

        System.out.println("\nDigite o novo número da residência do Aluno:");
        aln.endereco.numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("\nAluno alterado com sucesso!!");
    }

    static void removeAluno(int matricula, Aluno[] alunos) {
        // Remove aluno baseado na matricula
        if (alunos == null) {
            System.out.println("Não há alunos cadastrados, impossível remover.");

            return;
        }

        if (matricula > alunos.length || matricula <= 0) {
            System.out.println("Impossível remover, posição inexistente.");

            return;
        }

        int indiceEncontrado = -1;

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].CodigoAluno == matricula) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado == -1) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        for (int i = indiceEncontrado; i < alunos.length - 1; i++) { // Coloca pro final para remover
            alunos[i] = alunos[i + 1];
        }

        alunos[alunos.length - 1] = null;

        System.out.println("\nAluno com matrícula " + matricula + " removido com sucesso!!");
    }

    // Parte das Matriculas

    static void matricular(Aluno[] alunos, Disciplina[] disciplinas) {
        int codBuscaAluno, codBuscaDisciplina;

        System.out.println("Qual o número de matrícula do aluno: ");
        codBuscaAluno = scanner.nextInt();

        Aluno alu = null;
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].CodigoAluno == codBuscaAluno) {
                alu = alunos[i];
                break;
            }
        }

        if (alu == null) {
            System.out.println("Este aluno não está cadastrado");
            return;
        }

        System.out.println("Código da Disciplina: ");
        codBuscaDisciplina = scanner.nextInt();

        Disciplina dis = null;
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null && disciplinas[i].codigoDisiciplina == codBuscaDisciplina) {
                dis = disciplinas[i];
                break;
            }
        }

        if (dis == null) {
            System.out.println("Essa disciplina não está cadastrada");
            return;
        }

        for (int i = 0; i < alu.qtdDisciplinas; i++) {
            if (alu.matriculas[i].disciplina.codigoDisiciplina == dis.codigoDisiciplina) {
                System.out.println("O aluno já está matriculado nesta disciplina!");
                return;
            }
        }

        if (alu.qtdDisciplinas < 10) {
            Matricula mat = new Matricula();
            mat.disciplina = dis;

            mat.notaFinal = random.nextFloat() * 100;

            alu.matriculas[alu.qtdDisciplinas] = mat;
            alu.qtdDisciplinas++;

            double soma = 0;
            for (int i = 0; i < alu.qtdDisciplinas; i++) {
                soma += alu.matriculas[i].notaFinal;
            }
            alu.rg = soma / alu.qtdDisciplinas;

            System.out.println("Matriculado com sucesso!");
        } else {
            System.out.println("Limite de 10 disciplinas atingido.");
        }
    }

    static void printaMatriculas(Aluno[] alunos) {
        int larguraTotal = (larguraColuna * 2) + 7 + 10;

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.printf(
                "| %-" + larguraColuna + "." + larguraColuna + "s | %-" + larguraColuna + "." + larguraColuna
                        + "s | %-7s |\n",
                "ALUNO", "DISCIPLINA", "NOTA");

        for (int i = 0; i < larguraTotal; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].qtdDisciplinas > 0) {
                for (int j = 0; j < alunos[i].qtdDisciplinas; j++) {
                    System.out.printf(
                            "| %-" + larguraColuna + "." + larguraColuna + "s | %-" + larguraColuna + "."
                                    + larguraColuna + "s | %-7.2f |\n",
                            alunos[i].nomeAluno,
                            alunos[i].matriculas[j].disciplina.nomeDisciplina,
                            alunos[i].matriculas[j].notaFinal);

                    for (int k = 0; k < larguraTotal; k++) {
                        System.out.print("-");
                    }
                    System.out.println();
                }
            }
        }
    }

    // Funções de controle

    static void innit(Random random, Disciplina[] disciplinas, Aluno[] alunos) {
        // DADOS PARA DISCIPLINAS (3 iniciais)
        String[] nomeDisciplina = {
                "BANCO DE DADOS",
                "ARQUITETURA E ORGANIZAÇÃO DE COMPUTADORES",
                "INTEGRAÇÃO E SÉRIES",
                "PROGRAMAÇÃO ORIENTADA A OBETO",
                "GEOMETRIA ANALÍTA E ÁLGEBRA LINEAR"
        };

        String[] sigla = { "BD", "AOC", "IS", "POO", "GAAL" };

        int[] ano = { 2023, 2024, 2025, 2026 };

        String[] docente = { "MARCELO BALBINO", "BRUNO", "MATEUS", "LUCIANO", "JOSÉ JOZELMO" };

        int limiteDisc = 5;
        for (int i = 0; i < 3; i++) {
            Disciplina objeto = new Disciplina();

            int sorteado = random.nextInt(5 - i);

            objeto.codigoDisiciplina = contadorDisiciplina++;

            objeto.nomeDisciplina = nomeDisciplina[sorteado];

            objeto.sigla = sigla[sorteado];

            objeto.anoDisciplina = ano[random.nextInt(4)];

            objeto.nomeProfessor = docente[sorteado];

            for (int j = sorteado; j < limiteDisc - 1; j++) {
                nomeDisciplina[j] = nomeDisciplina[j + 1];

                sigla[j] = sigla[j + 1];

                docente[j] = docente[j + 1];
            }

            disciplinas[i] = objeto;
        }

        // DADOS PARA ALUNOS (5 iniciais)
        String[] nomesAlu = { "RENATO", "VITOR", "ARTHUR", "THALES", "YURI" };

        int limiteAlu = 5;

        String estado = "MG";

        String[] cidade = {
                "TIMOTEO",
                "CORONEL FABRICIANO",
                "CORONEL FABRICIANO",
                "CORONEL FABRICIANO",
                "IPATINGA"
        };

        String[] bairro = {
                "MACUCO",
                "BELVEDERE",
                "SILVIO PEREIRA",
                "BELVEDERE",
                "IGUAÇU"
        };

        String[] rua = {
                "RUA JEQUIRI",
                "RUA 13",
                "RUA POMODORO",
                "RUA POUSO ALEGRE",
                "RUA CATETO"
        };

        int[] numeroRes = {
                854,
                78,
                90,
                84,
                32
        };

        for (int i = 0; i < 5; i++) {
            int sorteado = random.nextInt(limiteAlu);

            Aluno aluno = new Aluno();
            aluno.CodigoAluno = contadorAluno++;
            aluno.nomeAluno = nomesAlu[sorteado];
            aluno.endereco.estado = estado;
            aluno.endereco.cidade = cidade[sorteado];
            aluno.endereco.bairro = bairro[sorteado];
            aluno.endereco.rua = rua[sorteado];
            aluno.endereco.numero = numeroRes[sorteado];

            double somaNotasIniciais = 0;

            // Inicializa o aluno com 2 matrículas aleatórias das disciplinas já criadas
            for (int k = 0; k < 2; k++) {
                Disciplina discSorteada;
                boolean jaMatriculado;

                // Loop para garantir que a disciplina sorteada não seja repetida para o mesmo
                // aluno
                do {
                    jaMatriculado = false;
                    discSorteada = disciplinas[random.nextInt(3)]; // Pega uma das 3 iniciais

                    for (int m = 0; m < aluno.qtdDisciplinas; m++) {
                        if (aluno.matriculas[m].disciplina.codigoDisiciplina == discSorteada.codigoDisiciplina) {
                            jaMatriculado = true;
                            break;
                        }
                    }
                } while (jaMatriculado);

                Matricula matricula = new Matricula();
                matricula.disciplina = discSorteada;

                matricula.notaFinal = (100 * random.nextDouble());
                somaNotasIniciais += matricula.notaFinal;

                aluno.matriculas[aluno.qtdDisciplinas] = matricula;
                aluno.qtdDisciplinas++;
            }

            aluno.rg = somaNotasIniciais / aluno.qtdDisciplinas;

            alunos[i] = aluno;

            for (int j = sorteado; j < limiteAlu - 1; j++) {
                nomesAlu[j] = nomesAlu[j + 1];
                cidade[j] = cidade[j + 1];
                bairro[j] = bairro[j + 1];
                rua[j] = rua[j + 1];
                numeroRes[j] = numeroRes[j + 1];
            }
            limiteAlu--;
        }
    }

    public static Aluno[] expandirVetorAlunos(Aluno[] alunosAntigo) {
        Aluno[] novoVetor = new Aluno[alunosAntigo.length * 2];

        for (int i = 0; i < alunosAntigo.length; i++) {
            novoVetor[i] = alunosAntigo[i];
        }

        return novoVetor;
    }

    public static Disciplina[] expandirVetorDisciplinas(Disciplina[] disciplinasAntigo) {
        Disciplina[] novoVetor = new Disciplina[disciplinasAntigo.length + 10];

        for (int i = 0; i < disciplinasAntigo.length; i++) {
            novoVetor[i] = disciplinasAntigo[i];
        }
        
        return novoVetor;
    }
}
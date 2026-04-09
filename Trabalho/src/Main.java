import java.util.Random;
import java.util.Scanner;

public class Main {

    static int contador = 1;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int contadorAluno = 1;
    static int larguraColuna = 40;

    public static void main(String[] args) {

        int escolha;

        Disciplina allDisiciplinas[] = new Disciplina[30];
        Aluno[] allAlunos = new Aluno[80];

        innit(random, allDisiciplinas, allAlunos);

        do {
            int innerEscolha;

            System.out.println("\n============================================");
            System.out.println("|           SISTEMA DE MATRÍCULAS          |");
            System.out.println("============================================");
            System.out.println("| [1] Cadastrar (Aluno/Disciplina)         |");
            System.out.println("| [2] Consultar (Listagens)                |");
            System.out.println("| [3] Atualizar (Editar Dados)             |");
            System.out.println("| [4] Deletar   (Remover Dados)            |");
            System.out.println("| [5] Matricular Aluno em Disciplina       |");
            System.out.println("| [6] Configurar Largura das Colunas       |");
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
                    do {
                        System.out.println("\n---------- SUBMENU: CADASTRO ----------");
                        System.out.println("| [1] Nova Disciplina                 |");
                        System.out.println("| [2] Novo Aluno                      |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    switch (innerEscolha) {
                        case 1:
                            Disciplina dadosDisciplina = dadosDisciplina();
                            addDisciplina(allDisiciplinas, dadosDisciplina);
                            System.out.println("\n>>> Disciplina cadastrada com sucesso!");
                            break;
                        case 2:
                            Aluno dadosAlunos = dadosAlunos(allAlunos);
                            if (dadosAlunos != null) {
                                addAluno(allAlunos, dadosAlunos);
                                System.out.println("\n>>> Aluno cadastrado com sucesso!");
                            }
                            break;
                    }
                    break;

                case 2:
                    do {
                        System.out.println("\n---------- SUBMENU: CONSULTA ----------");
                        System.out.println("| [1] Listar Disciplinas              |");
                        System.out.println("| [2] Listar Alunos                   |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                    } else if (innerEscolha == 2) {
                        do {
                            System.out.println("\n>>> MODO DE LISTAGEM DE ALUNOS:");
                            System.out.println("[1] Por Ordem de Cadastro");
                            System.out.println("[2] Por Média (Decrescente)");
                            System.out.print("Opção > ");
                            innerEscolha = scanner.nextInt();
                        } while (innerEscolha < 1 || innerEscolha > 2);
                        printaAlunos(allAlunos, innerEscolha);
                    }
                    break;

                case 3:
                    do {
                        System.out.println("\n---------- SUBMENU: ATUALIZAÇÃO ----------");
                        System.out.println("| [1] Editar Disciplina                  |");
                        System.out.println("| [2] Editar Aluno                       |");
                        System.out.println("| [0] Voltar ao Menu Principal           |");
                        System.out.println("------------------------------------------");
                        System.out.print("Opção > ");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.print("\nDigite o CÓDIGO da disciplina para editar: ");
                        alterarDisciplina(scanner.nextInt(), allDisiciplinas);
                    } else if (innerEscolha == 2) {
                        printaAlunos(allAlunos, 1);
                        System.out.print("\nDigite a MATRÍCULA do aluno para editar: ");
                        alterarAluno(scanner.nextInt(), allAlunos);
                    }
                    break;

                case 4:
                    do {
                        System.out.println("\n---------- SUBMENU: EXCLUSÃO ----------");
                        System.out.println("| [1] Remover Disciplina              |");
                        System.out.println("| [2] Remover Aluno                   |");
                        System.out.println("| [0] Voltar ao Menu Principal        |");
                        System.out.println("---------------------------------------");
                        System.out.print("Opção > ");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.print("\nDigite o CÓDIGO da disciplina para remover: ");
                        removeDisciplina(scanner.nextInt(), allDisiciplinas, allAlunos);
                    } else if (innerEscolha == 2) {
                        printaAlunos(allAlunos, 1);
                        System.out.print("\nDigite a MATRÍCULA do aluno para remover: ");
                        removeAluno(scanner.nextInt(), allAlunos);
                    }
                    break;

                case 5:
                    System.out.println("\n--- INICIANDO PROCESSO DE MATRÍCULA ---");
                    printaAlunos(allAlunos, 1);
                    printaDisiciplinas(allDisiciplinas);
                    matricular(allAlunos, allDisiciplinas);
                    break;

                case 6:
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
                    System.out.println("\nERRO: Opção inválida!");
                    break;
            }

            try {
                Thread.sleep(700);
            } catch (Exception e) {
            }

            if (allAlunos[allAlunos.length - 1] != null) {
                allAlunos = expandirVetorAlunos(allAlunos);
            }

            if (allDisiciplinas[allDisiciplinas.length - 1] != null) {
                allDisiciplinas = expandirVetorDisciplinas(allDisiciplinas);
            }

        } while (escolha != 0);
    }

    
    static Disciplina dadosDisciplina() {
        // Função para receber os dados das disciplinas
        Disciplina cadDisiciplina = new Disciplina();
        
        cadDisiciplina.codigoDisiciplina = contador++;
        
        scanner.nextLine();
        
        System.out.println("\nDigite o nome da disciplina");
        cadDisiciplina.nomeDisciplina = scanner.nextLine().toUpperCase();
        
        System.out.println("\nDigite a sigla");
        cadDisiciplina.sigla = scanner.nextLine().toUpperCase();
        
        System.out.println("\nDigite o ano da disciplina");
        cadDisiciplina.anoDisciplina = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("\nDigite o nome do Docente");
        cadDisiciplina.nomeProfessor = scanner.nextLine().toUpperCase();
        
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
                        disciplinas[i].codigoDisiciplina,
                        disciplinas[i].nomeDisciplina,
                        disciplinas[i].sigla,
                        disciplinas[i].anoDisciplina,
                        disciplinas[i].nomeProfessor);
                        
                        for (int j = 0; j < larguraTotal; j++) {
                            System.out.print("-");
                        }
                        System.out.println();
                    }
        }
    }
    
    static void alterarDisciplina(int posicao, Disciplina[] disciplinas) {
        // Altera a disciplina sobreescrevendo os dados
        if (disciplinas == null) {
            System.out.println("Não há disciplinas cadastradas, impossível alterar");
            return;
        }
        
        if (posicao > disciplinas.length || posicao <= 0) {
            System.out.println("Impossível alterar, posição inexistente");
            return;
        }
        
        if (disciplinas[posicao - 1] == null) {
            System.out.println("Impossível alterar, essa disciplina não existe");
            return;
        }
        
        Disciplina disc = disciplinas[posicao - 1];
        
        scanner.nextLine();
        
        System.out.println("\nDigite o nome da disciplina");
        disc.nomeDisciplina = scanner.nextLine().toUpperCase();
        
        System.out.println("\nDigite a sigla");
        disc.sigla = scanner.nextLine().toUpperCase();
        
        System.out.println("\nDigite o ano da disciplina");
        disc.anoDisciplina = scanner.nextInt();
        
        scanner.nextLine();
        
        System.out.println("\nDigite o nome do Docente");
        disc.nomeProfessor = scanner.nextLine().toUpperCase();
        
        System.out.println("\nDisciplina alterada com sucesso!!");
    }
    
    static void removeDisciplina(int posicao, Disciplina[] disciplinas, Aluno[] alunos) {
        if (disciplinas == null) {
            System.out.println("Não há disciplinas cadastradas, impossível remover");
            return;
        }
        
        if (posicao > disciplinas.length || posicao <= 0) {
            System.out.println("Impossível remover, posição inexistente");
            return;
        }
        
        if (disciplinas[posicao - 1] == null) {
            System.out.println("Impossível remover, essa disciplina não existe");
            return;
        }
        
        Disciplina disRemover = disciplinas[posicao - 1];
        
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                for (int j = 0; j < alunos[i].qtdDisciplinas; j++) {
                    // Verifica se a disciplina da matrícula é a mesma que queremos remover
                    if (alunos[i].matriculas[j].disciplina.codigoDisiciplina == disRemover.codigoDisiciplina) {
                        System.out.println("Não é possível remover disciplina com aluno matriculado!");
                        return;
                    }
                }
            }
        }
        
        for (int i = posicao - 1; i < disciplinas.length - 1; i++) {
            disciplinas[i] = disciplinas[i + 1];
            if (disciplinas[i] != null) {
                disciplinas[i].codigoDisiciplina--;
            }
        }
        disciplinas[disciplinas.length - 1] = null;
        contador--;
    }
    
    // Parte dos Alunos
    static Aluno dadosAlunos(Aluno[] alunos) {
        Aluno cadAluno = new Aluno();
        
        cadAluno.CodigoAluno = contadorAluno++;
        
        scanner.nextLine();
        
        System.out.println("\nDigite o nome do Aluno:");
        String nome = scanner.nextLine().toUpperCase();
        
        // Não deve ser possível inserir aluno com mesmo nome
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].nomeAluno.equals(nome)) {
                System.out.println("ERRO: Já existe um aluno com este nome!");
                return null;
            }
        }
        
        cadAluno.nomeAluno = nome;
        
        System.out.println("\nDigite o estado do Aluno:");
        cadAluno.endereco.estado = scanner.nextLine();
        
        System.out.println("\nDigite a cidade do Aluno:");
        cadAluno.endereco.cidade = scanner.nextLine();
        
        System.out.println("\nDigite o bairro do Aluno:");
        cadAluno.endereco.bairro = scanner.nextLine();
        
        System.out.println("\nDigite a rua do Aluno:");
        cadAluno.endereco.rua = scanner.nextLine();
        
        System.out.println("\nDigite o número do Aluno:");
        cadAluno.endereco.numero = scanner.nextInt();
        
        return cadAluno;
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
                    listaSiglas += copia[i].matriculas[j].disciplina.sigla + (j < copia[i].qtdDisciplinas - 1 ? ", " : "");
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
            
            static void alterarAluno(int posicao, Aluno[] alunos) {
                if (alunos == null) {
                    System.out.println("Não há alunos cadastrados, impossível alterar.");
                    return;
                }
                
                if (posicao > alunos.length || posicao <= 0) {
                    System.out.println("Impossível alterar, posição inexistente.");
                    return;
                }
                
                if (alunos[posicao - 1] == null) {
                    System.out.println("Impossível alterar, esse aluno não existe.");
                    return;
                }
                
                Aluno aluno = alunos[posicao - 1];
                
                System.out.println("\nDigite o novo nome do Aluno:");
                aluno.nomeAluno = scanner.nextLine().toUpperCase();
                
                System.out.println("\nDigite o novo estado do Aluno:");
                aluno.endereco.estado = scanner.nextLine().toUpperCase();
                
                System.out.println("\nDigite a nova cidade do Aluno:");
                aluno.endereco.cidade = scanner.nextLine().toUpperCase();
                
                System.out.println("\nDigite o novo bairro do Aluno:");
                aluno.endereco.bairro = scanner.nextLine().toUpperCase();
                
                System.out.println("\nDigite a nova rua do Aluno:");
                aluno.endereco.rua = scanner.nextLine().toUpperCase();
                
                System.out.println("\nDigite o novo número do Aluno:");
                aluno.endereco.numero = scanner.nextInt();
                
                scanner.nextLine();
                
                System.out.println("\nAluno alterado com sucesso!!");
            }
            
            static void removeAluno(int posicao, Aluno[] alunos) {
                if (alunos == null) {
                    System.out.println("Não há alunos cadastrados, impossível remover.");
                    return;
                }
                
                if (posicao > alunos.length || posicao <= 0) {
                    System.out.println("Impossível remover, posição inexistente.");
                    return;
                }
                
                if (alunos[posicao - 1] == null) {
                    System.out.println("Impossível remover, não há aluno nesta posição.");
            return;
        }
        
        for (int i = posicao - 1; i < alunos.length - 1; i++) {
            alunos[i] = alunos[i + 1];
        }
        
        alunos[alunos.length - 1] = null;
        
        System.out.println("\nAluno removido com sucesso!!");
    }
    
    static void matricular(Aluno[] alunos, Disciplina[] disciplinas) {
        int codigoAluno, codigoDisciplina;
        
        do {
            System.out.println("Qual o número de matrícula do aluno: ");
            codigoAluno = scanner.nextInt() - 1;
            
            if (codigoAluno < 0 || codigoAluno >= alunos.length) {
                System.out.println("Digite um número de matrícula válido");
            }
        } while (codigoAluno < 0 || codigoAluno >= alunos.length);
        
        do {
            System.out.println("Código da Disciplina: ");
            codigoDisciplina = scanner.nextInt() - 1;
            
            if (codigoDisciplina < 0 || codigoDisciplina >= disciplinas.length) {
                System.out.println("Digite uma disciplina válida");
            }
        } while (codigoDisciplina < 0 || codigoDisciplina >= disciplinas.length);
        
        if (alunos[codigoAluno] == null) {
            System.out.println("Este aluno não está cadastrado");
            return;
        }
        
        if (disciplinas[codigoDisciplina] == null) {
            System.out.println("Essa disciplina não está cadastrada");
            return;
        }
        
        Aluno alu = alunos[codigoAluno];
        Disciplina dis = disciplinas[codigoDisciplina];
        
        // Verifica se aluno já está na disciplina
        for (int i = 0; i < alu.qtdDisciplinas; i++) {
            if (alu.matriculas[i].disciplina.codigoDisiciplina == dis.codigoDisiciplina) {
                System.out.println("ERRO: O aluno já está matriculado nesta disciplina!");
                return;
            }
        }
        
        if (alu.qtdDisciplinas < 10) {
            Matricula mat = new Matricula();
            mat.disciplina = dis;
            
            // Gera uma nota final aleatória
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
            
            objeto.codigoDisiciplina = contador++;
            
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
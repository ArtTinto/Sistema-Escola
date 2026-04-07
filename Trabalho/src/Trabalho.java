import java.util.Random;
import java.util.Scanner;

public class Trabalho {

    static int contador = 1;
    static Scanner scanner = new Scanner(System.in);
    static int contadorAluno= 1;

    public static void main(String[] args) {

        Random random = new Random();

        int escolha;

        Disciplina allDisiciplinas[] = new Disciplina[100];
        Aluno[] allAlunos = new Aluno[100];

        innit(random, allDisiciplinas);
        inicializa(random, allAlunos);

        do {
            int innerEscolha; // Inicia a variável a cada ciclo

            System.out.println("\nDigite 0 para Sair");
            System.out.println("Digite 1 para Cadastrar");
            System.out.println("Digite 2 para Consultar");
            System.out.println("Digite 3 para Atualizar");
            System.out.println("Digite 4 para Deletar");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    // Fecha o programa
                    System.out.println("Fechando o programa ...");
                    System.exit(0);
                    break;

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
                        Aluno dadosAlunos = dadosAlunos();
                        addAluno(allAlunos, dadosAlunos);

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
                        printaAlunos(allAlunos);

                    }

                    break;

                case 3:
                    // Primeiro printa a todas as disciplinas para saber qual exatamente qual
                    // código exatamente alterar
                   do {
                        System.out.println("\nDigite 0 voltar");
                        System.out.println("Digite 1 para atualizar Disiciplinas");
                        System.out.println("Digite 2 para atualizar Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.println("\nDigite o código da disciplina que quer alterar: ");
                        int codigoAcao = scanner.nextInt();
                        alterarDisciplina(codigoAcao, allDisiciplinas);
                    } else if (innerEscolha == 2) {
                        printaAlunos(allAlunos);
                        System.out.println("\nDigite a posição do aluno que quer alterar: ");
                        int posicaoAcao = scanner.nextInt();
                        alterarAluno(posicaoAcao, allAlunos);
                    }
                    break;

                case 4:
                    // Primeiro printa a todas as disciplinas para saber qual exatamente qual
                    // código exatamente remover
                    do {
                        System.out.println("\nDigite 0 voltar");
                        System.out.println("Digite 1 para remover Disiciplinas");
                        System.out.println("Digite 2 para remover Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        printaDisiciplinas(allDisiciplinas);
                        System.out.println("\nDigite o código da disciplina que quer alterar: ");
                        int codigoAcao = scanner.nextInt();
                        removeDisciplina(codigoAcao, allDisiciplinas);
                    } else if (innerEscolha == 2) {
                        printaAlunos(allAlunos);
                        System.out.println("\nDigite a posição do aluno que quer remover: ");
                        int posicaoAcao = scanner.nextInt();
                        removeAluno(posicaoAcao, allAlunos);
                    }
                    break;

                default:
                    System.out.println("\nOpção inválida\n");
                    break;
            }

             

        } while (escolha != 0);
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
        // Funcao para o printar de forma tabelada as disciplinas

        for (int i = 0; i < 120; i++) {
            System.out.print(
                    "-");
        }
        System.out.println();

        System.out.printf("| %-7s | %-50s | %-7s | %-5s | %-35s |\n",
                "Codígo", "Disciplina", "Sigla", "Ano", "Docente");

        for (int i = 0; i < 120; i++) {
            System.out.print(
                    "-");
        }
        System.out.println();

        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null) {

                System.out.printf("| %-7d | %-50s | %-7s | %-5d | %-35s |\n",
                        disciplinas[i].codigoDisiciplina,
                        disciplinas[i].nomeDisciplina,
                        disciplinas[i].sigla,
                        disciplinas[i].anoDisciplina,
                        disciplinas[i].nomeProfessor);

                for (int j = 0; j < 120; j++) {
                    System.out.print(
                            "-");
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

        Disciplina d = disciplinas[posicao - 1];

        scanner.nextLine();

        System.out.println("\nDigite o nome da disciplina");
        d.nomeDisciplina = scanner.nextLine();

        System.out.println("\nDigite a sigla");
        d.sigla = scanner.nextLine();

        System.out.println("\nDigite o ano da disciplina");
        d.anoDisciplina = scanner.nextInt();

        scanner.nextLine();

        System.out.println("\nDigite o nome do Docente");
        d.nomeProfessor = scanner.nextLine();

        System.out.println("\nDisciplina alterada com sucesso!!");
    }

    static void removeDisciplina(int posicao, Disciplina[] disciplinas) {
        //
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

        disciplinas[posicao - 1] = null;

        for (int i = posicao; i < disciplinas.length; i++) {
            disciplinas[posicao] = disciplinas[posicao + 1];
        }
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


    //Alunos
    static Aluno dadosAlunos() {
        Aluno cadAluno = new Aluno();
        cadAluno.CodigoAluno = contadorAluno++;

        System.out.println("\nDigite o nome do Aluno:");
        cadAluno.nomeAluno = scanner.nextLine();

        System.out.println("\nDigite o endereço do Aluno:");
        cadAluno.enderecoAluno = scanner.nextLine();

        System.out.println("\nDigite as disciplinas matriculadas: ");
        for(int i = 0; i < cadAluno.disciplinasMatriculadas.length; i++){
            System.out.print("Matéria " + (i+1) + ": ");
            cadAluno.disciplinasMatriculadas[i] = scanner.nextLine();
        }

        System.out.println("\nDigite as notas da disciplina:");
        for (int i = 0; i < cadAluno.disciplinasMatriculadas.length; i++){
            System.out.print("Nota parcial para " + cadAluno.disciplinasMatriculadas[i] + ": ");
            cadAluno.notasDisciplinas[i] = scanner.nextInt();
            
            System.out.print("Nota FINAL para " + cadAluno.disciplinasMatriculadas[i] + ": ");
            cadAluno.notasFinais[i] = scanner.nextDouble(); 
        }
        
        scanner.nextLine(); 

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

    static void printaAlunos(Aluno[] alunos) {
        for (int i = 0; i < 140; i++) System.out.print("-");
        System.out.println();

        System.out.printf("| %-7s | %-25s | %-15s | %-25s | %-15s | %-15s |\n",
                "Código", "Aluno", "Endereço", "Disciplinas", "Notas Parciais", "Notas Finais");

        for (int i = 0; i < 140; i++) System.out.print("-");
        System.out.println();

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                String strDisciplinas = java.util.Arrays.toString(alunos[i].disciplinasMatriculadas);
                String strNotas = java.util.Arrays.toString(alunos[i].notasDisciplinas);
                String strNotasFinais = java.util.Arrays.toString(alunos[i].notasFinais); // Nova conversão

                System.out.printf("| %-7d | %-25s | %-15s | %-25s | %-15s | %-15s |\n",
                        alunos[i].CodigoAluno,
                        alunos[i].nomeAluno,
                        alunos[i].enderecoAluno,
                        strDisciplinas,
                        strNotas,
                        strNotasFinais);

                for (int j = 0; j < 140; j++) System.out.print("-");
                System.out.println();
            }
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

        Aluno a = alunos[posicao - 1];

        System.out.println("\nDigite o novo nome do Aluno:");
        a.nomeAluno = scanner.nextLine();

        System.out.println("\nDigite o novo endereço do Aluno:");
        a.enderecoAluno = scanner.nextLine();

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

    static void inicializa(Random random, Aluno[] alunos) {

        String[] nomeAluno = { "Renato", "Mateus", "Arthur", "Thales", "Yuri" };

        String[] endereco = { 
            "Rua Jequiri, 854, Macuco, Timoteo, Mg", 
            "Rua 13, 78, Belvedere, Coronel Fabriciano, Mg", 
            "Rua Pomodoro, 90, Silvio Pereira, Coronel Fabriciano, Mg", 
            "Rua Pouso Alegre, 84, Belvedere, Coronel Fabriciano, Mg", 
            "Rua Cateto, 32, Iguaçu, Ipatinga, Mg" 
        };

        String[][] disciplinasMatriculadas = { 
            {"Poo", "Bd"}, 
            {"Is", "Gaal"}, 
            {"Md", "Bd"}, 
            {"Is", "CVV"}, 
            {"FPII", "Bd"} 
        };

        int[][] notasDisciplinas = { 
            {80, 90}, 
            {75, 60}, 
            {95, 88}, 
            {70, 85}, 
            {65, 78} 
        };

        double[][] notasFinais = { 
            {8.5, 9.0}, 
            {7.0, 6.5}, 
            {9.5, 9.0}, 
            {7.5, 8.0}, 
            {6.5, 8.0} 
        };

        int limiteSorteio = 5;

        for (int i = 0; i < 3; i++) {
            Aluno objeto = new Aluno();

            int sorteado = random.nextInt(limiteSorteio);

            objeto.CodigoAluno = contadorAluno++; 
            objeto.nomeAluno = nomeAluno[sorteado];
            objeto.enderecoAluno = endereco[sorteado];
            
            objeto.disciplinasMatriculadas = new String[2];
            objeto.notasDisciplinas = new int[2];
            objeto.notasFinais = new double[2];

            for(int k = 0; k < 2; k++) {
                objeto.disciplinasMatriculadas[k] = disciplinasMatriculadas[sorteado][k];
                objeto.notasDisciplinas[k] = notasDisciplinas[sorteado][k];
                objeto.notasFinais[k] = notasFinais[sorteado][k];
            }


            for (int j = sorteado; j < limiteSorteio - 1; j++) {
                nomeAluno[j] = nomeAluno[j + 1];
                endereco[j] = endereco[j + 1];
                disciplinasMatriculadas[j] = disciplinasMatriculadas[j + 1];
                notasDisciplinas[j] = notasDisciplinas[j + 1];
                notasFinais[j] = notasFinais[j + 1];
            }

            limiteSorteio--;

            alunos[i] = objeto;
        }
    }
}

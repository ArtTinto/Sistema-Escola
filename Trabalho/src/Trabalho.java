import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = -1;

        Disciplina allDisiciplinas[] = new Disciplina[100];

        do {
            int innerEscolha = 0;

            System.out.println("Digite 0 para Sair");
            System.out.println("Digite 1 para Cadastrar");
            System.out.println("Digite 2 para Consultar");
            System.out.println("Digite 3 para Atualizar");
            System.out.println("Digite 4 para Deletar");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // DoWhile feito para escolher qual categoria deseja adicionar ou voltar
                    do {
                        System.out.println("Digite 0 voltar");
                        System.out.println("Digite 1 para o cadastro de Disiciplinas");
                        System.out.println("Digite 2 para o cadastro de Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);

                    if (innerEscolha == 1) {
                        Disciplina dadosDisciplina = dadosDisciplina(scanner);

                        addObjeto(allDisiciplinas, dadosDisciplina);
                    } else if(innerEscolha == 2) {

                    }

                    break;

                case 2:
                    // DoWhile feito para escolher qual categoria deseja consultar ou voltar
                    do {
                        System.out.println("Digite 0 voltar");
                        System.out.println("Digite 1 para o cadastro de Disiciplinas");
                        System.out.println("Digite 2 para o cadastro de Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 || innerEscolha < 0);
                    if (innerEscolha == 1) {
                        Disciplina dadosDisciplina = dadosDisciplina(scanner);

                        addObjeto(allDisiciplinas, dadosDisciplina);
                    } else if(innerEscolha == 2) {

                    }

                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    break;
            }

        } while (escolha != 0);
//Como o 
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

    static boolean addObjeto(Disciplina[] arrObjeto, Disciplina objeto) {
        if (arrObjeto != null) {
            for (int i = 0; i < arrObjeto.length; i++) {
                if (arrObjeto[i] == null) {
                    arrObjeto[i] = objeto;

                    return true;
                }
            }
        }
        return false;

    }
}
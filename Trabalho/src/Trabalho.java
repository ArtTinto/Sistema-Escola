import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int escolha = -1;

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
                    do {
                        System.out.println("Digite 1 para o cadastro de Disiciplinas");
                        System.out.println("Digite 2 para o cadastro de Alunos");
                        innerEscolha = scanner.nextInt();
                    } while (innerEscolha > 2 && innerEscolha < 1);

                    if (innerEscolha == 1) {
                        Disciplina dadosDisciplina = dadosDisciplina(scanner);

                        addObjeto(null, dadosDisciplina);
                    } else {

                    }

                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    break;
            }

        } while (escolha != 0);
    }

    static Disciplina dadosDisciplina(Scanner scanner) {
        Disciplina cadDisiciplina = new Disciplina();

        cadDisiciplina.codigoDisiciplina++;

        cadDisiciplina.nomeDisciplina = scanner.nextLine();

        cadDisiciplina.sigla = scanner.nextLine();

        cadDisiciplina.anoDisciplina = scanner.nextInt();

        scanner.nextLine();

        cadDisiciplina.nomeProfessor = scanner.nextLine();

        return cadDisiciplina;

    }

    static boolean addObjeto(Disciplina[] arrObjeto, Disciplina objeto) {
        if (arrObjeto != null) {
            for (int i = 0; i < arrObjeto.length; i++) {
                if (objeto == null) {
                    arrObjeto[i] = objeto;

                    return true;
                }
            }
        }
        return false;
    }
}
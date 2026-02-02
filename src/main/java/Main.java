import java.util.Scanner;

public class Main {

    Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public void exibirMenu() {
        System.out.println("+-----------------------+");
        System.out.println("|   Escolha uma opção   |");
        System.out.println("+-----------------------+");
        System.out.println("| 1 - Cadastrar autor   |");
        System.out.println("| 2 - Listar autores    |");
        System.out.println("| 3 - Cadastrar livro   |");
        System.out.println("| 4 - Listar livros     |");
        System.out.println("| 5 - Remover livro     |");
        System.out.println("| 6 - Cadastrar editora |");
        System.out.println("| 7 - Listar editoras   |");
        System.out.println("| 8 - Cadastrar gênero  |");
        System.out.println("| 9 - Listar gêneros    |");
        System.out.println("+-----------------------+");

        boolean opcaoValida = false;
        while(!opcaoValida) {
            try {
                System.out.println("--> ");
                String op = teclado.nextLine();

                validarOpcao(op);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validarOpcao(String opcao) {
        if (!opcao.matches("\\d+")) {
            throw new IllegalArgumentException("Digite apenas números");
        }

        int op = Integer.parseInt(opcao);

        if(op < 1 || op > 9) {
            throw new IllegalArgumentException("Escolha uma opção válida");
        }
    }
}

import model.Autor;
import model.Livro;
import service.AutorService;
import service.LivroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static LivroService livroService = new LivroService();
    static AutorService autorService = new AutorService();

    public static void main(String[] args) {


    }

    public static void menu() {
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
        System.out.println("| 0 - Sair              |");
        System.out.println("+-----------------------+");

        int op = -1;

        while(true) {
            try {
                System.out.println("--> ");
                String opcao = teclado.nextLine();
                op = validarOpcao(opcao); //op é a opcao, só que validado
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        switch (op) {
            case 0 -> System.exit(0);
            case 3 -> adicionarLivro();
        }
    }

    public static int validarOpcao(String opcao) {
        if (!opcao.matches("\\d+")) {
            throw new IllegalArgumentException("Digite apenas números");
        }

        int op = Integer.parseInt(opcao); //aqui "opcao" vira numero e passa o conteudo para op, que assume o controle

        if(op < 0 || op > 9) {
            throw new IllegalArgumentException("Escolha uma opção válida");
        }

        return op;
    }

    public static void adicionarLivro() {
        try {
            System.out.println("Adicionar novo livro");
            System.out.println("Título: ");
            String titulo = teclado.next();
            System.out.println("Ano de publicação: ");
            int ano = teclado.nextInt();
            System.out.println("Edição: ");
            int edicao = teclado.nextInt();
            System.out.println("Está disponível? (true/false) ");
            boolean disponivel = teclado.nextBoolean();
            System.out.println("Número de páginas: ");
            int paginas = teclado.nextInt();
            System.out.println("ID da editora: ");
            int editora = teclado.nextInt();
            System.out.println("ID do autor");
            int autor = teclado.nextInt();
            System.out.println("ID do gênero");
            int genero = teclado.nextInt();

            Livro livro = new Livro(titulo, ano, edicao, disponivel, paginas, editora, autor, genero);
            livroService.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarLivros() {
        try {
            System.out.println("Todos os livros:");
            List<Livro> livros = new ArrayList<>();

            if(livros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado");
                return;
            }

            for (Livro livro : livros) {
                System.out.println(livro.getTitulo()+" ("+ livro.getAnoPublicacao()+")");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar livros: "+e.getMessage());
        }
    }

    public static void adicionarAutor() {
        try {
            System.out.println("Adicionar novo autor");
            System.out.println("Nome: ");
            String nome = teclado.nextLine();

            Autor autor = new Autor(nome);
            autorService.adicionarAutor(autor);
            System.out.println("Autor adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

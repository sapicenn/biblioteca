package ui;

import model.*;
import service.AutorService;
import service.EditoraService;
import service.GeneroService;
import service.LivroService;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static LivroService livroService = new LivroService();
    static AutorService autorService = new AutorService();
    static EditoraService editoraService = new EditoraService();
    static GeneroService generoService = new GeneroService();

    public static void main(String[] args) {

        while(true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("+---------------------------+");
        System.out.println("|     Escolha uma opção     |");
        System.out.println("+---------------------------+");
        System.out.println("| 1 - Cadastrar autor       |");
        System.out.println("| 2 - Listar autores        |");
        System.out.println("| 3 - Cadastrar livro       |");
        System.out.println("| 4 - Listar livros         |");
        System.out.println("| 5 - Remover livro         |");
        System.out.println("| 6 - Mudar status de livro |");
        System.out.println("| 7 - Cadastrar editora     |");
        System.out.println("| 8 - Listar editoras       |");
        System.out.println("| 9 - Cadastrar gênero      |");
        System.out.println("| 10 - Listar gêneros       |");
        System.out.println("| 0 - Sair                  |");
        System.out.println("+---------------------------+");

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
            case 0 -> {
                System.out.println("Encerrando o programa");
                System.exit(0);
            }
            case 1 -> adicionarAutor();
            case 2 -> buscarAutores();
            case 3 -> adicionarLivro();
            case 4 -> buscarLivros();
            case 5 -> removerLivro();
            case 6 -> atualizarLivro();
            case 7 -> adicionarEditora();
            case 8 -> buscarEditoras();
            case 9 -> adicionarGenero();
            case 10 -> buscarGeneros();
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
            System.out.println("Não foi possível adicionar o autor: "+e.getMessage());
        }
    }

    public static void buscarAutores() {
        try {
            System.out.println("===============================");
            System.out.println("||    AUTORES CADASTRADOS    ||");
            System.out.println("===============================");
            List<Autor> autores = autorService.listarAutores();

            if(autores.isEmpty()) {
                System.out.println("Nenhum autor cadastrado");
                return;
            }

            for(Autor autor : autores) {
                System.out.println(autor.getNome());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void adicionarLivro() {
        try {
            System.out.println("Adicionar novo livro");
            System.out.println("Título: ");
            String titulo = teclado.nextLine();
            System.out.println("Ano de publicação: ");
            int ano = teclado.nextInt();
            System.out.println("Edição: ");
            int edicao = teclado.nextInt();

            System.out.println("Status: (1 - DISPONIVEL / 2 - EMPRESTADO)");
            int statusOpcao = teclado.nextInt();
            StatusLivro status;
            switch (statusOpcao) {
                case 1 -> status = StatusLivro.DISPONIVEL;
                case 2 -> status = StatusLivro.EMPRESTADO;
                default -> {
                    System.out.println("Opção inválida");
                    return;
                }
            }

            System.out.println("Número de páginas: ");
            int paginas = teclado.nextInt();
            System.out.println("ID da editora: ");
            int editora = teclado.nextInt();
            System.out.println("ID do autor");
            int autor = teclado.nextInt();
            System.out.println("ID do gênero");
            int genero = teclado.nextInt();

            Livro livro = new Livro(titulo, ano, edicao, paginas, editora, autor, genero, status);
            livroService.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Não foi possível adicionar o livro: "+e.getMessage());
        }
    }

    public static void buscarLivros() {
        try {
            System.out.println("===========================");
            System.out.println("||   LIVROS CADASTRADOS  ||");
            System.out.println("===========================");
            List<Livro> livros = livroService.listarLivros();

            if(livros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado");
                return;
            }

            for (Livro livro : livros) {
                System.out.println("["+livro.getStatusLivro().name()+"] "+livro.getId()+". "+livro.getTitulo()+" ("+ livro.getAnoPublicacao()+")");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removerLivro() {
        System.out.println("Digite o ID do livro a ser removido: ");
        int id = teclado.nextInt();

        try {
            livroService.removerLivro(id);
            System.out.println("Livro removido com sucesso");
        } catch (Exception e) {
            System.out.println("Não foi possível remover o livro: "+e.getMessage());
        }
    }

    public static void atualizarLivro() {
        System.out.println("Digite o ID do livro: ");
        int id = teclado.nextInt();
        System.out.println("Digite o novo status (1 - DISPONIVEL / 2 - EMPRESTADO) ");
        int statusOpcao = teclado.nextInt();

        StatusLivro status;
        switch (statusOpcao) {
            case 1 -> status = StatusLivro.DISPONIVEL;
            case 2 -> status = StatusLivro.EMPRESTADO;
            default -> {
                System.out.println("Opção inválida");
                return;
            }
        }

        try {
            boolean atualizado = livroService.atualizarStatus(id, status);

            if(atualizado) {
                System.out.println("Status do livro atualizado com sucesso!");
            } else {
                System.out.println("Livro não encontrado");
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o status: "+e.getMessage());
        }
    }

    public static void adicionarEditora() {
        try {
            System.out.println("Nome: ");
            String nome = teclado.nextLine();

            Editora editora = new Editora(nome);
            editoraService.adicionarEditora(editora);
            System.out.println("Editora adicionada com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível adicionar a editora: "+e.getMessage());
        }
    }

    public static void buscarEditoras() {
        try {
            System.out.println("================================");
            System.out.println("||    EDITORAS CADASTRADAS    ||");
            System.out.println("================================");
            List<Editora> editoras = editoraService.listarEditoras();

            if(editoras.isEmpty()) {
                System.out.println("Nenhuma editora cadastrada");
            }

            for(Editora editora : editoras) {
                System.out.println(editora.getNome());
            }
        } catch (Exception e) {
            System.out.println("Não foi possível listar editoras: "+e.getMessage());
        }
    }

    public static void adicionarGenero() {
        try {
            System.out.println("Adicionando novo gênero: ");
            String nome = teclado.nextLine();

            Genero genero = new Genero(nome);
            generoService.adicionarGenero(genero);
            System.out.println("Gênero adicionado com sucesso!");

        } catch (Exception e) {
            System.out.println("Não foi possível adicionar o gênero: "+e.getMessage());
        }
    }

    public static void buscarGeneros() {
        try {
            System.out.println("===============================");
            System.out.println("||    GÊNEROS CADASTRADOS    ||");
            System.out.println("===============================");
            List<Genero> generos = generoService.listarGeneros();

            if(generos.isEmpty()) {
                System.out.println("Nenhum gênero cadastrado.");
            }

            for(Genero genero : generos) {
                System.out.println(genero.getNome());
            }
        } catch (Exception e) {
            System.out.println("Não foi possível listar os gêneros: "+e.getMessage());
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
}

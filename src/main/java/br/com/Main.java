package br.com;

import br.com.model.Categoria;
import br.com.service.CategoriaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "PostgresPU"
        );
        em = emf.createEntityManager();

        CategoriaService categoriaService = new CategoriaService(em);

        boolean continuar = true;

        while(continuar){
            System.out.println("------MENU-------");
            System.out.println("1.Cadastrar categoria");
            System.out.println("2.Alterar categoria");
            System.out.println("3.Excluir categoria");
            System.out.println("4. Consultar Categoria por ID");
            System.out.println("5. Listar todas as Categorias");
            System.out.println("0.Sair");
            System.out.println("Escolha uma opção");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1 -> cadastrarCategoria(categoriaService);
                case 2 -> alterarCategoria(categoriaService);
                case 3 -> excluirCategoria(categoriaService);
                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida");
            }
        }
        em.close();
        emf.close();
        System.out.println("Programa encerrado");
    }

    private static void excluirCategoria(CategoriaService categoriaService) {
        System.out.println("Informe o ID da categoria a ser excluida");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        if(categoria != null){
            categoriaService.excluir(categoria);
            System.out.println("Categoria excluida com sucesso");
        }else{
            System.out.println("Categoria não encontrada");
        }
    }

    private static void alterarCategoria(CategoriaService categoriaService) {
        System.out.println("Informe o ID da categoria a ser alterada");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        if(categoria != null){
            System.out.println("Digite o novo nome para a categoria");
            categoria.setNome(scanner.nextLine());
            categoriaService.alterar(categoria);
            System.out.println("Categoria alterada com sucesso");
        }else{
            System.out.println("Categoria não encontrada");
        }
    }

    private static void cadastrarCategoria(CategoriaService categoriaService) {
        System.out.println("Digite o nome da categoria");
        String nome = scanner.nextLine();
        Categoria categoria = new Categoria(nome);
        categoriaService.inserir(categoria);
        System.out.println("Categoria cadastrada com sucesso!");
    }
}
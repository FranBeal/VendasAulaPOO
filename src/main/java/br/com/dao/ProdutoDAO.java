package br.com.dao;

import br.com.model.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.persist(produto);
        this.em.getTransaction().commit();
    }

    public void atualizar(Produto produto) {
        this.em.getTransaction().begin();
        this.em.merge(produto);
        this.em.getTransaction().commit();
    }

    public void remover(Produto produto) {
        this.em.getTransaction().begin();
        this.em.remove(produto);
        this.em.getTransaction().commit();
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorCategoria(long idCategoria) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.id = :id";
        return em.createQuery(jpql, Produto.class)
                .setParameter("id", idCategoria)
                .getResultList();
    }

}

package br.com.service;

import br.com.dao.CategoriaDAO;
import br.com.model.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaService {

    private CategoriaDAO categoriaDao;

    public CategoriaService(EntityManager em){
        categoriaDao = new CategoriaDAO(em);
    }

    public void inserir(Categoria categoria){
        categoriaDao.cadastrar(categoria);
    }

    public void alterar(Categoria categoria){
        categoriaDao.atualizar(categoria);
    }

    public void excluir(Categoria categoria){
        categoriaDao.remover(categoria);
    }

    public Categoria buscarCategoriaPorId(long id){
        return categoriaDao.buscarPorId(id);
    }

    public List<Categoria> buscarTodasAsCategorias(){
        return categoriaDao.buscarTodos();
    }
}

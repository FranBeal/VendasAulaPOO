package br.com.dao;

import br.com.model.Cliente;
import br.com.model.Produto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteService {

    private ClienteDAO clienteDao;

    public ClienteService(EntityManager em){
        clienteDao = new ClienteDAO(em);
    }

    public void inserir(Cliente cliente){
        clienteDao.cadastrar(cliente);
    }

    public void alterar(Cliente cliente){
        clienteDao.atualizar(cliente);
    }

    public void excluir(Cliente cliente){
        clienteDao.remover(cliente);
    }

    public Cliente buscarClientePorId(long id){
        return clienteDao.buscarPorId(id);
    }

    public List<Cliente> buscarTodosOsClientes(){
        return clienteDao.buscarTodos();
    }
}

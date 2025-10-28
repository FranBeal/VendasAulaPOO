package br.com.service;

import br.com.dao.PedidoDAO;
import br.com.model.Pedido;
import br.com.model.PedidoItem;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PedidoService {
    private PedidoDAO pedidoDao;

    public PedidoService(EntityManager em){
        this.pedidoDao = new PedidoDAO(em);
    }

    public void inserir(Pedido pedido){
        pedidoDao.cadastrar(pedido);
    }

    public void alterar(Pedido pedido){
        pedidoDao.atualizar(pedido);
    }

    public void excluir(Pedido pedido){
        pedidoDao.remover(pedido);
    }

    public void excluirItem(PedidoItem pedidoItem){pedidoDao.removerItem(pedidoItem); }

    public Pedido buscarPedidoPorId(long id){
        return pedidoDao.buscarPedidoPoriD(id);
    }

    public List<Pedido> buscarPedidoPorPeriodo(LocalDate dataIni, LocalDate dataFim){
        return pedidoDao.buscarPedidosPorPeriodo(dataIni, dataFim);
    }

    public List<Pedido> buscarPedidoDeUmCliente(long id){
        return pedidoDao.buscarPedidosDeUmCliente(id);
    }
}

package br.com.service;

import br.com.dao.VendaDAO;
import br.com.vo.RelatorioDeVendasVo;
import br.com.vo.RelatorioFinanceiroVo;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VendaService {
    private VendaDAO vendaDAO;

    public VendaService(EntityManager em){
        this.vendaDAO = new VendaDAO(em);
    }

    public BigDecimal retornaValorTotalVendido(
            LocalDate dataIni, LocalDate dataFim
    ){
        return this.vendaDAO.retornaValorTotalVendidoNoPeriodo(dataIni, dataFim);
    }

    public List<RelatorioDeVendasVo> retornaRelatorioDeVendas()
    {
        return this.vendaDAO.relatorioDeVendas();
    }

    public List<RelatorioFinanceiroVo> retornaRelatorioFinanceiro(){
        return this.vendaDAO.relatorioFinanceiro();
    }
}

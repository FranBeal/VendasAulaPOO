package br.com.vo;

import java.math.BigDecimal;

public class RelatorioFinanceiroVo {
    String nomeCliente;
    BigDecimal totalPedidosDoCliente;

    public RelatorioFinanceiroVo(String nomeCliente,
                                 BigDecimal totalPedidosDoCliente){
        this.nomeCliente = nomeCliente;
        this.totalPedidosDoCliente = totalPedidosDoCliente;
    }

    public String toString(){
        return "RelatorioFinanceiroVo [nomeCliente=" + nomeCliente +
                ", TotalPedidosCliente=" + totalPedidosDoCliente + "]";
    }
}


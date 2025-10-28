package br.com.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {
    private String nomeProduto;
    private Long quantidadeVendida;
    private LocalDate dataUltimaVenda;

    public RelatorioDeVendasVo(String nomeProduto,
                               Long quantidadeVendida,
                               LocalDate dataUltimaVenda){
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    public String toString(){
        return "RelatorioDeVendaVO [nomProduto="+ this.nomeProduto+
                ", quandiade="+this.quantidadeVendida+
                ", dataUltimaVenda="+this.dataUltimaVenda+"]";
    }
}

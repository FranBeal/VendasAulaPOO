package br.com.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido_itens")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_unitario") // Mapeia o atributo para a coluna 'preco_unitario' no banco.
    private BigDecimal precoUnitario;

    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY) // Relacionamento muitos-para-um com a entidade Pedido.
    private Pedido pedido; // Pedido ao qual este item pertence.

    @ManyToOne(fetch = FetchType.LAZY) // Relacionamento muitos-para-um com a entidade Produto.
    private Produto produto; // Produto relacionado a este item.

    public PedidoItem() {
    }

    public PedidoItem(int quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.precoUnitario = produto.getPreco();
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    // Calcula e retorna o valor total do item (preço unitário * quantidade).
    public BigDecimal getValor() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }
}

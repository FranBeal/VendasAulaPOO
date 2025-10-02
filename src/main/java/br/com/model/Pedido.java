package br.com.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total") // Define o nome da coluna no banco como 'valor_total'.
    private BigDecimal valorTotal = BigDecimal.ZERO; // Armazena o valor total do pedido, iniciando com zero.

    private LocalDate data = LocalDate.now(); // Armazena a data do pedido, inicializando com a data atual.

    @ManyToOne(fetch = FetchType.LAZY) // Relacionamento muitos-para-um com a entidade Cliente.
    private Cliente cliente; // Cliente associado ao pedido.

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // Relacionamento um-para-muitos, bidirecional, com a entidade PedidoItem.
    private List<PedidoItem> itens = new ArrayList<>(); // Lista de itens do pedido.

    public Pedido() {
    }

    // Construtor que inicializa o pedido com um cliente.
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    // Metodo para adicionar um item ao pedido.
    public void adicionarItem(PedidoItem item) {
        item.setPedido(this); // Define a referência do pedido no item.
        this.getItens().add(item); // Adiciona o item à lista.
        processaValorTotal(); // Atualiza o valor total do pedido.
    }

    // Metodo para remover um item do pedido.
    public void removerItem(PedidoItem item) {
        this.getItens().remove(item); // Remove o item da lista.
        processaValorTotal(); // Atualiza o valor total do pedido.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{")
                .append("id=").append(id)
                .append(", valorTotal=").append(valorTotal)
                .append(", data=").append(data)
                .append(", cliente=").append(cliente.getNome())
                .append(", itens=[");

        for (int i = 0; i < itens.size(); i++) {
            PedidoItem item = itens.get(i);
            sb.append("{")
                    .append("produto=").append(item.getProduto().getNome())
                    .append(", quantidade=").append(item.getQuantidade())
                    .append(", valor=").append(item.getValor())
                    .append("}");
            if (i < itens.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    // Metodo privado para calcular e atualizar o valor total do pedido com base nos itens.
    private void processaValorTotal() {
        BigDecimal total = itens.stream() // Processa a lista de itens.
                .map(PedidoItem::getValor) // Mapeia os valores dos itens.
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Soma os valores.
        this.valorTotal = total; // Atualiza o valor total do pedido.
    }
}

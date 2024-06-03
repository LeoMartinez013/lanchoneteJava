package com.atvPOO.lanchonete.Models.pedido;

import java.util.ArrayList;
import java.util.List;

import com.atvPOO.lanchonete.Models.itemPedido.ItemPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "cd_IdPedido")
    private int id;

    @Column(name = "nm_Cliente")
    private String cliente;

    @Column(name = "ic_Entregar")
    private boolean entregar;

    @Column(name = "ds_Endereco")
    private String endereco;

    @Column(name = "ic_Pronto")
    private boolean pronto;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    @Transient
    private List<Integer> itensCardapioSelecionados;

    public Pedido() {
        itensCardapioSelecionados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean isEntregar() {
        return entregar;
    }

    public void setEntregar(boolean entregar) {
        this.entregar = entregar;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public List<Integer> getItensCardapioSelecionados() {
        return itensCardapioSelecionados;
    }

    public void setItensCardapioSelecionados(List<Integer> itensCardapioSelecionados) {
        this.itensCardapioSelecionados = itensCardapioSelecionados;
    }

    /**
     * Soma os preços de todos os itens do pedido
     */
    public double getTotal() {
        double total = 0;
        for (ItemPedido itemPedido : itensPedido) {
            total += itemPedido.getItemCardapio().getPreco() 
                // * itemPedido.getQuantidade()
                ;
        }
        return total;
    }
}


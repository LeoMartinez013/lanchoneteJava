package com.atvPOO.lanchonete.Models.itemCardapio;

import java.util.List;

import com.atvPOO.lanchonete.Models.itemPedido.ItemPedido;
import com.atvPOO.lanchonete.Models.pedido.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "itemcardapio")
public class ItemCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "cd_IdItemCardapio ")
    private int id;

    @Column(name = "nm_ItemCardapio")
    private String nome;

    @Column(name = "ds_Componentes")
    private String componentes;

    @Column(name = "vl_Preco")
    private double preco;
    
    @OneToMany(mappedBy = "itemCardapio")
    private List<ItemPedido> itensPedido;

    public ItemCardapio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    
    
}
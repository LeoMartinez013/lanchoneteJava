package com.atvPOO.lanchonete.Models.itemPedido;

import com.atvPOO.lanchonete.Models.itemCardapio.ItemCardapio;
import com.atvPOO.lanchonete.Models.pedido.Pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itempedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "cd_IdItemPedido")
    private int id;

    @Column(name = "ic_Pronto")
    private boolean isPronto;

    @ManyToOne
    @JoinColumn(name = "cd_IdPedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "cd_ItemCardapio", nullable = false)
    private ItemCardapio itemCardapio;

    public ItemPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPronto() {
        return isPronto;
    }

    public void setPronto(boolean isPronto) {
        this.isPronto = isPronto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    
}

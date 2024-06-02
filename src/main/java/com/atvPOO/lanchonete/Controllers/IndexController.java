package com.atvPOO.lanchonete.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.atvPOO.lanchonete.Models.itemCardapio.*;
import com.atvPOO.lanchonete.Models.itemPedido.*;
import com.atvPOO.lanchonete.Models.pedido.*;

@Controller
public class IndexController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemCardapioService itemCardapioService;

    @Autowired
    private ItemPedidoService itemPedidoService;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("todosPedidos", pedidoService.getPedidosProntos());
        model.addAttribute("todosItens", itemCardapioService.getAllItemCardapio());
        return "index";
    }
    
    @PostMapping("/pedido")
    public String submitPedido(@ModelAttribute Pedido pedido) {
        Pedido savedPedido = pedidoService.savePedido(pedido);
        for (int itemId : pedido.getItensCardapioSelecionados()) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(savedPedido);
            itemPedido.setItemCardapio(itemCardapioService.getItemCardapio(itemId));
            itemPedidoService.saveItemPedido(itemPedido);
        }
        return "redirect:/";
    }

    @GetMapping("/cardapio")
    public String cardapio(Model model) {
        model.addAttribute("itemCardapio", new ItemCardapio());
        model.addAttribute("todosItens", itemCardapioService.getAllItemCardapio());
        return "cardapio";
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model) {
        model.addAttribute("todosPedidos", pedidoService.getAllPedidos());
        return "pedidos";
    }

    @GetMapping("/pedidos/prontos")
    public String pedidosProntos(Model model) {
        model.addAttribute("todosPedidos", pedidoService.getPedidosProntos());
        return "pedidos";
    }

    @PostMapping("/concluir/{id}")
    public String concluirPedido(@PathVariable int id) {
        Pedido pedido = pedidoService.getPedido(id);
        pedido.setPronto(true);
        pedidoService.savePedido(pedido);
        return "redirect:/pedidos";
    }

    @PostMapping("/apagar/pedido/{id}")
    public String deletarPedido(@PathVariable int id) {
        Pedido pedido = pedidoService.getPedido(id);
        for (ItemPedido itemPedido : pedido.getItensPedido()) {
            itemPedidoService.deleteItemPedido(itemPedido.getId());
        }
        pedidoService.deletePedido(id);
        return "redirect:/";
    }

    @DeleteMapping("/apagar/itemcardapio/{id}")
    public String deletarItemCardapio(@PathVariable int id) {
        ItemCardapio itemCardapio = itemCardapioService.getItemCardapio(id);
        for (ItemPedido itemPedido : itemCardapio.getItensPedido()) {
            itemPedidoService.deleteItemPedido(itemPedido.getId());
        }
        itemCardapioService.deleteItemCardapio(id);
        return "redirect:/cardapio";
    }

    @PostMapping("/itemCardapio")
    public String submitItemCardapio(@ModelAttribute ItemCardapio itemCardapio) {
        itemCardapioService.saveItemCardapio(itemCardapio);
        return "redirect:/cardapio";
    }
}

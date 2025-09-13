package com.example.pedidos.controller;

import com.example.pedidos.model.Cliente;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> getCliente(){
        return clienteService.listarTodosClientes();
    }

    @GetMapping("clientes/{id}/pedidos")
    public List<Pedido> getPedidosDoCliente(@PathVariable Long id){
        return clienteService.listarPedidosPorCliente(id);
    }

    @GetMapping("clientes/{id}/pedidos/contar")
    public Long contarPedidosDoCliente(@PathVariable Long id){
        return clienteService.contarPedidosPorCliente(id);
    }


}
package com.example.pedidos.controller;

import com.example.pedidos.model.Cliente;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> getCliente(){
        System.out.println("Chegouuuu" + clienteService.listarTodosClientes());
        return clienteService.listarTodosClientes();
    }

    @PostMapping("/adicionar_clientes")
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        System.out.println("Clienteeee = " + cliente);
        return clienteService.adicionarCliente(cliente);
    }

    @PostMapping("/clientes/{id}/pedidos")
    public Pedido adicionarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return clienteService.adicionarPedido(id, pedido);
    }

    @GetMapping("clientes/{id}/pedidos")
    public List<Pedido> getPedidosDoCliente(@PathVariable Long id){
        return clienteService.listarPedidosPorCliente(id);
    }

    @GetMapping("clientes/{id}/pedidos/contar")
    public Long contarPedidosDoCliente(@PathVariable Long id){
        return clienteService.contarPedidosPorCliente(id);
    }

    @PutMapping("/clientes/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }


    @DeleteMapping("/clientes/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    @PutMapping("/pedidos/{id}")
    public Pedido atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return clienteService.atualizarPedido(id, pedido);
    }

    @DeleteMapping("/pedidos/{id}")
    public void deletarPedido(@PathVariable Long id) {
        clienteService.deletarPedido(id);
    }

}
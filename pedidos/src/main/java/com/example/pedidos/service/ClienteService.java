package com.example.pedidos.service;

import com.example.pedidos.model.Cliente;
import com.example.pedidos.model.Pedido;

import com.example.pedidos.repository.ClienteRepository;
import com.example.pedidos.repository.PedidoRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepo;
    private final PedidoRepository pedidoRepo;

    public ClienteService (ClienteRepository clienteRepo,
                           PedidoRepository pedidoRepo){
        this.clienteRepo = clienteRepo;
        this.pedidoRepo = pedidoRepo;
    }

    public List<Cliente> listarTodosClientes(){
        return clienteRepo.findAll();
    }

    public List<Pedido> listarPedidosPorCliente(Long clienteId){
        return pedidoRepo.findByClienteId(clienteId);
    }

    public Long contarPedidosPorCliente(Long clienteId){
        return pedidoRepo.countByClienteId(clienteId);
    }

    public Cliente adicionarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Pedido adicionarPedido(Long clienteId, Pedido pedido) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id " + clienteId));
        pedido.setCliente(cliente);
        return pedidoRepo.save(pedido);
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return clienteRepo.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    return clienteRepo.save(cliente);
                })
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id " + id));
    }

    public void deletarCliente(Long id) {
        if (!clienteRepo.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com id " + id);
        }
        clienteRepo.deleteById(id);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return pedidoRepo.findById(id)
                .map(pedido -> {
                    pedido.setDescricao(pedidoAtualizado.getDescricao());
                    pedido.setCliente(pedidoAtualizado.getCliente());
                    return pedidoRepo.save(pedido);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com id " + id));
    }

    public void deletarPedido(Long id) {
        if (!pedidoRepo.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado com id " + id);
        }
        pedidoRepo.deleteById(id);
    }

}
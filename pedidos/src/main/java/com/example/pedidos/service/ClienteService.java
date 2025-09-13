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

}
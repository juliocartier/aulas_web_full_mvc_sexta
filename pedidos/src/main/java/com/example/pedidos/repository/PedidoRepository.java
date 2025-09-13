package com.example.pedidos.repository;

import com.example.pedidos.model.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    Long countByClienteId(Long cliente_id);
}
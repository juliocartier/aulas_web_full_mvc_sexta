package com.example.pedidos;

import com.example.pedidos.model.Cliente;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final ClienteRepository clienteRepo;

    public DataLoader (ClienteRepository clienteRepo){
        this.clienteRepo = clienteRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente();
        c1.setNome("Joao Maia");
        c1.setEmail("joaomaia@email.com");

        Pedido p1 = new Pedido();
        p1.setDescricao("Pedido 1");
        p1.setCliente(c1);

        Pedido p2 = new Pedido();
        p2.setDescricao("Pedido 2");
        p2.setCliente(c1);

        c1.setPedidos(List.of(p1, p2));
        clienteRepo.save(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Maria Moreira");
        c2.setEmail("mariamoreira@email.com");

        Pedido p3 = new Pedido();
        p3.setDescricao("Pedido 3");
        p3.setCliente(c2);

        c2.setPedidos(List.of(p3));
        clienteRepo.save(c2);

    }
}
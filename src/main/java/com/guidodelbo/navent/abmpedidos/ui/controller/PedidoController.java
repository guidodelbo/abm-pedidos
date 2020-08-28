package com.guidodelbo.navent.abmpedidos.ui.controller;

import com.guidodelbo.navent.abmpedidos.service.PedidoService;
import com.guidodelbo.navent.abmpedidos.ui.model.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<String> addPedido(@RequestBody PedidoDTO receivedPedido) {
        service.savePedido(receivedPedido);
        return new ResponseEntity<>("Pedido agregado exitosamente.", HttpStatus.OK);
    }

    @GetMapping(path = "/{idPedido}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Integer idPedido) {
        return new ResponseEntity<>(service.getPedido(idPedido), HttpStatus.OK);
    }

    @PutMapping(path = "/{idPedido}")
    public ResponseEntity<?> updatePedido(@PathVariable Integer idPedido, @RequestBody PedidoDTO receivedPedido) {
        service.updatePedido(idPedido, receivedPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{idPedido}")
    public ResponseEntity<?> deletePedido(@PathVariable Integer idPedido) {
        service.deletePedido(idPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

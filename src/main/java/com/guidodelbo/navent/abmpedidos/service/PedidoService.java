package com.guidodelbo.navent.abmpedidos.service;

import com.guidodelbo.navent.abmpedidos.ui.model.PedidoDTO;

public interface PedidoService {
    void savePedido(PedidoDTO pedidoDTO);
    PedidoDTO getPedido(Integer idPedido);
    void updatePedido(Integer idPedido, PedidoDTO pedidoDTO);
    void deletePedido(Integer idPedido);
}

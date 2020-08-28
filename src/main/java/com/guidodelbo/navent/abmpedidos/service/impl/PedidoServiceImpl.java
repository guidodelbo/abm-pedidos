package com.guidodelbo.navent.abmpedidos.service.impl;

import com.guidodelbo.navent.abmpedidos.exception.PedidoServiceException;
import com.guidodelbo.navent.abmpedidos.io.cache.BumexMemcached;
import com.guidodelbo.navent.abmpedidos.io.dao.PedidoDAO;
import com.guidodelbo.navent.abmpedidos.io.entity.PedidoEntity;
import com.guidodelbo.navent.abmpedidos.service.PedidoService;
import com.guidodelbo.navent.abmpedidos.ui.model.PedidoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePedido(PedidoDTO pedidoDTO) {
        if(Objects.nonNull(PedidoDAO.select(pedidoDTO.getIdPedido())))
            throw new PedidoServiceException("El pedido ya existe.");

        PedidoDAO.insertOrUpdate(mapper.map(pedidoDTO, PedidoEntity.class));
    }

    @Override
    public PedidoDTO getPedido(Integer idPedido) {
        PedidoEntity pedidoCache = (PedidoEntity) BumexMemcached.getInstance().get(idPedido.toString());

        if(Objects.nonNull(pedidoCache))
            return mapper.map(pedidoCache, PedidoDTO.class);

        PedidoEntity pedidoEntity = PedidoDAO.select(idPedido);

        if(Objects.isNull(pedidoEntity))
            throw new PedidoServiceException("No existe un pedido con ID: " + idPedido + ".");

        BumexMemcached.getInstance().set(pedidoEntity.getIdPedido().toString(), pedidoEntity);

        return mapper.map(pedidoEntity, PedidoDTO.class);
    }

    @Override
    public void updatePedido(Integer idPedido, PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = PedidoDAO.select(idPedido);

        if(Objects.isNull(pedidoEntity))
            throw new PedidoServiceException("No existe un pedido con ID: " + idPedido + ".");


        pedidoEntity.setNombre(pedidoDTO.getNombre());
        pedidoEntity.setMonto(pedidoDTO.getMonto());
        pedidoEntity.setDescuento(pedidoDTO.getDescuento());

        PedidoDAO.insertOrUpdate(pedidoEntity);
        BumexMemcached cache = BumexMemcached.getInstance();

        if(Objects.nonNull(cache.get(idPedido.toString()))) {
            cache.delete(idPedido.toString());
            cache.set(idPedido.toString(), pedidoEntity);
        }
    }

    @Override
    public void deletePedido(Integer idPedido) {
        PedidoEntity pedidoEntity = PedidoDAO.select(idPedido);

        if(Objects.isNull(pedidoEntity))
            throw new PedidoServiceException("No existe un pedido con ID: " + idPedido + ".");

        BumexMemcached.getInstance().delete(idPedido.toString());
        PedidoDAO.deletePedido(pedidoEntity);
    }
}

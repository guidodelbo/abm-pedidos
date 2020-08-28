package com.guidodelbo.navent.abmpedidos.ui.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = -1734090878752321391L;

    private Integer idPedido;
    private String nombre;
    private BigDecimal monto;
    private Integer descuento;

    public PedidoDTO() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
}

package com.guidodelbo.navent.abmpedidos.exception;

public class PedidoServiceException extends RuntimeException{
    private static final long serialVersionUID = 5575930620220118915L;

    public PedidoServiceException(String message) {
        super(message);
    }
}

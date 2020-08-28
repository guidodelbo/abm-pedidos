$(document).ready(() => {
  new Pedido();
});

class Pedido {
  constructor() {
    this.setSubmitEvent();
  }

  setSubmitEvent() {
    $("#form-abm").submit((event) => {
      event.preventDefault();
      let data = {};
      data.nombre = $("#name").val();
      data.monto = $("#amount").val();
      data.descuento = $("#discount").val();
      this.sendData(data);
      $("#form-abm")[0].reset();
    });
  }

  sendData(data) {
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/abm-pedidos/pedidos",
      contentType: "application/json",
      dataType: "json",
      data: JSON.stringify(data),
      success: (msg, status, jqXHR) => {
        alert(msg.responseText);
      },
      error: (request, status, error) => {
        alert(request.responseText);
      },
    });
  }
}

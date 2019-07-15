
$(document).ready(() => {

    const alertBoxes = document.querySelectorAll(".flash-msg");

    if (alertBoxes.length > 0) {
        alertBoxes.forEach((box) => {
            setTimeout(() => {
                box.remove();
            }, 2500);
        })
    }

    //* AUTO COMPLETE 
    var productoField = $("#buscar_producto");

    productoField.autocomplete({
        source: (req, res) => {
            $.ajax({
                url: "/factura/cargar-productos/" + req.term,
                dataType: "json",
                data: {
                    term: req.term
                },
                success: (data) => {
                    res($.map(data, (item) => {
                        return {
                            value: item.id,
                            label: item.nombre,
                            precio: item.precio
                        }
                    }));
                }
            });
        },
        select: (event, ui) => {
            productoField.val(ui.item.label);
            return false;
        }
    });
});
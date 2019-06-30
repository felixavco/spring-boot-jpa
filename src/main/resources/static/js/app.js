const alertBoxes = document.querySelectorAll(".flash-msg");

if (alertBoxes.length > 0) {
    alertBoxes.forEach((box) => {
        setTimeout(() => {
            box.remove();
        }, 2500);
    })
}
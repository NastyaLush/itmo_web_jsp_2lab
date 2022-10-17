export class ValidationFromGraph {

    createHTTPReq(event) {

        const r = $('input[name="r"]:checked').val();
        if (null == r) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'You should choose r!',
            })
        } else {
            let x = event.clientX;
            let y = event.clientY;
            const leftX = document.getElementById("square").getBoundingClientRect().left;
            const rightX = document.getElementById("sector").getBoundingClientRect().right;
            const topY = document.getElementById("sector").getBoundingClientRect().top;
            const bottomY = document.getElementById("triangle").getBoundingClientRect().bottom;

            //count cordX
            x = ((x - leftX / 2 - rightX / 2) * 2 * r) / (rightX - leftX);
            //count cordY
            y = ((y - topY / 2 - bottomY / 2) * 2 * r) / (-bottomY + topY);

            $.get('ControllerServlet', {x: x, y: y, r: r}, function (data) {
                console.log(data); // ответ от сервера
            }).success(function (data) {
                $('.content__scroll_table_row:not(#head_table)').remove();
                $('#head_table').after(data);
                let bubble = $('<div class="bubble" id="bubble" name="bubble"></div>');
                bubble.css({'left': event.layerX, 'top': event.layerY });
                $('#canvas').append(bubble);
            })
                .error(function () {
                    console.log('execute error');
                })
                .complete(function () {
                    console.log('execute finished');
                });


        }
    }
}
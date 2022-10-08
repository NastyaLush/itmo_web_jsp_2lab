export class ValidationFromGraph{

    createHTTPReq(event){

        const r = $('input[name="r"]:checked').val();
        if(r!=null){
            let x= event.clientX;
            let y= event.clientY;
            const leftX = document.getElementById("square").getBoundingClientRect().left;
            const rightX = document.getElementById("sector").getBoundingClientRect().right;
            const topY = document.getElementById("sector").getBoundingClientRect().top;
            const buttomY = document.getElementById("triangle").getBoundingClientRect().bottom;

           //count coordX
            x= ((x-leftX/2 - rightX/2) * 2*r)/(rightX - leftX);
            //count coordY
            y= ((y-topY/2 - buttomY/2) * 2*r)/(-buttomY + topY);

            $.get('ControllerServlet', {x: x, y: y, r: r}, function(data) {
                console.log(data); // ответ от сервера
            })
                .success(function() {
                    sessionStorage.setItem("points", JSON.stringify({left: event.layerX, top: event.layerY}));
                    console.log(sessionStorage.getItem("points").toString())
                    location.reload();

                })
                .error(function(jqXHR) { console.log('Ошибка выполнения'); })
                .complete(function() { console.log('Завершение выполнения'); });



        } else{
            Swal.fire({
                icon: 'warning',
                title: 'Oops...',
                text: 'You should choose r!',
            })
        }
    }
}
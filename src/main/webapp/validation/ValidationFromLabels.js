import {changeClass} from "./Utils.js";

export class ValidationFromLabels {
    constructor() {
        this.y = document.getElementById("y");
        this.x = document.getElementById("x");
        this.log_y = document.getElementById("log_y");
        this.log_r = document.getElementById("log_r");
        this.button = document.getElementById("send");
    }

    validY() {
        if (this.y.value < -5 || this.y.value > 3 || isNaN(this.y.value) || this.y.value == '') {
            changeClass(this.log_y, "content__labels_no-error", "content__labels_error");
            changeClass(this.y, "content__labels_y_no-warning", "content__labels_y_warning");
            return false;
        }
        changeClass(this.log_y, "content__labels_error", "content__labels_no-error");
        changeClass(this.y, "content__labels_y_warning", "content__labels_y_no-warning");
        return true;
    }

    validR() {
        if ($('input[name="r"]:checked').val() == null) {
            changeClass(this.log_r, "content__labels_no-error", "content__labels_error");
            return false;
        }
        changeClass(this.log_r, "content__labels_error", "content__labels_no-error");
        return true;
    }

    validation(expression) {
        if (expression) {
            changeClass(this.button, "content__labels_no-active", "content__labels_active");
        } else {
            changeClass(this.button, "content__labels_active", "content__labels_no-active");
        }
    }

    sendResponse() {
        console.log("dd")
        if (this.validY() && this.validR()) {
            console.log(this.x.value, 4);
            $.get('ControllerServlet', {
                x: this.x.value,
                y: this.y.value,
                r: $('input[name="r"]:checked').val()
            }, function (data) {
                console.log(data); // ответ от сервера
            })
                .success(function () {
                    location.reload()
                })
                .error(function (jqXHR) {
                    console.log('Ошибка выполнения');
                })
                .complete(function () {
                    console.log('Завершение выполнения');
                });
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Check x, y and r labels!',
            })
        }
    }

}

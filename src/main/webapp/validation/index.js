"use strict";

import {ValidationFromLabels} from "./ValidationFromLabels.js";
import {ValidationFromGraph} from "./ValidatorFromGraph.js";

const valid = new ValidationFromLabels();
document.getElementById("y").addEventListener(('change'), () => {
    valid.validation(valid.validY() && valid.validR())});
document.getElementById("content__canvas").addEventListener(('click'), (event) =>{
    new ValidationFromGraph().createHTTPReq(event);
});
document.getElementsByName("r").forEach((value)=>{
    value.addEventListener(('change'), () => {
        valid.validation(valid.validR() && valid.validY())});
});
document.getElementById("send").addEventListener(("click"), ()=>{
    valid.sendResponse();
});
let point =  JSON.parse(sessionStorage.getItem("points"));
if(point != null) {
    let bubble = $('<div class="bubble" id="bubble" name="bubble"></div>');
    bubble.css({'left': point.left, 'top': point.top});
    $('#canvas').append(bubble);
}


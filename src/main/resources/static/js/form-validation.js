(function(){
    "use strict";
    const title = document.querySelector("#title");
    const body = document.querySelector("#body");
    const form = document.querySelector('.form')[0];
    const submitBtn = document.querySelector('#submit-btn');

    let validTitle = false;
    let validBody = false;

    const validateForm = () => {
        if(validTitle && validBody) {
            form.submit();
        }
    };

    const validBtn = e => {
        if (validBody && validTitle){
            submitBtn.style.backgroundColor = "#76cc7d";
            submitBtn.removeAttribute("disabled");
        } else {
            submitBtn.style.backgroundColor = "#ffbfb0";
            submitBtn.setAttribute("disabled","");
        }
    };

    //Check the initial value of title and body
    if (title.value.length >= 5){
        validTitle = true;
        title.style.backgroundColor = "#76cc7d";
    } else {
        title.style.backgroundColor = "#ffbfb0";
    }
    if (body.value.length >= 50){
        validBody = true;
        body.style.backgroundColor = "#76cc7d";
    } else {
        body.style.backgroundColor = "#ffbfb0";
    }

    //Check initial state and set button color
    validBtn();
    form.addEventListener("submit", (e) => e.preventDefault());
    submitBtn.addEventListener('click', function(){
        validateForm();
    });
    title.addEventListener('keyup', () => {
        if (title.value.length < 5){
            validTitle = false;
            title.style.backgroundColor = "#ffbfb0";
            validBtn();
        } else {
            validTitle = true;
            validBtn();
            title.style.backgroundColor = "#76cc7d";
        }
    });

    body.addEventListener("keyup", () => {
        if (body.value.length < 50){
            validBody = false;
            body.style.backgroundColor = "#ffbfb0";
            validBtn();
        } else {
            validBody = true;
            validBtn();
            body.style.backgroundColor = "#76cc7d";
        }
    });
})();

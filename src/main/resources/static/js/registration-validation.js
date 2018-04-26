(function(){
    "use strict";

    const form = document.querySelectorAll(".sign-up-form")[0];
    const username = document.querySelector("#username");
    const email = document.querySelector("#email");
    const emailFeedback = document.querySelector('#email-feedback');
    const password = document.querySelector("#password");
    const passwordFeedback = document.querySelectorAll(".password-feedback");
    const submitBtn = document.querySelector("#submit-btn");

    let validUsername = false;
    let validEmail = false;
    let validPassword = false;

    const validateForm = () => {
        if(validUsername && validEmail && validPassword) {
            form.submit();
        }
    };

    const validBtn = e => {
        if (validUsername && validEmail && validPassword){
            submitBtn.style.backgroundColor = "#76cc7d";
            submitBtn.removeAttribute("disabled");
        } else {
            submitBtn.style.backgroundColor = "#dd9888";
            submitBtn.setAttribute("disabled","");
        }
    };

    const checkUsername = (name) => {
        if(name.length >= 5) {
            validUsername = true;
            username.style.backgroundColor = '#76cc7d';
            username.style.color = '#6d6d6d';
        } else {
            validUsername = false;
            username.style.backgroundColor = '#dd9888';
            username.style.color = '#fff';
        }
        validBtn();
        return validUsername;
    };

    const checkEmail = (mail) => {
        let atSymbol = mail.match(/[@]/);
        let dot = mail.match(/[.]/);
        if(atSymbol != null && dot != null ) {
            validEmail = true;
            emailFeedback.innerHTML = "Valid Email";
            emailFeedback.style.color = '#76cc7d';
            emailFeedback.style.fontSize = '1em';
            email.style.backgroundColor = '#76cc7d';
            email.style.color = '#6d6d6d';
        } else {
            validEmail = false;
            emailFeedback.innerHTML = "Invalid Email";
            emailFeedback.style.color = '#d07363';
            emailFeedback.style.fontSize = '1.5em';
            email.style.backgroundColor = '#dd9888';
            email.style.color = '#fff';
        }

        validBtn();
        return validEmail;
    };



    const checkPassword = (pass) => {

        let numbers = pass.match(/\d+/g);
        let uppers  = pass.match(/[A-Z]/);
        let lowers  = pass.match(/[a-z]/);
        let special = pass.match(/[!@#$%\^&*\+]/);


        if (numbers !== null){
            passwordFeedback[0].style.color = '#76cc7d';
            passwordFeedback[0].style.fontSize = '1em';
        } else {
            passwordFeedback[0].style.color = '#d07363';
            passwordFeedback[0].style.fontSize = '1.5em';
        }

        if (uppers !== null){
            passwordFeedback[1].style.color = '#76cc7d';
            passwordFeedback[1].style.fontSize = '1em';
        } else {
            passwordFeedback[1].style.color = '#d07363';
            passwordFeedback[1].style.fontSize = '1.5em';
        }

        if (lowers !== null){
            passwordFeedback[2].style.color = '#76cc7d';
            passwordFeedback[2].style.fontSize = '1em';
        } else {
            passwordFeedback[2].style.color = '#d07363';
            passwordFeedback[2].style.fontSize = '1.5em';
        }

        if (special !== null){
            passwordFeedback[3].style.color = '#76cc7d';
            passwordFeedback[3].style.fontSize = '1em';
        } else {
            passwordFeedback[3].style.color = '#d07363';
            passwordFeedback[3].style.fontSize = '1.5em';
        }

        if (numbers === null || uppers === null || lowers === null || special === null) {
            validPassword = false;
            password.style.backgroundColor = '#dd9888';
            password.style.color = '#fff';

        }

        if (numbers !== null && uppers !== null && lowers !== null && special !== null){
            validPassword = true;
            password.style.backgroundColor = '#76cc7d';
            password.style.color = '#6d6d6d';
        }

        validBtn();
        return validPassword;

    };

//********************************************************
// run scoring and apply a value to it
//********************************************************

    form.addEventListener("submit", (e) => e.preventDefault());
    validBtn();
    checkUsername(username.value);
    checkEmail(email.value);
    checkPassword(password.value);

    username.addEventListener('keyup', () => {
        checkUsername(username.value);
    });

    email.addEventListener('keyup', () => {
        checkEmail(email.value);
    });
    password.addEventListener('keyup', () => {
        checkPassword(password.value);
    });

    submitBtn.addEventListener('click', validateForm);



})();
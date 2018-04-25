(function(){
    "use strict";

    const form = document.querySelectorAll(".sign-up-form")[0];
    const username = document.querySelector("#username");
    const email = document.querySelector("#email");
    const password = document.querySelector("#password");
    const passFeedback = document.querySelector("#password-feedback");
    const submitBtn = document.querySelector("#submit-btn");
    const specialChar = ["!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "+", "=", "/", ".", ",", "'", '"', ";", ":", "[", "]", "{", "}", "\\", "|"];

    let validUsername = false;
    let validEmail = false;
    let validPassword = false;

    const validateForm = () => {
        if(validUsername && validEmail && validPassword) {
            form.submit();
        }
    };

    form.addEventListener("submit", (e) => e.preventDefault());
    let valid;
    function checkPassword(pass) {

        let numbers = pass.match(/\d+/g);
        let uppers  = pass.match(/[A-Z]/);
        let lowers  = pass.match(/[a-z]/);
        let special = pass.match(/[!@#$%\^&*\+]/);

        if (numbers === null || uppers === null || lowers === null || special === null)
            valid = false;

        if (numbers !== null && uppers !== null && lowers !== null && special !== null)
            valid = true;

        console.log(valid);
        return valid;

    }

    function scorePassword(pass) {
        let score = 0;
        if (!pass)
            return score;

        // award every unique letter until 5 repetitions
//  var letters = new Object();
        let letters = {};
        for (let i=0; i<pass.length; i++) {
            letters[pass[i]] = (letters[pass[i]] || 0) + 1;
            score += 5.0 / letters[pass[i]];
        }

        // bonus points for mixing it up
        let variations = {
            digits: /\d/.test(pass),
            lower: /[a-z]/.test(pass),
            upper: /[A-Z]/.test(pass),
            nonWords: /\W/.test(pass)
        };

        let variationCount = 0;
        for (let check in variations) {
            variationCount += (variations[check] === true) ? 1 : 0;
        }
        score += (variationCount - 1) * 10;

//    return parseInt(score);
        return parseInt(score, 10);
    }

//********************************************************
// run scoring and apply a value to it
//********************************************************
    const between = (score, low, high) => (score >= low && score <= high);

    function checkPassStrength(pass) {
        let score = scorePassword(pass);
        if (score > 79)
            return 'excellent';

        if (between(score, 60, 79))
            return 'strong';

        if (between(score, 40, 59))
            return 'good';

        if (between(score, 21, 39))
            return 'weak';

        if (score < 21)
            return 'poor';

        return '';
    }


    password.addEventListener('keyup', () => {
        if (checkPassword(password.value)){
            passFeedback.innerHTML = "Valid Password";
        } else {
            passFeedback.innerHTML = "Password must have '1-9', 'a-z', 'A-Z' and special char";
        }
    });

    submitBtn.addEventListener('click', validateForm());



})();
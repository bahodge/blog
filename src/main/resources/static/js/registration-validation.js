(function(){
    "use strict";

    const form = document.querySelectorAll(".sign-up-form")[0];
    const username = document.querySelector("#username");
    const email = document.querySelector("#email");
    const password = document.querySelector("#password");
    const passwordFeedback = document.querySelectorAll(".password-feedback");
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
        // let len = pass.length();

        if (numbers !== null){
            passwordFeedback[0].style.color = 'green';
            passwordFeedback[0].style.fontSize = '1em';
        } else {
            passwordFeedback[0].style.color = 'red';
            passwordFeedback[0].style.fontSize = '1.5em';
        }

        if (uppers !== null){
            passwordFeedback[1].style.color = 'green';
            passwordFeedback[1].style.fontSize = '1em';
        } else {
            passwordFeedback[1].style.color = 'red';
            passwordFeedback[1].style.fontSize = '1.5em';
        }

        if (lowers !== null){
            passwordFeedback[2].style.color = 'green';
            passwordFeedback[2].style.fontSize = '1em';
        } else {
            passwordFeedback[2].style.color = 'red';
            passwordFeedback[2].style.fontSize = '1.5em';
        }

        if (special !== null){
            passwordFeedback[3].style.color = 'green';
            passwordFeedback[3].style.fontSize = '1em';
        } else {
            passwordFeedback[3].style.color = 'red';
            passwordFeedback[3].style.fontSize = '1.5em';
        }

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
        checkPassword(password.value);
    });

    submitBtn.addEventListener('click', validateForm());



})();
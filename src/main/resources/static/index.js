
//Grab all the post bodies and chop them to 300 chars;
(function(){
const previewBody = () => {
    let postBodies = document.querySelectorAll('.post-body');
    if (postBodies.length > 0){
        for (let i = 0; i < postBodies.length; i++){
            if (postBodies[i].innerText.length > 100) {
                //Split it into an array;
                let newBody = [];
                let str = postBodies[i].innerText.split('');
                for(let j = 0; j < 300; j++){
                    newBody.push(str[j]);
                }
                postBodies[i].innerText = newBody.join('') + " . . . ";
            }
        }
    }
};
previewBody();
})();
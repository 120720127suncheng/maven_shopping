function hideAlert(a) {
    if(a.innerHTML.length!=0){
        setTimeout(function () {
            a.style.display="none";
        },3000);
    }
}
function gotoView(id) {
    document.getElementById(id).scrollIntoView()
}
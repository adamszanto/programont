$(document).ready(function () {
    console.log("onload is ready!");

    $(document).on('click', '.article-box-content', function(ev) {
       recolorElement(ev);
    });
});


function legacyOnload() {
    console.log("legacyOnload() has been called!");
}

function recolorElement(ev) {
    $(ev.target).css("background-color", "teal");
    console.log("Recolor element");
}
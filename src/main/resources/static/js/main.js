$(document).ready(function () {
    getIter();
});

function getIter() {
    $.ajax({
        url: "/iter",
        type: 'GET',
        dataType: 'json', // added data type
        success: function(res) {

            $("#iter").text(res);
        }
    });
}

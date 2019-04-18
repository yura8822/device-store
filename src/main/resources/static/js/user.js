$(document).ready(function () {

});

function add_user() {
    var text = {}
    text["name"] = $("#text").val();

    $("#buttonAddUser").prop("disabled", true);

    $.ajax({
        url: "api/users",
        type: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        contentType: "application/json",
        data: JSON.stringify(text),
        success: function (data) {
            console.log(data);
             var json = "<h4>Ajax Response</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
             $('#feedback').html(json);
             $("#buttonAddUser").prop("disabled", false);
        }
    });


}

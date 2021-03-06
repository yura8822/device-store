$(document).ready(function () {

});

function add_user() {
    var text = {}
    text["name"] = $("#add_user_name").val();

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
             var json = "<h4>Ajax Response add</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
             $('#feedback').html(json);
        }
    });
}

function get_users(){
     var id = $("#get_users_ID").val();

        $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "api/users/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response get</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
        }
     });
}

function update_user(){
         var text = {}
         text["name"] = $("#update_user_name").val();

         var id = $("#update_user_ID").val();

             $.ajax({
             url: "api/users/" + id,
             type: "PUT",
             headers: {
                 "Content-Type": "application/json",
             },
             contentType: "application/json",
             data: JSON.stringify(text),
             success: function (data) {
                 console.log(data);
                  var json = "<h4>Ajax Response update</h4><pre>"
                      + JSON.stringify(data, null, 4) + "</pre>";
                  $('#feedback').html(json);
             }
         });
}

function delete_user(){
     var id = $("#delete_user_ID").val();

        $.ajax({
        type: "DELETE",
        url: "api/users/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response delete</h4><pre>"
            + id + " delete" + "</pre>";
            $('#feedback').html(json);
        }
     });
}

$(document).ready(function () {

});

function add_category() {
    var text = {}
    text["name"] = $("#add_category_name").val();

        $.ajax({
        url: "api/categories",
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

function get_category(){
     var id = $("#get_category_ID").val();

        $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "api/categories/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response get</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
        }
     });
}

function update_category(){
         var text = {}
         text["name"] = $("#update_category_name").val();

         var id = $("#update_category_ID").val();

             $.ajax({
             url: "api/categories/" + id,
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

function delete_category(){
     var id = $("#delete_category_ID").val();

        $.ajax({
        type: "DELETE",
        url: "api/categories/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response delete</h4><pre>"
            + id + " delete" + "</pre>";
            $('#feedback').html(json);
        }
     });
}

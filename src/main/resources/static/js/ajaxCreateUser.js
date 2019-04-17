$(document).ready(function () {


$("#formCRUD").submit(function (event) {
ajax_add_user();
});
});

function ajax_add_user() {
var text = {}
    text["name"] = $("#text").val();

    $("#buttonAddUser").prop("disabled", true);

$.ajax({
 type: "POST",
  contentType: "application/json",
  url: "/users",
  data: JSON.stringify(text),
  dataType: 'json',
  success: function (data) {
         var json = "<h4>Ajax Response</h4><pre>"
                       + JSON.stringify(data, null, 4) + "</pre>";
                   $('#feedback').html(json);
                   $("#buttonAddUser").prop("disabled", false);
            }
    });


}
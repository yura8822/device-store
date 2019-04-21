$(document).ready(function () {

});

function add_expense() {
    var id = $("#add_expense_ID").val();
    var amount = $("#add_expense_amount").val();

        $.ajax({
        url: "/api/expenses/" + id + "/" + amount,
        type: "POST",
        contentType: "application/json",
        success: function (data) {
            console.log(data);
             var json = "<h4>Ajax Response add</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
             $('#feedback').html(json);
        }
    });
}

function get_expense(){
     var id = $("#get_expense_ID").val();

        $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/expenses/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response get</h4><pre>"
                 + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
        }
     });
}

function get_expense_amount(){
     var amount = $("#get_expense_amount").val();

        $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/api/expenses/amount/" + amount,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response get amount</h4><pre>"
                 + " > " + amount + " " + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);
        }
     });
}

function delete_expense(){
     var id = $("#delete_expense_ID").val();

        $.ajax({
        type: "DELETE",
        url: "/api/expenses/" + id,
        success: function (data) {
            console.log(data);
            var json = "<h4>Ajax Response delete</h4><pre>"
            + id + " delete" + "</pre>";
            $('#feedback').html(json);
        }
     });
}

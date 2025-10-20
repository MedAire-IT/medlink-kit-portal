// Systems Tab
function loadPacksList(baseUrl, kitId) {

    var packList = $('#packList');

    packList.empty()
        .append('<option selected="selected" value="0" disabled = "disabled">Loading.....</option>');

    $.ajax({
        'async': false,
        'global': false,
        'url': baseUrl + 'kit/pack-list/' + kitId,
        'dataType': "json",
        success: function (data) {
            packList.empty();

            $.each(data,
                function () {
                    packList.append($("<option></option>").val(this['key'])
                        .html(this['label']));
                });
        },
        failure: function (response) {
            alert(response.responseText);
        },
        error: function (response) {
            alert(response.responseText);
        }
    });
}
function resetPage(baseUrl, lobId) {

    var packList = $('#packList');
    packList.empty();

    var clientList = $("#clientList");
    clientList.empty();

    var kitList = $("#kitList");
    kitList.empty();

    var clientList = $("#clientList");

    clientList.empty()
        .append('<option selected="selected" value="0" disabled = "disabled">Loading.....</option>');

    $.ajax({
        'async': false,
        'global': false,
        'url': baseUrl + lobId,
        'dataType': "json",
        success: function (data) {

            clientList.empty();

            $.each(data,
                function () {
                    clientList.append($("<option></option>").val(this['key'])
                        .html(this['label']));
                });
        },
        failure: function (response) {
            alert(response.responseText);
        },
        error: function (response) {
            alert(response.responseText);
        }
    });

    $('#dataTables-allContents').DataTable().clear().draw();
}

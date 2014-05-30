var dt;
$(document).ready(readyHandler);

function readyHandler() {
    $('#submittime_from_p_id').datetimepicker({
        pickTime : false,
        format : "YYYY-MM-DD",
        viewMode : "days",
        minViewMode : "days",
        maxDate : new Date()
    });
    $('#submittime_to_p_id').datetimepicker({
        pickTime : false,
        format : "YYYY-MM-DD",
        viewMode : "days",
        minViewMode : "days",
        maxDate : new Date()
    });

    dt = $('#table_id2').DataTable({
        "processing" : false,
        "serverSide" : true,
        "dom" : "lrtip", // default value was :lfrtip
        "ajax" : {
            url : "bp/data",
            type : 'GET',
            "data" : function(d) {
                d.submittime_from_id = $('#submittime_from_id').val();
                d.submittime_to_id = $('#submittime_to_id').val();
            },
            error : function(xhr, error, thrown) {
                console.log("error?");
            }
        },

        "columns" : [ {
            "data" : "MDate"
        }, {
            "data" : "BPL"
        }, {
            "data" : "HP"
        }, {
            "data" : "HR"
        }, {
            "data" : "IsArr"
        }, {
            "data" : "LP"
        } ],
        "order" : [ [ 1, 'asc' ] ]
    });

    $('#search_form_id').submit(searchHandler);

}

function searchHandler(event) {
    event.preventDefault();
    dt.draw();
}

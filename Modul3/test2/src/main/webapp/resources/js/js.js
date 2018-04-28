$(document).ready(function () {

$('#create_table').on('click',function () {

var col = $( "input[name='colums']" ).val();
var row = $( "input[name='rows']" ).val();


    var html ='';

    html +='<table class="table table-bordered table-hover">';
    html +='<thead>';

        html +='<tr>';
        for(var k = 0; k<row; k++) {
            html += '<td>Row-' + k + '</td>';
        }
        html +='</tr>';
    html +='</thead>';
    html +='<tbody>';
    for(var j =0; j<col; j++){
    html +='<tr>';
        for(var s = 0; s<row; s++) {
            html += '<td><label for="rows-'+s+'">Input Rows-'+j+s+' </label><input id="rows-'+j+s+'" name="row-'+s+'" /></td>';

        }
        html += '</tr>';
    }
    html +='</tbody>';
    html +='</table>';

$('.resoult').html(html);

})



$('#save_table').on('click',function () {

var data = $('#form_table').serialize();
    $.ajax({
        url: 'account',
        type: 'post',
        data: data,
       dataType: 'json',


        success: function(serverData ) {
console.log(serverData );


        },
        error: function(e)
        {
         console.log(e);
        }
    });

    return false;


})




})

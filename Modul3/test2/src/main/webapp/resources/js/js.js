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
            html += '<td><label for="rows-'+j+s+'">Input Rows </label><input id="rows-'+j+s+'" name="row" /></td>';

        }
        html += '</tr>';
    }
    html +='</tbody>';
    html +='</table>';

$('.resoult').html(html);

})



$('#save_table').on('click',function () {
    $('#form_table input').length;
var data = $('#form_table').serialize();
 var  summ = $('#form_table input').length;
 var table_name = $( "input[name='table_name']" ).val();
    $.ajax({
        url: 'account',
        type: 'post',
        data: data+'&table_name='+table_name,
      // dataType: 'json',


        success: function(json) {
console.log(json);
           $('.resoult').hide('slow',function () {
               $('.resoult').html('<h2 class="succsses">Update Data Base</h2>');
               $('.resoult').show('slow');
           })

setTimeout(function () {
    $('.succsses').remove();
    location.reload();
},3000)


        },
        error: function(e)
        {
      //   console.log(e);
         if(e.statusText == "OK"){
             $('.resoult').hide('slow',function () {
                 $('.resoult').html('<h2 class="succsses">Update Data Base</h2>');
                 $('.resoult').show('slow');
             })

             setTimeout(function () {
                 $('.succsses').remove();
                 location.reload();
             },3000)
         }
        }
    });

    return false;


})


    $.ajax({
        url: 'havetable',
        type: 'post',
        // dataType: 'json',


        success: function(json) {

            console.log(json);
            for (var key in json) {

                $('.result_table').append("<p>"+key+" :"+" "+json[key]+"</p>")

            }


        },
        error: function(e)
        {
            console.log(e);
        }
    });

})

//use strict;
$(document).ready(function(){
	
	var elem = document.getElementsByTagName('img');
if(elem[0]){
	elem[0].addEventListener('mouseover',function(){this.style.width='110%';},false);
	elem[0].addEventListener('mouseout',function(){this.style.width='90%';},false);
	
}
	var elems = document.getElementById('text2');
if(elems){
	elems.addEventListener('mouseover',function(){this.style.color='red';},false);
	elems.addEventListener('mouseout',function(){this.style.color='black';},false);
	
}	
	

	
	
$('#form_action').submit(function() {
	
	var names = document.getElementById('nm');
	var str = names.value;
	 
	
	if(str.match(/[^\s]/g).length < 4){
		var error=document.getElementById('error');
		error.style.display="block";
		
	}else{
		var error=document.getElementById('error');
		error.style.display="none";
	}

	return false;
	
	
});

var head = document.getElementById('hed');
head.onclick = function() {
    document.getElementById('text').classList.toggle("shows");
}







	
});
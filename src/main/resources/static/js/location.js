$('document').ready(function() {
  $('table #editButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(location,status)
  {
  $('#idEdit').val(location.id);
   $('#descEdit').val(location.description);
    $('#countryidEdit').val(location.countryid);
     $('#stateidEdit').val(location.stateid);
    $('#cityEdit').val(location.city);
    
     $('#addressEdit').val(location.address);
    $('#detailsEdit').val(location.details);
     
  
  });
    $('#editModel').modal('show');
  });
  
  
 $('.table #deleteButton').click(function() {
	   event.preventDefault();
	   var href = $(this).attr('href');
	   $('#confirmDeleteButton').attr('href', href);
	   $('#deleteModel').modal('show');		
	});
	
	 $('.table #photoButton').click(function() {
	   event.preventDefault();
	   var href = $(this).attr('href');
	   $('#photoModel #employeePhoto').attr('src', href);
	   $('#photoModel').modal('show');		
	});
	
	
  });
  

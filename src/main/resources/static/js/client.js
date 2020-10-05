 $('document').ready(function() {
  $('table #editButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(client,status)
  {
  $('#idEdit').val(client.id);
   $('#nameEdit').val(client.name);
    $('#detailsEdit').val(client.details);
      $('#websiteEdit').val(client.website);
  $('#countryidEdit').val(client.countryid);
    $('#stateidEdit').val(client.stateid);
     $('#addressEdit').val(client.address);
     $('#cityEdit').val(client.city);
    $('#phoneEdit').val(client.phone);
     $('#mobileEdit').val(client.mobile);
    $('#emailEdit').val(client.email);
   
     
  
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
  

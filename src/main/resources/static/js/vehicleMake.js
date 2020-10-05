$('document').ready(function() {
  $('table #editButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(vehicleMake,status)
  {
  $('#idEdit').val(vehicleMake.id);
   $('#description').val(vehicleMake.description);
   
    $('#detailsEdit').val(vehicleMake.details);
    });
    $('#editModel').modal('show');
  });
  
  
  $('table #detailsButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(vehicleMake,status)
  {
  $('#idEdit').val(vehicleMake.id);
   $('#description').val(vehicleMake.description);
    $('#detailsEdit').val(vehicleMake.details);
     $('#createdByDetails').val(vehicleMake.createdBy);
      $('#createdDateDetails').val(vehicleMake.createdDate.substr(0,19).replace("T"," "));
     $('#lastModifiedBydetails').val(vehicleMake.lastModifiedBy);
      $('#lastModifiedOnDate').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T"," "));
     });
    $('#detailsModel').modal('show');
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
  

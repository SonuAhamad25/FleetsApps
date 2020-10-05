$('document').ready(function() {
  $('table #editButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(jobTitle,status)
  {
  $('#idEdit').val(jobTitle.id);
   $('#descriptionEdit').val(jobTitle.description);
  
    $('#detailsEdit').val(jobTitle.details);
     
  
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
  

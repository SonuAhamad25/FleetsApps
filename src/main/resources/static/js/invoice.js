 $('document').ready(function() {
  $('table #editButton').click(function() {
  event.preventDefault();
  var href =$(this).attr('href');
  $.get(href, function(invoice,status)
  {
 
   $('#nameEdit').val(invoice.name);
    $('#clientEdit').val(invoice.clientid);
      $('#invoiceDateId').val(invoice.invoiceDate);
  $('#invoiseStatusEdit').val(invoice.invoiseStatusid);
    $('#remarks').val(invoice.remarks);
    
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
  

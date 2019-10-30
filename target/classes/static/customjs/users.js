 /********************* Edit User********************************/
   function loadUser(field){ //open modal
   		var data = field.closest("td").id;
   		$('#idEdit').val(data);
    	$('#firstNameEdit').val($('#firstName' + data).text());
    	$('#lastNameEdit').val($('#lastName' + data).text());
    	$('#emailEdit').val($('#email' + data).text());
    	$('#edit-user-modal').modal('show');
    }
    $( "#user-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#idEdit').val();
    	$.ajax({
			url : '/admin/update_user',
			type : 'POST',
			data :  $("#user-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#firstName' + data).text($('#firstNameEdit').val());
				$('#lastName' + data).text($('#lastNameEdit').val());
				$('#email' + data).text($('#emailEdit').val());
		    	$('#edit-user-modal').modal('hide');
		    	swal("Updated!", "The user has been updated.", "success");
			}
		});
    });
    /*********************New User********************************/
    function newUser(){ //open modal
    	$('#firstNameNew').val('');
    	$('#lastNameNew').val('');
    	$('#emailNew').val('');
    	$('#new-user-modal').modal('show');
    }
    $( "#user-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/new_user',
			type : 'POST',
			data :  $("#user-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(idNewUser) {	
				var firstName = $('#firstNameNew').val();
				var lastName = $('#lastNameNew').val();
				var email = $('#emailNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-user-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="firstName'+idNewUser+'">'+firstName+'</td>' ; 
		    	var td3 ='<td id="lastName'+idNewUser+'">'+lastName+'</td>' ; 
		    	var td4 ='<td id="email'+idNewUser+'">'+email+'</td>' ; 
		    	var td5 ='<td id="'+idNewUser+'">' +
							'<a href="#" onclick="loadUser(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-user-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteUser(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add($('<tr>'+td1+td2+td3+td4+td5+'</tr>')).draw();
		    	swal("Créer!", "L'utilisateur a été créé.", "success");
			}
		});
    });
    
    /********************* Delete User********************************/ 
   function deleteUser(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this user!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/delete_user',
    			type : 'POST',
    			data : {
    				id : data
    			},
    			error: function (request, error) {
    				 swal("ERROR!", " Can't do because: " + error, "error");
    		    },
    			success : function(response) {	
    				$('#dt_tableTools').DataTable().row( $(field).closest('tr') ).remove().draw();
    				//field.closest('tr').remove(); 
    				//$('#myTable').dataTable();
    				swal("Deleted!", "The user has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }

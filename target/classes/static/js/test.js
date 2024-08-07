function openModal(){
	alert("Fill all correct details...")
}

function addStudent() {

	let id = $("#id").val();
    let name = $("#name").val();
    let gmail = $("#gmail").val();
    let contact = $("#contact").val();
    let course = $("#course").val();
    let fees = $("#fees").val();

	let details = {
		id : id,
		name : name,
		gmail : gmail,
		contact : contact,
		course : course,
		fees : fees
	};
    
    console.log(details);
    
    $.ajax({
				type: "POST",
				contentType: "application/json",
				url: '/addDetails',
				data: JSON.stringify(details),
				dataType: 'json',
				success: function (response) {
					alert("Details saved successfully...");
					loadDetails()
				},
				error: function (e) {
					alert("Not Working..");
				}
			});   
}


function loadDetails(){
	//alert("Load Data...");
	
	$.ajax({
				type: "GET",
				contentType: "application/json",
				url: '/getDetails',
				dataType: 'json',
				success: function (data) {

				console.log(data)

				var d = '';

				for (var i = 0; i < data.length; i++) {

				d += '<tr class="table-info">' +

				'<td > ' + data[i].id + '</td>' +
				'<td > ' + data[i].name + '</td>' +
				'<td > ' + data[i].gmail + '</td>' +
				'<td > ' + data[i].contact + '</td>' +
				'<td > ' + data[i].course + '</td>' +
				'<td > ' + data[i].fees + '</td>' +
				'<td>' + '<button data-bs-toggle="modal" data-bs-target="#exampleModal1" onclick="editDetails(' + data[i].id + ')">Edit</button>'  +
				'<button  " onclick="deleteDetails(' + data[i].id + ')">Delete</i></button>' + '</td>' +
				'</tr >'
			 }

            $('#table').html(d); 
        },
        error: function () {
            alert("Error loading data...");
        }
    });
}

function editDetails(id){
	alert("Do you want to edit details ?")
	
	console.log("Id is : " + id);
	
	$.ajax({
				type: "GET",
				contentType: "application/json",
				url: "/getDetails/"+id,
				dataType: 'json',
				success: function (data) {
					if(data){
						console.log("Student id is : " + data.id);
						console.log("Student name is : " + data.name);
						console.log("Student gmail is : " + data.gmail);
						console.log("Student contact is : " + data.contact);
						console.log("Student course is : " + data.course);
						console.log("Student fees is : " + data.fees);
						
						$("#id1").val(data.id);
						$("#name1").val(data.name);
						$("#gmail1").val(data.gmail);
						$("#contact1").val(data.contact);
						$("#course1").val(data.course);
						$("#fees1").val(data.fees);  
						
					}
					},
					error : function(e){
						console.log("Error in feching data for Id....");
					}
					
		});
}

function updateDetails(){
	alert("Your Details are Update sucessfully... ")
	let id = $("#id1").val();
	let name = $("#name1").val();
	let gmail = $("#gmail1").val();
	let contact = $("#contact1").val();
	let course = $("#course1").val();
	let fees = $("#fees1").val();
	
	let updatedData = {
		id : id,
		name : name,
		gmail : gmail,
		contact : contact,
		course : course,
		fees : fees
	};
	console.log(updatedData);
	
		$.ajax({
				type: "PUT",
				contentType: "application/json",
				url: "/editDetails",
				data: JSON.stringify(updatedData),
				dataType: 'json',
				success: function (response) {
					alert("Updated Sucessfully...");
					loadDetails()
				},
				error: function (e) {
					alert("Not Working..");
				}
			});
}

function deleteDetails(id){
	alert("Details will be deleted ?")
		console.log("Id is : " + id);
		
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: '/deleteDetails/'+id,
			success: function (response){
				alert("Deleted Successfully...");
				loadDetails()
			},
			error: function(e){
				alert("Details not deleted...");
			}
		});
}



















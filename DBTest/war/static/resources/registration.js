var newUserId;
var addUrl = "app/registration/add";
var deleteUrl = "app/registration/delete";
var updateUrl = "app/registration/update";
var selectUrl = "app/registration/select";

function setUpdateForm(element){
	
	newUserId = document.inviteForm.id.value;
	trElement = document.getElementById(element);
	document.inviteForm.event_id.value = element;
	document.inviteForm.event_name.value = trElement.children[0].innerHTML;
	document.inviteForm.street_name.value = trElement.children[1].innerHTML;
	document.inviteForm.city_name.value = trElement.children[2].innerHTML;
	document.inviteForm.zipcode.value = trElement.children[3].innerHTML;
	document.inviteForm.event_type.value = trElement.children[4].innerHTML;
	document.inviteForm.event_date.value = trElement.children[5].innerHTML;
	document.inviteForm.rsvp_date.value = trElement.children[6].innerHTML;
	document.inviteForm.newInvite.disabled = false;
	document.inviteForm.deleteInvite.disabled = false;
	document.inviteForm.action = projectUrl + updateUrl;
	
}

function setAddForm(){
	
	document.inviteForm.newInvite.disabled = true;
	document.inviteForm.deleteInvite.disabled = true;
	document.inviteForm.action = projectUrl + addUrl;
}


function setDeleteForm() {
	document.inviteForm.action = projectUrl + deleteUrl;
	return true;
}

function setSelectForm(val) {
	alert(val);
	document.inviteForm1.event_id.value = val;
	document.inviteForm1.action = projectUrl + selectUrl;
	return true;
}




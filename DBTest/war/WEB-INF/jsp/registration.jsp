<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Hello World with Spring 3 MVC</title>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	<script type="text/javascript" src="../static/resources/common.js"></script>
		<script type="text/javascript" src="../static/resources/registration.js"></script>
		<script type="text/javascript">
			var projectUrl = '<c:url value="/"/>';
			if(projectUrl.indexOf(";", 0) != -1){
				projectUrl = projectUrl.substring(0, projectUrl.indexOf(";", 0));
			}
		</script>
	</head>
	<body>
		<fieldset>
		<legend>Registration Form</legend>
		<center>
		<form:form commandName="invite" action="/app/registration/add" name="inviteForm">
		<form:input path="event_id" />
		
		<table>
			<tr><td colspan="2" align="left"><form:errors path="*" cssStyle="color : red;"/></td></tr>
			<tr><td>EventName : </td><td><form:input path="event_name" /></td></tr>
			<tr><td>Street Name : </td><td><form:input path="street_name" /></td></tr>
			<tr><td>City Name : </td><td><form:input path="city_name" /></td></tr>
			<tr><td>ZipCode : </td><td><form:input path="zipcode" /></td></tr>
			<tr><td>EventType : </td><td><form:input path="event_type" /></td></tr>
			<tr><td>EventDate : </td><td><form:input path="event_date" /></td></tr>
			<tr><td>RSVP Date </td><td><form:input path="rsvp_date" /></td></tr>
			<tr><td colspan="2"><input type="submit" value="Save Changes"/>
			&nbsp;<input type="button" name="newInvite" value="New Invite" onclick="setAddForm();" disabled="disabled"/>
			&nbsp;<input type="submit" name="deleteInvite" value="Delete Invite" onclick="setDeleteForm();" disabled="disabled"/></td></tr>
		</table>
		</form:form>
		</center>
		</fieldset>
		<c:if test="${!empty invites}">
		
			<br />
			<center>
				<table width="90%">
					<tr style="background-color: gray;">
						<th>EventName</th>
						<th>Streetname</th>
						<th>Cityname</th>
						
						<th>zipcode</th>
						<th>eventtype</th>
						<th>eventdate</th>
						<th>rsvpdate</th>
						
					</tr>
					<form:form commandName="invitesel" action="/app/registration/select" name="inviteForm1">
		<form:input path="event_id" />
					<c:forEach items="${invites}" var="invite">
						<tr style="background-color: silver;" id="${invite.event_id}" onclick="setUpdateForm('${invite.event_id}');">
							<td><c:out value="${invite.event_name}"/></td>
							<td><c:out value="${invite.street_name}"/></td>
							<td><c:out value="${invite.city_name}"/></td>
							<td><c:out value="${invite.zipcode}"/></td>
							<td><c:out value="${invite.event_type}"/></td>
							<td><c:out value="${invite.event_date}"/></td>
							<td><c:out value="${invite.rsvp_date}"/></td>
							<td><input type="submit" name="getInvite" value="Get Invite" onclick="setSelectForm('${invite.event_id}');"/></td>
						</tr>
					</c:forEach>
				</table>
				</center>
			<br />
		</form:form>
		</c:if>
			<center>
				<table width="90%">
					<tr style="background-color: gray;">
						<th>EventName</th>
						<th>Streetname</th>
						<th>Cityname</th>
						
						<th>zipcode</th>
						<th>eventtype</th>
						<th>eventdate</th>
						<th>rsvpdate</th>
						
					</tr>
					<c:out value="${invitesel.event_name}"/>
					<tr style="background-color: gray;">
		<tr style="background-color: silver;" id="${invitesel.event_id}">
							<td><c:out value="${invitesel.event_name}"/></td>
							<td><c:out value="${invitesel.street_name}"/></td>
							<td><c:out value="${invitesel.city_name}"/></td>
							<td><c:out value="${invitesel.zipcode}"/></td>
							<td><c:out value="${invitesel.event_type}"/></td>
							<td><c:out value="${invitesel.event_date}"/></td>
							<td><c:out value="${invitesel.rsvp_date}"/></td>
						</tr></table>
						</center>
	</body>
</html>
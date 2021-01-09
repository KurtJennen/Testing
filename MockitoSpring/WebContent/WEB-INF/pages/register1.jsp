<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
	<h2>Register User</h2>
	<sf:form method="POST" action="/MockitoSpring/onRegistration">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="userId">User Id:</label></th>
					<td><input type="text" name="userId" id="userId" size="10" maxlength="10" /></td>
				</tr>
				<tr>
					<th><label for="password">Password:</label></th>
					<td><input type="password" name="password" id="password" size="10" maxlength="10" /></td>
				</tr>
				<tr>
					<th><label for="fname">First Name:</label></th>
					<td><input type="fname" name="fname" id="fname" size="10" maxlength="10" /></td>
				</tr>
				<tr>
					<th><label for="lname">Last Name:</label></th>
					<td><input type="lname" name="lname" id="lname" size="10" maxlength="10" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</fieldset>	
	</sf:form>
</div>
<h1>${message}</h1>
<h3><a href="/MockitoSpring/login">Login</a></h3>
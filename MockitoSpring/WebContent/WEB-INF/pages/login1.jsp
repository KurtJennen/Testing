<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
	<h2>Login</h2>
	<sf:form method="POST" action="/MockitoSpring/onLogin">
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
					<td colspan="2">
						<input type="submit" value="Submit" />
					</td>
				</tr>
			</table>
		</fieldset>	
	</sf:form>
</div>
<h3><a href="/MockitoSpring/register">Sign Up</a></h3>
<h1>${error}</h1>
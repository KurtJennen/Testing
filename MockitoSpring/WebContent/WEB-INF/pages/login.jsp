<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<sf:form method="POST" modelAttribute="loginInfo" action="/MockitoSpring/onLogin">
	<sf:label path="userId">User id</sf:label><sf:input path="userId"/>
	<sf:label path="password">Password</sf:label><sf:input path="password"/>
	<sf:button>Login</sf:button>
	<h1>${error}</h1>
</sf:form>
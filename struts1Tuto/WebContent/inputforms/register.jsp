<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>          
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE><bean:message key="form.title"/></TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<CENTER>
<H1><bean:message key="form.title"/></H1>
<CENTER>
<html:form action="/actions/register">
  <bean:message key="form.firstName"/>:
  <html:text property="firstName"/><BR>
  <bean:message key="form.lastName"/>:
  <html:text property="lastName"/><BR>
  <bean:message key="form.emailAddress"/>:
  <html:text property="emailAddress"/><BR>
  <html:submit>
    <bean:message key="form.buttonLabel"/>
  </html:submit>
</html:form>
</CENTER>
</BODY></HTML>
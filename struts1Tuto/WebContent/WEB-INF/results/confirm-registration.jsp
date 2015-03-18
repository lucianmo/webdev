<%@ taglib uri="http://struts.apache.org/tags-bean" 
           prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>
<bean:message key="form.title"/>:
<bean:message key="form.successString"/>
</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6"><CENTER>
<H1>
<bean:message key="form.title"/>:
<bean:message key="form.successString"/>
</H1>
<UL>
  <LI><bean:message key="form.firstName"/>:
      <bean:write name="registrationBean"
                  property="firstName"/>
  <LI><bean:message key="form.lastName"/>:
      <bean:write name="registrationBean"
                  property="lastName"/>
  <LI><bean:message key="form.emailAddress"/>:
      <bean:write name="registrationBean"
                  property="emailAddress"/>
</UL>
</CENTER></BODY></HTML>
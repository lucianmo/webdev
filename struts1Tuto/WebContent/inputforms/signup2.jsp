<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Sign Up</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<H1 ALIGN="CENTER">Sign Up</H1>
Looking to receive late-breaking unverified virus alerts,
unknown ebay secrets, can't miss stock tips,
works-in-your-sleep diet plans, and
all sorts of medications? Want to get them both by email
<I>and</I> by fax? Look no further: the 
Single Provider of Alert Memos
system lets you sign up for them all in one easy
request!
<P>
<CENTER>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html:form action="/actions/signup2">
  <bean:write name="contactFormBean" property="warning" filter="false"/>
  First name: <html:text property="firstName"/><BR>
  Last name: <html:text property="lastName"/><BR>
  Email address: <html:text property="email"/><BR>
  Fax number: <html:text property="faxNumber"/><BR>
  <html:submit value="Sign Me Up!"/>
</html:form>
</CENTER>
</BODY></HTML>
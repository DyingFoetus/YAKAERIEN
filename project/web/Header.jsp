<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
   <head>
        <title>Yakaérien intranet</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
   </head>
   <body>
        <div id="header">
            
             <div id="header_banniere">
             </div>
            
             <div id="header_login">
                <s:form method="post" validate="true" action="Target" namespace="/">
                    <s:textfield label="Login" name="login"></s:textfield>
                    <s:password label="Mot de passe" name="password"></s:password>
                    <s:submit value="Connexion"></s:submit>
                </s:form>
             </div>
            
        </div>
   
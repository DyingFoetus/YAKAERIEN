<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:include value="/Header.jsp"></s:include>
        
<div id="center">
        <div id="center_page_name">
            Recherche avion
        </div>
        <div id="center_content">
        <s:form method="post" validate="true" action="SearchPlaneResult" namespace="/">
            <s:textfield label="Immatriculation" name="immat"></s:textfield>
            <s:textfield label="Date de passage" name="date"></s:textfield>
            <s:textfield label="Type d'avion" name="type_avion"></s:textfield>
            <s:submit value="Rechercher"></s:submit>
        </s:form> 
        </div>
</div>

<s:include value="/Footer.jsp"></s:include>
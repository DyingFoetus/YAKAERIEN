<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:include value="/Header.jsp"></s:include>

<div id="center">     
    <div id="center_page_name">
        Recherche d'avions
    </div>
    <div id="center_content">
        <table align=center class="table_t" style="margin-top:120px;">
            <tr class=tableTr>
                <th>Imatriculation</th>
                <th>Passager max</th>
                <th>Date de création</th>
                <th>Compagnie</th>
                <th>Type</th>
                <th>Etat</th>
                <th>Historique</th>
            </tr>
            <s:iterator value="plist">
                <tr class=tableTdGreen>
                    <td><s:property value="plane_immatriculation"/></td>
                    <td>0</td>
                    <td>01/01/2000</td>
                    <td><s:property value="company.company_name"/></td>
                    <td><s:property value="category.cat_name"/></td>
                    <td><s:property value="plane_status"/></td>
                    <s:url action="History" var="urltag">
                        <s:param name="imm"><s:property value="plane_immatriculation"/></s:param>
                    </s:url>
                    <td><a href="<s:property value="#urltag" />">voir</a></td>
                </tr>
            </s:iterator>
        </table>
        <s:if test="plist.isEmpty()"><p align=center style="color:red"><b>Pas de résultats</b></p></s:if>
    </div>
</div>

<s:include value="/Footer.jsp"></s:include>
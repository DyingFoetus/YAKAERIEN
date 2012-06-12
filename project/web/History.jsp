<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:include value="/Header.jsp"></s:include>

<div id="center">
    <div id="center_page_name">
        Historique
    </div>
    <div id="center_content">
        <div id="selected_avion">
            <h4><u><s:property value="plane.plane_immatriculation"/> - <s:property value="plane.company.company_name"/></u></h4>
            Type:<b> <s:property value="plane.category.cat_name"/></b><br />
            Immatriculation: <b><s:property value="plane.plane_immatriculation"/></b><br />
            Compagnie: <b><s:property value="plane.company.company_name"/></b><br />
        </div>
        <div id="histo_planes">

            <h3 align=center>Atterissage</h3>
            <table align=center class="table_t" style="margin-top:10px;">
                <tr class=tableTr>
                    <th>Immatriculation</th>
                    <th>Passagers</th>
                    <th>Date</th>
                </tr>
                <s:iterator value="llist">
                    <tr class=tableTdGreen>
                        <td><s:property value="plane.plane_immatriculation"/></td>
                        <td>0</td>
                        <td><s:property value="landing_date"/></td>
                    </tr>
                </s:iterator>
            </table>
            <s:if test="llist.isEmpty()"><p align=center style="color:red"><b>Pas d'atterissage enregistré</b></p></s:if>
            
            <h3 align=center>Décollage</h3>
            <table align=center class="table_t" style="margin-top:10px;">
                <tr class=tableTr>
                    <th>Immatriculation</th>
                    <th>Passagers</th>
                    <th>Date</th>
                </tr>
                <s:iterator value="tlist">
                    <tr class=tableTdGreen>
                        <td><s:property value="plane.plane_immatriculation"/></td>
                        <td>0</td>
                        <td><s:property value="takeoff_date"/></td>
                    </tr>
                </s:iterator>
            </table>
            <s:if test="tlist.isEmpty()"><p align=center style="color:red"><b>Pas de décollage enregistré</b></p></s:if>
            
        </div>
    </div>
</div>

<s:include value="/Footer.jsp"></s:include>

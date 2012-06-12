<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<s:include value="/Header.jsp"></s:include>

<div id="center">
    <div id="center_page_name">
        Ajout d'avion
    </div>
    <div id="center_content">
        <s:form method="post" validate="true" action="AddPlane" namespace="/">
            <s:textfield label="Immatriculation" name="immatriculation"></s:textfield>
            <s:textfield label="Nombre maximum de passagers" name="nbmax"></s:textfield>
            <s:textfield label="Date de creation" name="date"></s:textfield>
            <s:textfield label="Compagnie" name="compagnie"></s:textfield>
            <s:textfield label="Type d'avion" name="plane_type"></s:textfield>
            <s:textfield label="Etat de d'avion" name="plane_state"></s:textfield>
            <s:submit value="Connexion"></s:submit>
        </s:form> 
        <!--     <form method="post" action="#" onsubmit="return check_inscr(this)">
                    <table>
                        <tr><td>Immatriculation:</td><td><input type="text" name="immat" value="" /></td></tr>
                            <tr><td>Nombre max passager:</td><td><input type="text" name="date" value="" /></td></tr>
                            <tr><td>Date de création:</td><td><input type="text" name="type_avion" value="" /></td></tr>
                            <tr><td>Compagnie:</td><td><select name='compagnie'>
                                                    <option value='1'>AirGateau</option><option value='2'>AirChocolat</option>
                                                    <option value='3'>AirEPITA</option><option value='4'>AirWaves</option>
                                                                                                </select></td></tr>
                            <tr><td>Type avion:</td><td><select name='type'>
                                                    <option value='1'>PetitPorteur</option><option value='2'>MoyenPorteur</option>
                                                    <option value='3'>GrandPorteur</option><option value='4'>Cargo</option>
                                                                                                </select></td></tr>
                            <tr><td>Etat de l'avion:</td><td><select name='type'>
                                                    <option value='1'>Chargement</option><option value='2'>Dechargement</option>
                                                    <option value='3'>Attente</option><option value='4'>Maintenance</option>
                                                                                                </select></td></tr>
                        <tr><td> </td><td><input type="submit" value="Ajouter" /></td></tr>
                    </table>
                </form> -->
    </div>
</div>

<s:include value="/Footer.jsp"></s:include>
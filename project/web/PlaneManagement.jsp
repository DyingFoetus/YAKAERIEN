<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        <s:if test="logged == true">
            <div id="header">
                <div id="header_banniere">

                </div>
                <div id="header_login">
                    <p> Bienvenue <s:property value="login"/>, merci de vous etre connecte.</p>
                </div>
            </div>
                
            <div id="center">     
                <div id="center_page_name">
                    Gestion des avions
                </div>
                <div id="center_content">
                    <a href="AddPlaneForm.action"><button type="button" class="boutton" style="float:left;">Ajouter un avion</button></a>
                    <button type="button" class="boutton" style="">Exporter en XML</button>
                    <a href="SearchPlane.action"><button type="button" class="boutton" style="float:right;">Recherche d'un avion</button></a>
                    <table align=center class="table_t" style="margin-top:120px;">
                        <tr class=tableTr>
                            <th>Imatriculation avion</th>
                            <th>Passager max</th>
                            <th>Date de création</th>
                            <th>Compagnie aérienne</th>
                            <th>Type d'avion</th>
                            <th>Etat de l'avion</th>
                        </tr>
                        <tr class=tableTdGreen><td>24XF43</td><td>200</td><td>01/02/12</td><td>AirGateau</td><td>Petit Porteur</td><td>Pas mal</td></tr>
                        <tr class=tableTdGreen><td>24XF43</td><td>200</td><td>01/02/12</td><td>AirGateau</td><td>Petit Porteur</td><td>Pas mal</td></tr>
                        <tr class=tableTdGreen><td>24XF43</td><td>200</td><td>01/02/12</td><td>AirGateau</td><td>Petit Porteur</td><td>Pas mal</td></tr>
                        <tr class=tableTdGreen><td>24XF43</td><td>200</td><td>01/02/12</td><td>AirGateau</td><td>Petit Porteur</td><td>Pas mal</td></tr>
                        <tr class=tableTdGreen><td>24XF43</td><td>200</td><td>01/02/12</td><td>AirGateau</td><td>Petit Porteur</td><td>Pas mal</td></tr>

                    </table>
                </div>
            </div>
        </s:if>

        <s:else>
            <div id="header">
                <div id="header_banniere">

                </div>
                <div id="header_login">
                    <form method="post" action="#" onsubmit="return check_inscr(this)">
                        Login:<input type="text" name="login" value="Login" />
                        Pass:<input type="password" name="pass" value="mdp"/>
                        <input type="submit" value="Connection" />
                    </form>
                </div>
            </div>
            <div id="center">     
                <p>Erreur de login ! Mauvais login ou mot de passe.</p>
                <a href="Login.action">Retour</a>
            </div>
        </s:else>

        <div id="footer">
        </div>
    </body>
</html>

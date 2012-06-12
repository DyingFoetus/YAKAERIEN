<%-- 
    Document   : gestion_controlleur.jsp
    Created on : 10 juin 2012, 19:18:29
    Author     : m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>Gestion des controlleurs</title>
        <link rel="stylesheet" media="screen" type="text/css" title="Design" href="design.css" />
    <script type="text/javascript">
         function check_inscr(x)
         {
              alert("Error 3: invalid pseudo");
              return false;
         }
    </script>
    </head>
    <body>
         <div id="header">
             <div id="header_banniere">
                  
             </div>
             <div id="header_login">
                  <form method="post" action="#" onsubmit="return check_inscr(this)">
                       Login:<input type="text" name="login" value="Login" />
                       Pass:<input type="password" name="pass" value="mdp" />
                       <input type="submit" value="Connection" />
                  </form>
             </div>
        </div>
        
        <div id="center">
             <div id="center_page_name">
                  Gestion des controleurs
             </div>
             <div id="center_content">
                  <div id="mouves_planes">
                       <b>Modification des controleurs</b><br />
                    <form action="#" method="post">
                    <table align=center class="table_t" style="margin-top:10px;">
                         <tr class=tableTdGreen><td>Ajout controleur: </td><td><input type="text" name="pass" value="" /></td><td><input type="submit" value="Valider" /></td></tr>
                         <tr class=tableTdGreen><td>Suppression controleur:</td><td><select name='compagnie'>
                                                      <option value='1'>Roger</option><option value='2'>Coucou</option>
                                                       <option value='3'>Momo</option><option value='4'>Flamby</option>
												  </select></td><td><input type="submit" value="Valider" /></td></tr>
                         <tr class=tableTdGreen><td>Modifier controleur: </td><td><select name='compagnie'>
                                                       <option value='1'>Roger</option><option value='2'>Coucou</option>
                                                       <option value='3'>Momo</option><option value='4'>Flamby</option>
												  </select></td></tr>
                          <tr class=tableTdGreen><td align="right">par :</td><td><input type="text" name="pass" value="" /></td><td><input type="submit" value="Valider" /></td></tr>
                    </table>
                    </form>
                  </div>
             </div>
        </div>
        
        <div id="footer">
             
        </div>
    </body>
</html>

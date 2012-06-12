<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" >
   <head>
       <title>Yakaérien intranet</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
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
                  Gestion des pistes
             </div>
             <div id="center_content">
                  <div id="mouves_planes">
                       <b>Modification des pistes</b><br />
                    <form action="#" method="post">
                    <table align=center class="table_t" style="margin-top:10px;">
                         <tr class=tableTdGreen><td>Ajout piste n°: </td><td><input type="text" name="pass" value="" /></td><td><input type="submit" value="Valider" /></td></tr>
                         <tr class=tableTdGreen><td>Suppression piste n°:</td><td><select name='compagnie'>
                                                      <option value='1'>Roger</option><option value='2'>Coucou</option>
                                                       <option value='3'>Momo</option><option value='4'>Flamby</option>
												  </select></td><td><input type="submit" value="Valider" /></td></tr>
                         <tr class=tableTdGreen><td>Modifier piste n°: </td><td><select name='compagnie'>
                                                       <option value='1'>Roger</option><option value='2'>Coucou</option>
                                                       <option value='3'>Momo</option><option value='4'>Flamby</option>
												  </select></td></tr>
                          <tr class=tableTdGreen><td align="right">par :</td><td><input type="text" name="pass" value="" /></td><td><input type="submit" value="Valider" /></td></tr>
                    </table>
                    </form>
                  </div>
                  <div id="placement_manuel">
                       <b>Rechercher</b><br />
                    <form action="#" method="post">
                    <table align=center class="table_t" style="margin-top:10px;">
                         <tr class=tableTdGreen><td>Piste: </td><td><select name='compagnie'>
                                                       <option value='1'>Roger</option><option value='2'>Coucou</option>
                                                       <option value='3'>Momo</option><option value='4'>Flamby</option>
												  </select></td></tr>
                         <tr class=tableTdGreen><td>Date</td><td><input type="text" name="pass" value="" /></td></tr>
                         <tr class=tableTdGreen><td>Horraire</td><td><select name='compagnie'>
                                                       <option value='1'></option><option value='2'></option>
                                                       <option value='3'></option><option value='4'></option>
												  </select></td></tr>
                         <tr class=tableTdGreen><td></td><td><input type="submit" value="Rechercher" /></td></tr>
                    </table>
                    </form>
                  </div>
             </div>
        </div>
        
        <div id="footer">
             
        </div>
   </body>
</html>

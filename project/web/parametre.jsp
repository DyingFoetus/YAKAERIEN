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
                  Paramètres globaux
             </div>
             <div id="center_content">
                  <form method="post" action="#" onsubmit="return check_inscr(this)">
                       <table>
                            <tr><td>Temps atterissage:</td><td><input type="text" name="immat" value="10" />min</td></tr>
                            <tr><td>Temps décollage:</td><td><input type="text" name="date" value="15" />min</td></tr>
                            <tr><td>Temps Petit Porteur:</td><td><input type="text" name="type_avion" value="60" />min</td></tr>
                            <tr><td>Temps Moyen Porteur:</td><td><input type="text" name="type_avion" value="150" />min</td></tr>
                            <tr><td>Temps Grand Porteur:</td><td><input type="text" name="type_avion" value="240" />min</td></tr>
                            <tr><td>Temps Cargo:</td><td><input type="text" name="type_avion" value="330" />min</td></tr>
                            <tr><td> </td><td><input type="submit" value="Enregistrer les modifications" /></td></tr>
                       </table>
                  </form>
             </div>
        </div>
        
        <div id="footer">
             
        </div>
   </body>
</html>
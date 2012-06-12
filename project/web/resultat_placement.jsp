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
                  Resultat placement
             </div>
             <div id="center_content">
                  <form method="post" action="#">
                  <input type="radio" name="group1" value="Choix1" selected>
                       Choix 1 :<br />
                  <table align=center class="table_t" style="margin-top:10px; width:95%;">
                    <tr class=tableTr>
                         <th>Imatriculation avion</th>
                         <th>Action</th>
                         <th>Date en piste</th>
                         <th>Numero piste</th>
                         <th>Date arrive en parking</th>
                         <th>Parking</th>
                    </tr>
                       <tr class=tableTdGreen><td>24XF43</td><td>Chargement</td><td>01/02/12 10h45</td><td>1</td><td>01/02/12 10h50</td><td>Roger</td></tr>
                       <tr class=tableTdGreen><td>24XF43</td><td>Chargement</td><td>01/02/12 10h45</td><td>1</td><td>01/02/12 10h50</td><td>Chocolat</td></tr>
                       <tr class=tableTdGreen><td>24XF43</td><td>Chargement</td><td>01/02/12 10h45</td><td>1</td><td>01/02/12 10h50</td><td>Gateau</td></tr>
                       <tr class=tableTdGreen><td>24XF43</td><td>Chargement</td><td>01/02/12 10h47</td><td>1</td><td>01/02/12 10h50</td><td>Flamby</td></tr>
                       <tr class=tableTdGreen><td>24XF43</td><td>Chargement</td><td>01/02/12 10h48</td><td>1</td><td>01/02/12 10h50</td><td>Roger</td></tr>
                       
                  </table>
                  <input type="radio" name="group1" value="Choix2"> Choix 2:<br />
                  <input type="radio" name="group1" value="Choix3"> Choix 3:<br />
                       <input type="submit" value="Valider" />
                       <input type="submit" value="Annuler" />
                  </form>
             </div>
        </div>
        
        <div id="footer">
             
        </div>
   </body>
</html>
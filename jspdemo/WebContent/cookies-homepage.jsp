<html>
<body>
<h3> Training Portal </h3>
<!-- Read the favourite programming languages. -->
<% 
// the default... if there are no cookies
String favLang = "JAVA";
//Get the cookies from the browser request
Cookie[] theCookies = request.getCookies();
//Find our favourite language cookie
if(theCookies!=null){
for(Cookie tempCookies : theCookies){
 if("myApp.favouriteLanguage".equals(tempCookies.getName())){
  favLang = tempCookies.getValue();
  break;
 }
 
}
}
%>
<!-- Now show a personalised page... use "favLang" variable -->
<!-- Show new books for this lang -->
<h4>New Books for <%= favLang %></h4>
<ul>
<li>test</li>
<li>test</li>
<li>test</li>
</ul>

<h4>Latest news for <%= favLang %></h4>
<ul>
<li>test</li>
<li>test</li>
<li>test</li>
</ul>

<h4>Hot Jobs for <%= favLang %></h4>
<ul>
<li>test</li>
<li>test</li>
<li>test</li>
</ul>

<a href="cookies-personalize-form.html">Personalise this page.</a>

</body>
</html>
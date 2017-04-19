<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    cursor: pointer;
    

}
</style>
<script>
function myFunction() {
    alert("Password changed");
}
</script>
<div>
<h1>Reset Password</h1>
<form method="get" action="pwdchg" onsubmit="myFunction()">

<p>Secret Question: ${str}</p>

<p>Secret Answer:<br>
<input type="password" name="secans"></p>

<p>Enter New Password:<br>
<input type="password" name="npwd"></p>


<input type="submit" name="setpass" class="button" value="Set Password">
</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</tiles:putAttribute>
</tiles:insertDefinition>
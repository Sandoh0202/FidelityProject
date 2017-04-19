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

<div>
<font size="6"><b>Registration Page</font> <br>
<form action="register" method="post">
<p>Name:<br>
<input type="text" name="name"></p>

<p>Login Name:<br>
<input type="text" name="lname" required></p>

<p>Login Password:<br>
<input type="password" name="lpassword" required></p>

<p>Secret question:<br>
<input type="text" name="secret_ques" required></p>

<p>Secret Answer:<br>
<input type="password" name="answer" required></p>

<p>Date of Birth:<br>
<input type="date" name="dob" required></p>
<p>Gender:<br>
  <input type="radio" name="gender" value="m" checked> Male
  <input type="radio" name="gender" value="f"> Female<br>
  <p>Household Id:<br>
  <input type="text" name="house_id"></p>
  <p>
  Investment Id:<br>
  <input type="text" name="invest_id"></p>

 <input type="submit" name="register" class="button" value="Register"> 

</form>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	</tiles:putAttribute>
</tiles:insertDefinition>
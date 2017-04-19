<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">



		<div class="body">
		
		
	<!-- <p> 	${customer_amount}[0].name </p>  -->
	
	${customer_amount}
				
   <%--
   <p> The users are: </p>
   <table> 
   <c:forEach items="${customer_amount}" var="User">
       <script language="javascript">
           var e=document.getElementById("customer_id");
           e.textContent = ${User.customer_id};
           var c=document.getElementById("name");
           c.textContent=${User.name};
           var d=document.getElementById("amount");
           d.textContent=${User.amount};
       </script>
       
   <tr><form action="ControllerForAdd">
       <td><input id="customer_id"  name="customer_id">${User.customer_id}</td>
       
       <td><input id="name" name="name">${User.name}</td>
       
       <td><input id="amount" name="amount">${User.amount}</td>
       
        <td><input type="text" name="amountToBeAdded"/> </td>
             
        <td> <input type="radio" name="radioButton" value="add">Credit</td>
        
        <td> <input type="radio" name="radioButton" value="subtract">Debit</td>
        <td> <input type="submit" value="Submit" /></td>
        
       </form>
    </tr>
</c:forEach>
   
    </table>--%>
		</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	</tiles:putAttribute>
</tiles:insertDefinition>
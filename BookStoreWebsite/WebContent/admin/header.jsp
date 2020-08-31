<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align ="center">

		<div>
		<img src="../images/BookstoreAdminLogo.png" />
		</div>
	
		<div>
			Welcome, <c:out value ="${sessionScope.useremail}" /> | <a href="logout">Logout</a>
			<br/><br/>
		</div>
		
		<div id="headermenu" >
			<div >
				<a href="list_users"> 
					<img src = "../images/user.jpg" width="50" height="50"/> <br/>Users 
				</a> |
			</div >
			<div >
				<a href="list_category"> 
					<img src = "../images/category.png" width="50" height="50"/> <br/>Categories 
				</a> |
			</div>
			<div>
				<a href="list_books"> 
					<img src = "../images/books2.png" width="50" height="50"/> <br/>Books 
				</a> |
			</div>
			<div>
				<a href="customers"> 
					<img src = "../images/customer.jpg" width="50" height="50"/> <br/>Customers 
				</a> |
			</div>
			<div>
				<a href="reviews"> 
					<img src = "../images/review.png" width="50" height="50"/> <br/>Reviews 
				</a> |
			</div>
			<div style = "display:table-cell">
				<a href="orders"> 
					<img src = "../images/shcart.png" width="50" height="50"/> <br/>Orders 
				</a> |
			</div>
			
		
		</div>

</div>



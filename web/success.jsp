<%@ include file="./includes/header.html" %>

	<p>Your account has successfully been created!</p>
        <p>Here is all of your information</p>
        <br />
        Username: ${user.username} <br />
        Password: ${user.password} <br />
        First name: ${user.firstName} <br />
        Last name: ${user.lastName} <br />
        Phone number: ${user.phoneNumber} <br />
        Address: ${user.address} <br />
        City: ${user.city} <br />
        State: ${user.state} <br />
        Zip code: ${user.zipCode} <br />
        Email: ${user.email} <br />
        ${extra}        
        
<%@ include file="./includes/footer.jsp" %>
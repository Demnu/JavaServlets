

function myFunction(k) {
    alert(k);
}

function formvalidation(securityCode){
    
    var valid = true;
    if(/\d/.test(document.userDetails.UserID.value)){
        alert("UserID must not have numbers");
        valid=false;
    }
    else if(!/^[a-zA-Z]/.test(document.userDetails.UserID.value)){
        alert("Name must start with a letter");
        valid = false;
    }

    if(document.userDetails.Email.value.indexOf("@")<0)
    {
        alert("No @ symbol entered! Please enter a valid email.");
        valid=false;
    }

    if(document.userDetails.SecurityCode.value!=securityCode){
        alert("Incorrect Security Code")
        valid = false;
    }

    return valid;
}



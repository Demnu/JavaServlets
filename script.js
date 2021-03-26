

function myFunction(k) {
    alert(k);
}

function formvalidation(securityCode , seat){
    
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

    if(document.userDetails.SecurityCode.value!=securityCode){
        alert("Incorrect Security Code")
        valid = false;
    }

    if(document.userDetails.Seat.value!=seat){
        alert("The seat chosen does not match the seat that is being booked")
        valid = false;
    }
    return valid;
}


function startTime() {
    var today = new Date();
    var d = today.getDate();
    var month = today.getMonth();
    var y = today.getFullYear()-2000;
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    d = checkTime(d);
    month = checkTime(month);
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('time').innerHTML =
     d + "-"+ month + "-" +y +" " + s + "-" + m + "-" + h; 
    var t = setTimeout(startTime, 500);
  }
  function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
  }
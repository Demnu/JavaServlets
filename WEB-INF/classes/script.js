

function myFunction(k) {
    alert(k);
}

function formvalidation(){
    

    alert("Question 2. No @ symbol entered! Please enter a valid email.");
    return false;


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
     d + "/"+ month + "/" +y +" : " + s + ":" + m + ":" + h;
    var t = setTimeout(startTime, 500);
    
  }
  function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
  }
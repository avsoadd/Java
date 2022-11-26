/**
 * 
 */

function buttonClick(){
	let user2 = document.getElementById('username2').value
	let error = document.getElementById('errname')
    //alert(user2);
    if (user2.length == 0) {
	        alert("氏名は必須入力です。(js)");
	       let errmsg = document.getElementById('errname')
	       errmsg.style.display = "block"
	       return false
	  }
}
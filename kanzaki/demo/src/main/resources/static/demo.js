/**
 * 
 */

function buttonClick(){
	let user = document.getElementById('username').value
	let error = document.getElementById('errname')
    
    if (user.length == 0) {
	        alert("氏名は必須入力です。(js)");
	       let errmsg = document.getElementById('errname')
	       errmsg.style.display = "block"
	       return false
	  }
	  document.forms[0].submit();
}
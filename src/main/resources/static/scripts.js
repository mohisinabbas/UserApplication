

function getUsers(){

var request = new XMLHttpRequest();
var URL = 'http://localhost:8080/user/all'
request.open('GET',URL,true)
request.onload = function(){
	var data = JSON.parse(this.response)
	if(request.status>=200 && request.status<400){
		data.forEach((user) => {
			document.getElementById("demo").innerHTML = this.response
			console.log(user.phone)
		})
	}else{
			console.log('error')
	}
}
request.send()
}


function getUserById(userid){

	var URL = 'http://localhost:8080/user/'+userid;
	var request = new XMLHttpRequest();
	request.open('GET',URL,true)
	console.log(URL)
	request.onload = function(){
		
		var data = JSON.parse(this.response)
		console.log(data)
		if(request.status>=200 && request.status<400){
				document.getElementById("demo2").innerHTML = this.response
				console.log(data.phone)
			
		}else{
				document.getElementById("demo2").innerHTML = alert("Enter id")
				console.log('error')
		}
	}
	request.send()
}

function addUser(adduser){

	var request = new XMLHttpRequest();
	var URL = 'http://localhost:8080/user/'
	console.log(adduser)
	request.open('POST',URL,true)
	request.setRequestHeader('Content-type', 'application/json');

	request.onload = function(){
		
		if(request.status>=200 && request.status<400){
			document.getElementById("demo3").innerHTML = this.response
		}else{
				console.log('error')
		}
	}
	request.send(adduser)
}


function updateUser(updateuser){

	var request = new XMLHttpRequest();
	
	
	var inputData = JSON.parse(updateuser)	
	var URL = 'http://localhost:8080/user/'+inputData.id
	//console.log(adduser)
	request.open('PUT',URL,true)
	request.setRequestHeader('Content-type', 'application/json');

	request.onload = function(){
		
		if(request.status>=200 && request.status<400){
			document.getElementById("demo4").innerHTML = this.response
		}else{
				console.log('error')
		}
	}
	request.send(updateuser)
}


function deleteUser(deleteuser){

	var request = new XMLHttpRequest();
	
	
	//var inputData = JSON.parse(deleteuser)	
	var URL = 'http://localhost:8080/user/'+deleteuser
	//console.log(user)
	request.open('DELETE',URL,true)
	request.setRequestHeader('Content-type', 'application/json');

	request.onload = function(){
		
		if(request.status>=200 && request.status<400){
			document.getElementById("demo5").innerHTML = this.response
		}else{
				console.log('error')
		}
	}
	request.send()
}

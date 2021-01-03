// Get the X buttom from the alert
// When the user clicks in the X of the alert, close it
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
	close[i].onclick = function() {
		var div = this.parentElement;
		div.style.opacity = "0";
		setTimeout(function() {
			div.style.display = "none";
		}, 600);
	}
}

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
	}
}



// When a user likes a webpage card
function like(element){
	element.setAttribute("onclick", "");
	element.classList.add("disabled");
	element.innerHTML = "100043";
}

// when a user dislikes a webpage card
function dislike(element){
	element.setAttribute("onclick", "");
	element.classList.add("disabled");
	element.innerHTML = "4";
}

window.onload = init;

// Initialize the program
function init(){
	canvas = document.getElementById("canvas");
	
	radius = 10;
	speed = 5;

	xpos = 10;
	ypos = 10;
	xvel = speed;
	yvel = speed;

	if(canvas){
		setInterval(update, 50);
		console.log("Initialized");
	}else {
		console.log("Initialization aborted");
	}
}

// Update values
function update(){
	if(!canvas) return;

	canvas.width = canvas.clientWidth;
	canvas.height = canvas.clientHeight;

	if(xpos + radius > canvas.width || xpos - radius < 0){
		xvel *= -1;
	}

	if(ypos + radius > canvas.height || ypos - radius < 0){
		yvel *= -1;
	}

	xpos += xvel;
	ypos += yvel;

	draw();
}

// Draw to the screen
function draw(){
	ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);

	ctx.beginPath();
	ctx.fillStyle = "#fff";
	ctx.arc(xpos, ypos, radius, 0, Math.PI * 2);
	ctx.fill();
}
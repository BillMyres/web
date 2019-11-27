// Last edit: 05/17/2018 - TvB
// Created:   05/14/2018 - TvB
#version 150

in vec3 position;

uniform mat4 transformation_matrix;

uniform mat4 view_matrix;

uniform float aspectRatio;
float FOV = 75;
float zNear = 0.5;
float zFar = 1000;

float yScale = float((float(1.0) / tan(radians(FOV / 2.0))) * aspectRatio);
float xScale = yScale / aspectRatio;

mat4 projection_matrix = mat4(
	xScale,		0, 			0, 									0,
	0,			yScale,		0, 									0,
	0,			0,			-((zFar + zNear) / (zFar - zNear)),	-((2.0 * zNear * zFar) / (zFar - zNear)),
	0,			0, 			-1.0, 								0
);

void main(void){
	// Set the position of each vertice
	gl_Position = vec4(position, 1.0);
	
	//projection_matrix * view_matrix * transformation_matrix * 
}
// Last edit: 05/12/2018 - TvB
// Created:   04/16/2018 - TvB
#version 150

in vec2 pass_texcoord;

out vec4 out_color;

uniform vec4 main_color;

void main(void){
	// Set the color to our main color
	out_color = main_color;
}
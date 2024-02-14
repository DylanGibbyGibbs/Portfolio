extends Node


var player_current_attack = false

var current_scene = "world" #current map
var transition_scene = false

var player_exit_cliffside_posx = 100
var player_exit_cliffside_posy = 380

var player_enter_cliffside_posx = 100
var player_enter_cliffside_posy = 80

var player_start_posx = 525
var player_start_posy = 180

var game_first_loadin = true

func finish_changescenes():
	if transition_scene == true:
		transition_scene = false
		if current_scene == "world":
			current_scene = "cliff_side"
		else:
			current_scene = "world"

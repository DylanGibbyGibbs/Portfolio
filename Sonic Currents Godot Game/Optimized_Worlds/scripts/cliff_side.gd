extends Node2D


# Called when the node enters the scene tree for the first time.
func _ready():
	$player.position.x = global.player_enter_cliffside_posx
	$player.position.x = global.player_enter_cliffside_posx

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	change_scene()


func _on_cliffside_exit_point_body_entered(body):
	if body.has_method("player"):
		global.transition_scene = true


func _on_cliffside_exit_point_body_exited(body): #This is more for safety. Will likely never be used
	if body.has_method("player"):
		global.transition_scene = false
		
func change_scene():
	if global.transition_scene == true:
		if global.current_scene == "cliff_side":
			get_tree().change_scene_to_file("res://scenes/world.tscn")
			global.finish_changescenes()

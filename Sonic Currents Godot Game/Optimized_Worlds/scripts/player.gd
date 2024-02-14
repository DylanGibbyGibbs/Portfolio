extends CharacterBody2D

const speed = 150
var current_dir = "none"
var enemy_inattack_range = false
var enemy_attack_cooldown = true
var health = 100
var player_alive = true
var attack_ip = false

func _ready():
	$AnimatedSprite2D.play("down_idle")

func _physics_process(delta):
	player_movement(delta)
	enemy_attack()
	attack()
	current_camera()
	
	if health <= 0:
		player_alive = false #this is where you deal with game overs
		health = 0
		print("player is dead")
		self.queue_free() # despawns the player. Note: take this out later

func player_movement(delta):
	
	if Input.is_action_pressed("ui_right"):
		current_dir = "right"
		play_anim(1)
		velocity.x = speed
		velocity.y = 0
	elif Input.is_action_pressed("ui_left"):
		current_dir = "left"
		play_anim(1)
		velocity.x = -speed
		velocity.y = 0
	elif Input.is_action_pressed("ui_down"):
		current_dir = "down"
		play_anim(1)
		velocity.x = 0
		velocity.y = speed
	elif Input.is_action_pressed("ui_up"):
		current_dir = "up"
		play_anim(1)
		velocity.x = 0
		velocity.y = -speed
	else:
		play_anim(0)
		velocity.x = 0
		velocity.y = 0
	
	move_and_slide()

func play_anim(movement):
	var dir = current_dir
	var anim = $AnimatedSprite2D
	
	if dir == "right":
		anim.flip_h = false
		if movement == 1:
			anim.play("right")
		elif movement == 0:
			if attack_ip == false:
				anim.play("right_idle")
				
	if dir == "left":
		anim.flip_h = false
		if movement == 1:
			anim.play("left")
		elif movement == 0:
			if attack_ip == false:
				anim.play("left_idle")
				
	if dir == "up":
		anim.flip_h = false
		if movement == 1:
			anim.play("up")
		elif movement == 0:
			if attack_ip == false:
				anim.play("up_idle")
				
	if dir == "down":
		anim.flip_h = false
		if movement == 1:
			anim.play("down")
		elif movement == 0:
			if attack_ip == false:
				anim.play("down_idle")

func _on_player_hitbox_body_entered(body):
	if body.has_method("enemy"):
		enemy_inattack_range = true

func _on_player_hitbox_body_exited(body):
	if body.has_method("enemy"):
		enemy_inattack_range = false
		
func enemy_attack():
	if enemy_inattack_range and enemy_attack_cooldown == true:
		health = health - 10
		enemy_attack_cooldown = false
		$attack_cooldown.start()
		print(health)

func player():
	pass


func _on_attack_cooldown_timeout():
	enemy_attack_cooldown = true
	
func attack():
	var dir = current_dir
	
	if Input.is_action_just_pressed("attack"):
		global.player_current_attack = true
		attack_ip = true
		if dir == "right":
			$AnimatedSprite2D.play("right_attack")
			$deal_attack_timer.start()
		if dir == "left":
			$AnimatedSprite2D.play("left_attack")
			$deal_attack_timer.start()
		if dir == "up":
			$AnimatedSprite2D.play("up_attack")
			$deal_attack_timer.start()
		if dir == "down":
			$AnimatedSprite2D.play("down_attack")
			$deal_attack_timer.start()

func current_camera():
	if global.current_scene == "world":
		$world_camera.enabled = true
		$cliff_side_camera.enabled = false
	elif global.current_scene == "cliff_side":
		$cliff_side_camera.enabled = true
		$world_camera.enabled = false
		

func _on_deal_attack_timer_timeout():
	$deal_attack_timer.stop()
	global.player_current_attack = false
	attack_ip =  false

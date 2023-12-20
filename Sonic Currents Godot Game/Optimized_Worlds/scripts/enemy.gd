extends CharacterBody2D


var speed = 40
var player_chase = false
var player = null
var current_dir = "none"
var health = 100
var player_inattack_zone = false
var can_take_damage = true


func _ready():
	$AnimatedSprite2D.play("down_idle")

func _physics_process(delta):
	
	deal_with_damage()
	
	
	
	if player_chase:
		position += (player.position - position) / speed #Aggro Player
		
		
		
		if(player.position.x - position.x) < 0: #player is to the left of enemy
			
			if (player.position.y - position.y) < 0 && (player.position.y - position.y) < -20: #player is higher than enemy
				$AnimatedSprite2D.play("up")
			elif (player.position.y - position.y) > 0 && (player.position.y - position.y) > 20: #player is below the enemy
				$AnimatedSprite2D.play("down")
			else:
				$AnimatedSprite2D.play("left") #player is same height
				
				
				
		else: #player is to the right of the enemy
			if (player.position.y - position.y) < 0 && (player.position.y - position.y) < -20: #player is higher than enemy
				$AnimatedSprite2D.play("up")
			elif (player.position.y - position.y) > 0 && (player.position.y - position.y) > 20: #player is below the enemy
				$AnimatedSprite2D.play("down")
			else:
				$AnimatedSprite2D.play("right") #player is same height
		move_and_collide(Vector2(0,0)) 


func _on_detection_area_body_entered(body):
	player = body
	player_chase = true

func _on_detection_area_body_exited(body):
	player = null
	player_chase = false

func enemy():
	pass


func _on_enemy_hitbox_body_entered(body):
	if body.has_method("player"):
		player_inattack_zone = true


func _on_enemy_hitbox_body_exited(body):
	if body.has_method("player"):
		player_inattack_zone = false
	
func deal_with_damage():
	if player_inattack_zone and global.player_current_attack == true:
		if can_take_damage == true:
			health = health - 20
			$take_damage_cooldown.start()
			can_take_damage = false
			print("slime damage")
			if health <= 0:
				self.queue_free()


func _on_take_damage_cooldown_timeout():
	can_take_damage = true

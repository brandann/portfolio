import pygame, sys, glob
from pygame import *

h = 400 #screen height
w = 800 #screen width
s = 4   #speed factor
p = 2   #position factor

screen = pygame.display.set_mode((w,h))
clock = pygame.time.Clock()

class player:
    def __init__(self):
        self.x = 200
        self.y = 300
        self.ani_speed_init = s
        self.ani_speed = self.ani_speed_init
        self.ani = glob.glob("bowser_images\*.png")
        self.ani.sort()
        self.ani_pos = 0
        self.ani_max = len(self.ani) - 1
        self.img = pygame.image.load(self.ani[0])
        self.update(0)
    def update(self, pos):
        if pos != 0:
            self.ani_speed -= 1
            self.x += pos
            if self.ani_speed == 0:
                self.img = pygame.image.load(self.ani[self.ani_pos])
                self.ani_speed = self.ani_speed_init
                if self.ani_pos == self.ani_max:
                    self.ani_pos = 0
                else:
                    self.ani_pos += 1
        screen.blit(self.img,(self.x,self.y))

player1 = player()
pos = 0

while 1:
  screen.fill((255,255,255))
  clock.tick(60)
  
  for event in pygame.event.get():
    if event.type == pygame.QUIT:
      exit()
    elif event.type == KEYDOWN and event.key == K_RIGHT:
      pos = p
    elif event.type == KEYUP and event.key == K_RIGHT:
      pos = 0
    elif event.type == KEYDOWN and event.key == K_LEFT:
        pos = -p
    elif event.type == KEYUP and event.key == K_LEFT:
        pos = 0
        
  player1.update(pos)
  pygame.display.update()

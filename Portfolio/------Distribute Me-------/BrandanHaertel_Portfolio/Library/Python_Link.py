import pygame, sys, glob
from pygame import *

h = 600 #screen height
w = 600 #screen width
s = 6   #speed factor
p = 10   #position factor

link_U = glob.glob("walk\Up\*.png")
link_D = glob.glob("walk\Down\*.png")
link_L = glob.glob("walk\Left\*.png")
link_R = glob.glob("walk\Right\*.png")

link_U.sort()
link_D.sort()
link_L.sort()
link_R.sort()

screen = pygame.display.set_mode((w,h))
clock = pygame.time.Clock()

class player:
    def __init__(self):
        self.x = 200
        self.y = 50
        self.ani_speed_init = s
        self.ani_speed = self.ani_speed_init
        self.ani = link_D
        self.ani.sort()
        self.ani_pos = 0
        self.ani_max = len(self.ani) - 1
        self.img = pygame.image.load(self.ani[0])
        self.update(0,0,'D')
    def update(self, dx, dy, dir):
        if dir == 'U':
            self.ani = link_U
        elif dir == 'D':
            self.ani = link_D
        elif dir == 'R':
            self.ani = link_R
        elif dir == 'L':
            self.ani = link_L
        if dx or dy != 0:
            self.ani_speed -= 1
            if self.ani_speed == 0:
                self.img = pygame.image.load(self.ani[self.ani_pos])
                self.ani_speed = self.ani_speed_init
                if dx != 0:
                    self.move_single_axis(dx, 0)
                if dy != 0:
                    self.move_single_axis(0, dy)
                if self.ani_pos == self.ani_max:
                    self.ani_pos = 1
                else:
                    self.ani_pos += 1
        else:
            self.ani_pos = 0
            self.img = pygame.image.load(self.ani[self.ani_pos])
        screen.blit(self.img,(self.x,self.y))
    def move_single_axis(self, dx, dy):
        self.x += dx
        self.y += dy

player1 = player()
dx = 0
dy = 0
dir = 'D'

while 1:
  screen.fill((255,183,185))
  clock.tick(60)
  
  for event in pygame.event.get():
    if event.type == pygame.QUIT:
        exit()
    elif event.type == KEYDOWN and event.key == K_RIGHT:
        dx = p
        dir = 'R'
    elif event.type == KEYUP and event.key == K_RIGHT:
        dx = 0
    elif event.type == KEYDOWN and event.key == K_LEFT:
        dx = -p
        dir = 'L'
    elif event.type == KEYUP and event.key == K_LEFT:
        dx = 0
    elif event.type == KEYDOWN and event.key == K_UP:
        dy = -p
        dir = 'U'
    elif event.type == KEYUP and event.key == K_UP:
        dy = 0
    elif event.type == KEYDOWN and event.key == K_DOWN:
        dy = p
        dir = 'D'
    elif event.type == KEYUP and event.key == K_DOWN:
        dy = 0
        
  player1.update(dx, dy, dir)
  pygame.display.update()

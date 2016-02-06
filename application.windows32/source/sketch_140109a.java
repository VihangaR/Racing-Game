import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_140109a extends PApplet {

PImage img;
PImage img2;
PImage img3;
PImage img4;
PImage img5;
PImage img6;
PImage img7;
PImage img8;
PImage img9;
PImage img10;
PImage img11;
int powint = 0;
int a = 1200;
float a2 = 1800;
float gh = 0;
int d = 1200;
int e = 1200;
int sp = 10;
int sp3 = 10;
int sp2 = 30;
float b = 0;
float c = 0;
float g = 0;
float TimeCap;
float TimeCap2;
float TimeCap3;
int back = 0;
int test = 0;
int test2 = 0;
int test3 = 0;
float ranx = random(0, 728);
float ranx3 = random(0, 728);
float ranx2 = random(0, 800);
float ranx4 = random(0, 800);
float ranx5 = random(0, 800);
int screenNumber = 0;
int x, y;
int points = 1;
int time;
int wait = 1000;

//Refresh

float Pow1 = random(0, 6);
float Pow2 = random(3, 8);
float Pow3 = random(6, 10);

//

public void setup() {
  
  img = loadImage("CarTest.png");
  img2 = loadImage("CarTest.png");
  img4 = loadImage("CarTest2.png");
  img5 = loadImage("CarTest2.png");  
  img3 = loadImage("Road.jpg");
  img6 = loadImage("Aiga_downarrow_inv.png");
  img7 = loadImage("Invincible.png");
  img8 = loadImage("CoverPage.jpg");
  img9 = loadImage("Instructions.jpg");
  img10 = loadImage("Load.jpg");
  img11 = loadImage("End.jpg");

  time = millis();
}

public void draw() { 

  // INTRO

  if (screenNumber == 0)
  {
    introduction();
  }

  if (screenNumber == 5)
  {
    Instructions();
  }

  if (screenNumber == 6)
  {
    Load();
  }

  if (screenNumber==1)
  {


    keyPressed();

    if (key == 'R' || key == 'r')
    {
      powint = 0;
      screenNumber = 0;
      b = 0;
      c = 0;
      a = 1200;
      a2 = 1800;
      d = 1200;
      e = 1200;
      Pow1 = random(0, 6);
      Pow2 = random(3, 8);
      test = 0;
      test2 = 0;
      test3 = 0;
    }
    // Text
    image(img3, back, 0);
    back = back - 5;
    if (back == -1200) {
      back = 0;
    }
    //fill(255, 0, 0);
    textSize(15);
    text(nf(b, 1, 2) + "$ Worth of Damages", 10, 20);
    text("You have traveled " + c + " meters", 10, 40);
    //text(mouseY-75, 10, 30);

    //text(mouseY + "=Y", 10, 70);
    // text(mouseX + "=X", 10, 90);  






    // Images
    image(img6, d, ranx2, img.width/16, img.height/8);
    image(img7, e, ranx4);
    image(img, 300, mouseY-86, img.width/4, img.height/4);
    image(img2, a, ranx, img.width/4, img.height/4);




    //Speed (Change the a-[x] X number)
    a=a-sp2;

    // Check if image has gone past screen to reset
    if (a < -340) {
      a = 1200;
      ranx = random(0, 728);
    }

    // Mouse wont go over the screen
    if (mouseY < 86) {
      b=b+0.02f;
    }
    if (mouseY > 815) {
      b=b+0.02f;
    }
    // Hit Test
    if ( a < 600 && a > 0 && mouseY-86 > ranx && mouseY-86 < ranx+172) {
      b=b+points;
    } 
    else if ( a < 600 && a > 0 && mouseY+86 > ranx && mouseY+86 < ranx+172) {
      b=b+points;
    }




    // Add to meters traveled
    if (millis() - time >= wait) {
      c = c + 0.5f;//if it is, do something
      time = millis();//also update the stored time
    }
    // End Game
    if (c == 20) {
      screenNumber = 3;
    }

    // Powerup

    if (c > Pow1) {      
      d=d-13;
    }

    if ( d < 600 && d > 0 && mouseY-86 > ranx2 && mouseY-86 < ranx2+80) {
      g=g+1;
      d = -100;
      sp2 = 5;
      test = 1;
      powint = powint + 1;
      TimeCap = c;
    } 
    else if ( d < 600 && d > 0 && mouseY+86 > ranx2 && mouseY+86 < ranx2+160) {
      g=g+1;
      d = -100;
      sp2 = 5;
      test = 1;
      powint = powint + 1;
      TimeCap = c;
    }
    if (test == 1 && c > TimeCap+3) {
      sp2 = 30;
      test = 2;
    }  
          
    

    if (test == 2 && c == TimeCap + 10) {
      d = 1200;
    }
    // POWERUP 2



    if (c > Pow2) {      
      e=e-13;
    }


    //
    if (e < 600 && e > 0 && mouseY-86 > ranx4 && mouseY-86 < ranx4+131) {
      g=g+1;
      e = -200;
      points = 0;
      test2 = 1;
      TimeCap2 = c;
      powint = powint + 1;
      gh = TimeCap2+3;
    } 
    //
    else if (e < 600 && e > 0 && mouseY+86 > ranx4 && mouseY+86 < ranx4+200) {
      g=g+1;
      e = -200;
      points = 0;
      test2 = 1;
      TimeCap2 = c;
      powint = powint + 1;
      gh = TimeCap2+3;
    }
    textSize(20);
    text("You have invisibility until " + gh + " meters", 480, 30);

    if (test2 == 1 && c > TimeCap2+3) {
      points = 1;
      test2 = 2;
      gh = 0;
    }

    if (test2 == 2 && c == TimeCap2 + 10) {
      e = 1200;
    }
  }

  if (screenNumber == 3) {
    End();
  }

  // EASY MODE

  if (screenNumber==2)
  {
    keyPressed();

    if (key == 'R' || key == 'r')
    {
      powint = 0;
      screenNumber = 0;
      b = 0;
      c = 0;
      a = 1200;
      a2 = 1800;
      d = 1200;
      e = 1200;
      Pow1 = random(0, 6);
      Pow2 = random(3, 8);
      test = 0;
      test2 = 0;
      test3 = 0;
    }
    // Text
    image(img3, back, 0);
    back = back - 5;
    if (back == -1200) {
      back = 0;
    }
    textSize(15);
    text(nf(b, 1, 2) + "$ Worth of Damages", 10, 20);
    text("You have traveled " + c + " meters", 10, 40);


    //text(mouseY + "=Y", 10, 70);
    // text(mouseX + "=X", 10, 90);  

    // Images
    image(img7, e, ranx4);
    image(img6, d, ranx2, img.width/16, img.height/8);
    image(img4, a2, ranx3, img.width/4, img.height/4);



    image(img, 300, mouseY-86, img.width/4, img.height/4);

    image(img2, a, ranx, img.width/4, img.height/4);



    //Speed (Change the a-[x] X number)
    a=a-sp;
    a2=a2-sp3;

    // Check if image has gone past screen to reset
    if (a < -340) {
      a = 1200;
      ranx = random(0, 728);
    }
    if (a2 < -340) {
      a2 = 1200;
      ranx3 = random(0, 728);
    }

    // Mouse wont go over the screen
    if (mouseY < 86) {
      b=b+0.01f;
    }
    if (mouseY > 815) {
      b=b+0.01f;
    }

    // Hit Test
    if ( a < 600 && a > 0 && mouseY-86 > ranx && mouseY-86 < ranx+172) {
      b=b+points;
    } 
    else if ( a < 600 && a > 0 && mouseY+86 > ranx && mouseY+86 < ranx+172) {
      b=b+points;
    }



    // Hit Test
    if ( a2 < 600 && a2 > 0 && mouseY-86 > ranx3 && mouseY-86 < ranx3+172) {
      b=b+points;
    } 
    else if ( a2 < 600 && a2 > 0 && mouseY+86 > ranx3 && mouseY+86 < ranx3+172) {
      b=b+points;
    }

    // Add to meters traveled

    if (millis() - time >= wait) {
      c = c + 0.5f;//if it is, do something
      time = millis();//also update the stored time
    }
    // End Game
    if (c == 20) {
      screenNumber = 3;
    }

    // Powerup

    if (c > Pow1) {      
      d=d-5;
    }



    if ( d < 600 && d > 0 && mouseY-86 > ranx2 && mouseY-86 < ranx2+80) {
      g=g+1;
      d = -100;
      sp = 5;
      sp3 = 5;
      test = 1;
      powint = powint + 1;
      TimeCap = c;
    } 
    else if ( d < 600 && d > 0 && mouseY+86 > ranx2 && mouseY+86 < ranx2+160) {
      g=g+1;
      d = -100;
      sp = 5;
      sp3 = 5;
      test = 1;
      powint = powint + 1;
      TimeCap = c;
    }

    if (test == 1 && c > TimeCap+3) {
      sp = 10;
      sp3 = 10;
      test = 2;
    }

    if (test == 2 && c == TimeCap + 5) {
      d = 1200;
    }


    // POWERUP 2



    if (c > Pow2) {      
      e=e-5;
    }


    //
    if (e < 600 && e > 0 && mouseY-86 > ranx4 && mouseY-86 < ranx4+131) {
      g=g+1;
      e = -200;
      points = 0;
      test2 = 1;
      TimeCap2 = c;
      powint = powint + 1;
      gh = TimeCap2+3;
    } 
    //
    else if (e < 600 && e > 0 && mouseY+86 > ranx4 && mouseY+86 < ranx4+200) {
      g=g+1;
      e = -200;
      points = 0;
      test2 = 1;
      TimeCap2 = c;
      powint = powint + 1;
      gh = TimeCap2+3;
    }
    textSize(20);
    text("You have invisibility until " + gh + " meters", 480, 30);

    if (test2 == 1 && c > TimeCap2+3) {
      points = 1;
      test2 = 2;
      gh = 0;
    }

    if (test2 == 2 && c == TimeCap2 + 5) {
      e = 1200;
    }
  }
}
public void End()
{
  background(0);
  image(img11, 0, 0);
  fill(50);

  textSize(25);
  
  keyPressed();
  if (key == 'P' || key == 'p')
  {
    screenNumber = 0;
    b = 0;
    c = 0;
    a = 1200;
    a2 = 1800;
    d = 1200;
    e = 1200;
    Pow1 = random(0, 6);
    Pow2 = random(3, 8);
    test = 0;
    test2 = 0;
    test3 = 0;
  }

  text("You made it 20 meters with only " + nf(b, 1, 2) + "$ in damages", 250, 500);
  text("You collected " + powint + " powerups in total!", 250, 550);
  if (b < 30) {
    text("WOW! Amazing job champ!", 250, 400);
    text("Grade : A", 250, 450);
  } 
  else if (b < 50 && b > 30) {
    text("Not bad. Try harder next time!", 250, 400);
    text("Grade : B", 250, 450);
  } 
  else if (b < 80 && b > 50) {
    text("I Hope that's not all you got..", 250, 400);
    text("Grade : C", 250, 450);
  }
  else {
    text("You need help.. Please stay off the streets", 250, 400);
    text("Grade : No.. Just no. Fail.", 250, 450);
  }
}
public void Instructions()
{
  background(0);
  image(img9, 0, 0);
  
  
  keyPressed();

  if (key == 'N' || key == 'n')
  {
    screenNumber = 6;
  }
  
}
public void introduction()
{
  background(0);
  image(img8, 0, 0);
  
  
  keyPressed();

  if (key == 'S' || key == 's')
  {
    screenNumber = 5;
  }
  
}
public void Load()
{
  background(0);
  image(img10, 0,0);
  
  text(mouseY + "=Y", 10, 70);
   text(mouseX + "=X", 10, 90);  
image(img, 220, 180, img.width/3, img.height/3);
  
  keyPressed();

  if (key == 'H' || key == 'h')
  {
    screenNumber = 1;
  }
  if (key == 'E' || key == 'e')
  {
    screenNumber = 2;
  }
 
 
  keyPressed();
  if (key == 'T' || key == 't')
  {
    img = loadImage("CarTest2.png");
    img2 = loadImage("CarTest.png");
    
  }
  if (key == 'B' || key == 'b')
  {
    img = loadImage("CarTest.png");
    img2 = loadImage("CarTest2.png");
    
  }
}
  public void settings() {  size(1200, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_140109a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

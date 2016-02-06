void Load()
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
void End()
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
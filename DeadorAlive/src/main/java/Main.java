import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {

    DataBroker DB = new DataBroker(this);
    Graph G = new Graph(this);

    InputField country = new InputField(this, 900, 50, 300, 35);
    InputField year = new InputField(this, 900, 150, 300, 35);

    ArrayList<InputField> textboxes = new ArrayList<InputField>();

    boolean send = false;
    String msg;
    String msg2;
    int x = 1300;

    public static void main(String[] args){
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        //size(1000, 1000);
        DB.loadData();
        fullScreen();
    }

    @Override
    public void setup() {
        super.setup();
        textboxes.add(year);
        textboxes.add(country);

    }

    public void draw() {

        clear();
        background(0,150,175);


        G.DRAW(DB,country,year);
        G.display(country.X, country.Y);


        //Felter bliver tegnet
        for (InputField t : textboxes) {
            t.DRAW();
        }

        //WOW ANIMATION
        if (send) {
            fill(255);
            if (x > country.X) {
                x = x-10;
            }
            text(msg, (x+200 - textWidth(msg)), 260);
        }


    }

    @Override
    public void keyPressed() {
        super.keyPressed();
        for (InputField t : textboxes) {
            if (t.KEYPRESSED(key, keyCode)) {
                send = true;
                msg = "Land: " + textboxes.get(1).Text + "\n" + "År: " + textboxes.get(0).Text + "\n" + "Dødsfald: " + DB.getData(year.Text,country.Text);
            }
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        for (InputField t : textboxes) {
            t.PRESSED(mouseX, mouseY);
        }
    }
}




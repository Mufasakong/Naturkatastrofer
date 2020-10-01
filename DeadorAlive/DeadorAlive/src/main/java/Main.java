import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {

    DataBroker Data;


    boolean send = false;
    String msg = "";
    ArrayList<InputField> textboxes = new ArrayList<InputField>();



    public static void main(String[] args){
        PApplet.main("Main");
    }

    @Override
    public void settings() {
        size(1000, 1000);
        //fullScreen();
    }

    @Override
    public void setup() {
        super.setup();


        Data = new DataBroker(this);
        Data.loadData();



        InitLayout();

    }

    public void draw() {
        background(180);
        for (InputField t : textboxes) {
            t.DRAW();
        }

        if (send) {
            text(msg, (width - textWidth(msg)) / 2, 260);
        }
    }

    @Override
    public void keyPressed() {
        super.keyPressed();
        for (InputField t : textboxes) {
            if (t.KEYPRESSED(key, keyCode)) {
                send = true;
                msg = "Message is: " + textboxes.get(1).Text;
            }
        }
    }

    void InitLayout() {
        InputField receiver = new InputField(this);
        receiver.W = 300;
        receiver.H = 35;
        receiver.X = (width - receiver.W) / 2;
        receiver.Y = 50;
        textboxes.add(receiver);

        InputField message = new InputField(this, (width - 300) / 2, 100, 300, 35);
        textboxes.add(message);
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        for (InputField t : textboxes) {
            t.PRESSED(mouseX, mouseY);
        }
    }
}




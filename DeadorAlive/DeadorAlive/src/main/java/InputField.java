import processing.core.PApplet;
import processing.core.PVector;

public class InputField {
    public int TEXTSIZE = 24;

    PApplet p;
    public int X, Y, H, W;

    InputField(PApplet p) {
        this.p = p;
    }

    InputField(PApplet p, int X, int Y, int W, int H) {
        this.p = p;
        this.X = X;
        this.Y = Y;
        this.W = W;
        this.H = H;
    }




    /*
    public color Background = color(140, 140, 140);
    public color Foreground = color(0, 0, 0);
    public color BackgroundSelected = color(160, 160, 160);
    public color Border = color(30, 30, 30);
*/
    public boolean BorderEnable = false;
    public int BorderWeight = 1;

    public String Text = "";
    public int TextLength = 0;

    private boolean selected = false;




    void DRAW() {
        // DRAWING THE BACKGROUND
        if (selected) {
            p.fill(p.color(160, 160, 160));
        } else {
            p.fill(p.color(140, 140, 140));
        }

        if (BorderEnable) {
            p.strokeWeight(BorderWeight);
            p.stroke(p.color(30, 30, 30));
        } else {
            p.noStroke();
        }

        p.rect(X, Y, W, H);

        p.fill(p.color(0, 0, 0));

        p.textSize(TEXTSIZE);
        p.text(Text, X + (p.textWidth("a") / 2), Y + TEXTSIZE);
    }

    // IF THE KEYCODE IS ENTER RETURN 1
    // ELSE RETURN 0
    boolean KEYPRESSED(char KEY, int KEYCODE) {
        if (selected) {
            if (KEYCODE == (int)p.BACKSPACE) {
                BACKSPACE();
            } else if (KEYCODE == 32) {
                // SPACE
                addText(' ');
            } else if (KEYCODE == (int)p.ENTER) {
                return true;
            } else {
                // CHECK IF THE KEY IS A LETTER OR A NUMBER
                boolean isKeyCapitalLetter = (KEY >= 'A' && KEY <= 'Z');
                boolean isKeySmallLetter = (KEY >= 'a' && KEY <= 'z');
                //boolean isKeyNumber = (KEY >= '0' && KEY <= '9');

                if (isKeyCapitalLetter || isKeySmallLetter) {
                    addText(KEY);
                }
            }
        }

        return false;
    }

    private void addText(char text) {
        // IF THE TEXT WIDHT IS IN BOUNDARIES OF THE TEXTBOX
        if (p.textWidth(Text + text) < W) {
            Text += text;
            TextLength++;
        }
    }

    private void BACKSPACE() {
        if (TextLength - 1 >= 0) {
            Text = Text.substring(0, TextLength - 1);
            TextLength--;
        }
    }

    // FUNCTION FOR TESTING IS THE POINT
    // OVER THE TEXTBOX
    private boolean overBox(int x, int y) {
        if (x >= X && x <= X + W) {
            if (y >= Y && y <= Y + H) {
                return true;
            }
        }

        return false;
    }

    void PRESSED(int x, int y) {
        if (overBox(x, y)) {
            selected = true;
        } else {
            selected = false;
        }
    }
}
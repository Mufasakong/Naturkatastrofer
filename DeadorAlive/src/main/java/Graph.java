import processing.core.PApplet;

public class Graph extends DataBroker {

    PApplet p;

    Graph(PApplet p) {
        super(p);
        this.p = p;
    }

    public void DRAW(DataBroker DB, InputField country, InputField year){
        p.pushMatrix();
        p.scale((float) 0.5);
        p.translate(0, 660);
        for (int i = 0; i < 115; i++) {
            int yearInt = 1900+i;
            String yearString = yearInt+"";
                p.stroke( (year.Text.equalsIgnoreCase(yearString)) ? 0xffffff00 : 255);
                p.fill( (year.Text.equalsIgnoreCase(yearString)) ? 0xffffff00 : 255);
            p.rect(100+i*15,p.height-55,10, -DB.getData(yearString,country.Text));
            p.fill(0,0,0);
        }

        p.popMatrix();
    }

    public void display(int x, int y) {
        p.strokeWeight(5);
        p.stroke(0);
        p.line(30, p.height-50, p.width-30, p.height-50);
        p.line(30, 200, 30, p.height-50);
        p.strokeWeight(2);

        p.textSize(20);
        p.text("<< 1900",50,p.height-25);
        p.text("2014 >>",p.width-120,p.height-25);
        p.textSize(32);
        p.fill(255);
        p.text("Country",x,y-10);
        p.text("Year",x,y+90);
        p.textSize(20);
        p.fill(0);
        p.text("Deaths",10,180);
    }
}
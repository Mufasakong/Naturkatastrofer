import processing.core.PApplet;
import processing.data.Table;

public class DataBroker {

PApplet p;
Table table;


DataBroker(PApplet p) {

    this.p = p;

}

void loadData() {
    //dnd = p.loadTable("dnd.csv");
    table = new Table();

String[] rows = p.loadStrings("dnd.csv");
//p.println(rows[1]);

String[] years = rows[0].split(";");

for(int j = 1; j< rows.length;j++){
    String[] cells = rows[j].split(";");
       //p.println(cells[1]);

    for(int i=2;i<cells.length;i++) {
        //p.println(c);
        p.println("Land: "+cells[1]+" årstal: "+ years[i] +" døde: "+ cells[i]);
        //p.println(cells.length);
        }
    }
}



void putData() {

}


}
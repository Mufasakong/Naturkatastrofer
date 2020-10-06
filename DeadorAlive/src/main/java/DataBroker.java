import processing.core.PApplet;
import java.util.ArrayList;

public class DataBroker {

    PApplet p;

    ArrayList<Data> dataList = new ArrayList<Data>();

    String[] ROWS;
    String[] HEADERS;

    DataBroker(PApplet p) {

        this.p = p;

    }

    void loadData() {
        ROWS = p.loadStrings("dnd.csv");
        HEADERS = ROWS[0].split(";");
        for (int j = 2; j < ROWS.length; j++) {
            String[] CELLS = ROWS[j].split(";");
            for (int i = 2; i < CELLS.length; i++) {
                String D = CELLS[i];
                if (D.length() == 0) D = "0";
                dataList.add(new Data(CELLS[1], D, HEADERS[i]));
                p.println("Land: " + CELLS[1] + " årstal: " + HEADERS[i] + " døde: " + D);
            }
        }
    }

        public int getData(String year, String land) {
            int D = 0;
            for(int i = 0; i < dataList.size(); i++){
                if(land.equalsIgnoreCase(dataList.get(i).land) && year.equals(dataList.get(i).year) ){
                    D = Integer.parseInt(dataList.get(i).deaths);

                }
            }
            return D;
        }


    }

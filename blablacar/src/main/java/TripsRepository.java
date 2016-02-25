
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class TripsRepository{

    String tripsDb = "/home/jlopata/Documents/studia/blablacar/blablacar/src/main/resources/public/database/trips.dat";

    public void save(TripDto trip){
        log.debug("saving object to database");
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(tripsDb, true);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(trip);
        } catch ( IOException e){
            e.printStackTrace();
        } finally {
            try{
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<TripDto> loadAll(){
        List<TripDto> tmpList = new ArrayList<>();
        FileInputStream fis = null;
        boolean flag = true;
        try {
            fis = new FileInputStream(tripsDb);
            while (true) {
                if(fis != null) {
                    log.debug("loading object from database");
                    ObjectInputStream in = new ObjectInputStream(fis);
                    TripDto tmp = (TripDto) in.readObject();
                    if (tmp != null) {
                        tmpList.add(tmp);
                    } else {
                        break;
                    }
                } else break;
            }
        } catch ( ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try{
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return tmpList;
    }

}

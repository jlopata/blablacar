
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class UserRepository{

    String usersDb = "C:\\Users\\Jerry\\Documents\\PAI\\git\\bla\\blablacar\\src\\main\\resources\\public\\database\\users.dat";

    public void save(User user){
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(usersDb, true);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(user);
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

    public List<User> loadAll(){
        List<User> tmpList = new ArrayList<>();
        FileInputStream fis = null;
        boolean flag = true;
        try {
            fis = new FileInputStream(usersDb);
            while (true) {
                if(fis != null) {
                    ObjectInputStream in = new ObjectInputStream(fis);
                    User tmp = (User) in.readObject();
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


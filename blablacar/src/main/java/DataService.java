import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DataService {

    UserRepository userRepository = new UserRepository();
    TripsRepository tripsRepository = new TripsRepository();

    public String getTrips() {
        List<TripDto> list = new ArrayList<>();
        list = tripsRepository.loadAll();
        return new Gson().toJson(list);
    }

    public String getUsers() {
        List<User> list = new ArrayList<>();
        list = userRepository.loadAll();
        return new Gson().toJson(list);
    }

    public Boolean generateTrips() {
        tripsRepository.save(new TripDto(1, "jerry", new Date(), "Lodz", "Warszawa", "20", 2, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(2, "kazik", new Date(), "Lodz", "Warszawa", "20", 1, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(3, "jerry", new Date(), "Lodz", "Krakow", "20", 2, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(4, "kazik", new Date(), "Lodz", "Krakow", "20", 3, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(5, "konrad", new Date(), "Lodz", "Krakow", "20", 2, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(6, "jerry", new Date(), "Lodz", "Poznan", "20", 3, new ArrayList<Integer>()));
        tripsRepository.save(new TripDto(7, "konrad", new Date(), "Lodz", "Poznan", "20", 2, new ArrayList<Integer>()));
        return true;

    }

    public UserDto getUser(String email, String password) {
        List<User> tmpList = userRepository.loadAll();
        UserDto response = null;
        for(User user : tmpList) {
            if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
                response = new UserDto(user.getId(), user.getName());
            }
        }
        return response;
    }

    public boolean createUser(String email, String password, String name) {
        List<User> tmpList = userRepository.loadAll();
        int id = 1;
        if(tmpList.size() != 0){
            id = tmpList.size() + 1;
        }
        User user = new User(id, name, email, password);
        userRepository.save(user);
        return true;
    }
}

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        DataService dataService = new DataService();

        post("/addTrip", (req,res) -> dataService.createTrip(
                req.queryParams("from"),
                req.queryParams("to"),
                req.queryParams("price"),
                req.queryParams("seats"),
                req.queryParams("date"),
                req.queryParams("user")
        ));

        get("/trip", "application/json" ,(req, res) -> dataService.getTrips());

        post("/login", (req,res) -> {
            UserDto object = dataService.getUser(req.headers("email"), req.headers("password"));
            if(dataService.getUser(req.headers("email"), req.headers("password")) != null){
                req.session(true);
                res.cookie("name", object.getName());
                res.cookie("id", object.getId().toString());
            }
            return object;
        });

        post("/logout", (req,res) -> {
            req.session(false);
            res.removeCookie("name");
            res.removeCookie("id");
            return true;
        });

        post("/register", (req,res) -> dataService.createUser(
                req.queryParams("email"),
                req.queryParams("password"),
                req.queryParams("name")
        ));
        //post("/trip/save", (req,res) -> {tripsRepository.save();})
    }
}
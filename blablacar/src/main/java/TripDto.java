import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto implements Serializable{


    private static final long serialVersionUID = 5618592643737703856L;

    private Integer id;
    private String owner;
    private Date date;
    private String from;
    private String to;
    private String price;
    private int totalSeats;
    private List<Integer> passengers = new ArrayList<>();
}

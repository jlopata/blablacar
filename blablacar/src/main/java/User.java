import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{


    private static final long serialVersionUID = 843875693500884297L;

    private Integer id;
    private String name;
    private String email;
    private String password;

}

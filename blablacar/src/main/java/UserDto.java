import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable{


    private static final long serialVersionUID = 5912405465849493836L;

    private Integer id;
    private String name;

}
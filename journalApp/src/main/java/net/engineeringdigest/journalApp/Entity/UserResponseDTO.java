package net.engineeringdigest.journalApp.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class UserResponseDTO {
    @Getter
    @Setter
    @Id
    private ObjectId id;

    @Getter
    @Setter
    private String userName;


    @Getter
    @Setter
    private String role;

}

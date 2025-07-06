package net.engineeringdigest.journalApp.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UserRequestDTO {
        @NonNull
        @Indexed(unique = true)
        private String userName;

        @NonNull
        private String password;


        private String role;




}

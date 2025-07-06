package net.engineeringdigest.journalApp.Services;

import net.engineeringdigest.journalApp.Entity.UserEntity;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public boolean saveUser(UserEntity user){
        UserEntity saved = userRepository.save(user);
        return true;
    }

    public UserEntity getById(ObjectId id){
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

}

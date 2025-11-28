package de.seuhd.campuscoffee.domain.impl;

import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.ports.UserDataService;
import de.seuhd.campuscoffee.domain.ports.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // TODO: Implement user service
    private final UserDataService userDataService;

    @Override
    public void clear(){
        userDataService.clear();
    }
    @Override
    public List<User> getAll(){
        return userDataService.getAll();
    }
    @Override
    public User getById(Long id){
        return userDataService.getById(id);
    }
    @Override
    public User getByLoginName(String loginName){
        return userDataService.getByLoginName(loginName);
    }
    @Override
    public User upsert(User user){
        return userDataService.upsert(user);
    }
    @Override
    public void delete(Long id){
        userDataService.delete(id);
    }

}

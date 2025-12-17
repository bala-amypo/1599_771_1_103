package com.example.demo.service.impl;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    Userrepositories userrep;
    public User register(User user){
        return userrep.save(user);
    }
    public User findByEmail(String email){
        return userrep.findByEmail(email);
    }
}

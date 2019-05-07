package com.example.demo.service.Implement;

import com.example.demo.Exceptions.ControllerValidateException;
import com.example.demo.common.RedisKeyUtil;
import com.example.demo.common.RedisUtil;
import com.example.demo.dao.JojoUserRepository;
import com.example.demo.entity.JojoUser;
import com.example.demo.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/5/6  9:57.
 * @Modified by:
 */
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private JojoUserRepository jojoUserRepository;


    @Autowired
  private   RedisUtil redisUtil;

    @Override
    @Transactional
    public Boolean saveOne(JojoUser jojoUser) {
        JojoUser byUsername = this.findByUsername(jojoUser.getUsername());
        if(byUsername!=null){
            return false;
        }
        String hashpw = BCrypt.hashpw(jojoUser.getPassword(),  BCrypt.gensalt());
        jojoUser.setId(9);
        jojoUser.setPassword(hashpw);
        JojoUser save = jojoUserRepository.save(jojoUser);
        redisUtil.set(RedisKeyUtil.getKey("jojo_user","name",save.getUsername()),save);
        return true;
    }

    @Override
    @Transactional
    public JojoUser findByUsername(String username) {
        JojoUser exsitJoJouser = (JojoUser)redisUtil.get(RedisKeyUtil.getKey("jojo_user", "name", username));
        if(exsitJoJouser!=null){
            return exsitJoJouser;
        }
        Optional<JojoUser> byUsername = jojoUserRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        return null;
    }


}

package pl.haladyj.ss_basics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.haladyj.ss_basics.entity.Client;
import pl.haladyj.ss_basics.entity.User;
import pl.haladyj.ss_basics.repository.ClientRepository;
import pl.haladyj.ss_basics.repository.UserRepository;
import pl.haladyj.ss_basics.security.model.SecurityClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/getAllClients")
    public List<SecurityClient> getAllClients(){
        return clientRepository
                .findAll()
                .stream()
                .map(user -> new SecurityClient(user))
                .collect(Collectors.toList());
    }
}

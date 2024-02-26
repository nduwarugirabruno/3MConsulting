package com.digital.mcdigital.service.impl;

import com.digital.mcdigital.entity.metier.User;
import com.digital.mcdigital.global.Global;
import com.digital.mcdigital.repository.UserRepository;
import com.digital.mcdigital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.digital.mcdigital.global.Global.invalidCreateUser;
import static java.lang.Long.parseLong;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param user data of user
     * @return state of the creation
     */
    @Override
    public ResponseEntity<User> create(User user) {
        try {
            if (invalidCreateUser(user.getName(), user.getNumber(), user.getMail(), user.getPassword(), user.getSkills()))
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

            User utmp = userRepository.save(user);
            System.out.println("created" + utmp);
            return new ResponseEntity<>(utmp, HttpStatus.OK); // renvoie une réponse 200
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param user
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<User> update(User user, Long id) {
        try {
            Optional<User> uses = userRepository.findById(id);
            if (uses.isEmpty()) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500

            if (user.getName() != null && !uses.get().getName().equals(user.getName()))
                uses.get().setName(user.getName());

            if (user.getNumber() != 0L && !uses.get().getNumber().equals(user.getNumber()))
                uses.get().setNumber(user.getNumber());

            if (user.getMail() != null && !uses.get().getMail().equals(user.getMail()))
                uses.get().setMail(user.getMail());

            if (user.getPassword() != null && !uses.get().getPassword().equals(user.getPassword()))
                uses.get().setPassword(user.getPassword());

            if (user.getSkills() != null && !uses.get().getSkills().equals(user.getSkills()))
                uses.get().setSkills(user.getSkills());

            User utmp = userRepository.saveAndFlush(uses.get());
            System.out.println("updated" + utmp);
            return new ResponseEntity<>(utmp, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>("l'utilisateur a été supprimée", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>("An error has occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return a list of all users
     */
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * @param id of searched user
     * @return corresponding user
     */
    @Override
    public User getUById(Long id) {
        if (userRepository.findById(id).isPresent()) return userRepository.findById(id).get();
        else return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    /**
     * @param number
     * @return
     */
    @Override
    public List<User> getByNumber(Long number) {
        return userRepository.findByNumber(number);
    }

    /**
     * @param mail
     * @return
     */
    @Override
    public List<User> getByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    /**
     * @param login
     * @param password
     * @return
     */
    @Override
    public ResponseEntity<User> login(String login, String password) {
        try {
            var ref = new Object() {
                User searchedUser = null;
            };
            switch (loginType(login)){
                case 1 -> {
                    if (!userRepository.findByNumber(parseLong(login)).isEmpty()) {
                        List<User> userList = userRepository.findByNumber(parseLong(login));
                        userList.forEach(user -> {
                            if (user.getPassword().equals(password)) ref.searchedUser = user;
                        });
                    }
                }
                case 2 -> {
                    if (!userRepository.findByMail(login).isEmpty()) {
                        List<User> userList = userRepository.findByMail(login);
                        userList.forEach(user -> {
                            if (user.getPassword().equals(password)) ref.searchedUser = user;
                        });
                    }
                }
                case 3 -> {
                    if (!userRepository.findByName(login).isEmpty()) {
                        List<User> userList = userRepository.findByName(login);
                        userList.forEach(user -> {
                            if (user.getPassword().equals(password)) ref.searchedUser = user;
                        });
                    }
                }
                default -> ref.searchedUser = null;
            }
            System.out.println("searchedUser" + ref.searchedUser);
            return new ResponseEntity<>(ref.searchedUser, HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private int loginType(String login) {
        if (login.matches("-?\\\\d+")) return 1;
        if (login.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            return 2;
        return 3;
    }
}

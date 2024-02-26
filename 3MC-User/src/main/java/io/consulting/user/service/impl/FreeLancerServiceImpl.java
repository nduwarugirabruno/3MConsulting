package com.digital.mcdigital.service.impl;

import com.digital.mcdigital.entity.metier.FreeLancer;
import com.digital.mcdigital.repository.FreeLancerRepository;
import com.digital.mcdigital.service.FreeLancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.digital.mcdigital.global.Global.invalidCreateUser;
import static java.lang.Long.parseLong;

@Service
public class FreeLancerServiceImpl implements FreeLancerService {

    final FreeLancerRepository freeLancerRepository;

    @Autowired
    public FreeLancerServiceImpl(FreeLancerRepository freeLancerRepository) {
        this.freeLancerRepository = freeLancerRepository;
    }

    /**
     * @param freeLancer data of freeLancer
     * @return state of the creation
     */
    @Override
    public ResponseEntity<FreeLancer> create(FreeLancer freeLancer) {
        try {
            if (invalidCreateUser(freeLancer.getName(), freeLancer.getNumber(), freeLancer.getMail(), freeLancer.getPassword(), freeLancer.getSkills()))
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500

            FreeLancer utmp = freeLancerRepository.save(freeLancer);
            System.out.println("created" + utmp);
            return new ResponseEntity<>(utmp, HttpStatus.OK); // renvoie une réponse 200
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie une réponse 500
        }
    }

    /**
     * @param freeLancer
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<FreeLancer> update(FreeLancer freeLancer, Long id) {
        try {
            Optional<FreeLancer> uses = freeLancerRepository.findById(id);
            if (uses.isEmpty()) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //renvoie une erreur 500

            if (freeLancer.getName() != null && !uses.get().getName().equals(freeLancer.getName()))
                uses.get().setName(freeLancer.getName());

            if (freeLancer.getNumber() != 0L && !uses.get().getNumber().equals(freeLancer.getNumber()))
                uses.get().setNumber(freeLancer.getNumber());

            if (freeLancer.getMail() != null && !uses.get().getMail().equals(freeLancer.getMail()))
                uses.get().setMail(freeLancer.getMail());

            if (freeLancer.getPassword() != null && !uses.get().getPassword().equals(freeLancer.getPassword()))
                uses.get().setPassword(freeLancer.getPassword());

            if (freeLancer.getSkills() != null && !uses.get().getSkills().equals(freeLancer.getSkills()))
                uses.get().setSkills(freeLancer.getSkills());

            FreeLancer utmp = freeLancerRepository.saveAndFlush(uses.get());
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
            freeLancerRepository.deleteById(id);
            return new ResponseEntity<>("l'utilisateur a été supprimée", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error Cause: " + e.getCause());
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>("An error has occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @return a list of all freeLancers
     */
    @Override
    public List<FreeLancer> getAll() {
        return freeLancerRepository.findAll();
    }

    /**
     * @param id of searched freeLancer
     * @return corresponding freeLancer
     */
    @Override
    public FreeLancer getUById(Long id) {
        if (freeLancerRepository.findById(id).isPresent()) return freeLancerRepository.findById(id).get();
        else return null;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<FreeLancer> getByName(String name) {
        return freeLancerRepository.findByName(name);
    }

    /**
     * @param number
     * @return
     */
    @Override
    public List<FreeLancer> getByNumber(Long number) {
        return freeLancerRepository.findByNumber(number);
    }

    /**
     * @param mail
     * @return
     */
    @Override
    public List<FreeLancer> getByMail(String mail) {
        return freeLancerRepository.findByMail(mail);
    }

    /**
     * @param login
     * @param password
     * @return
     */
    @Override
    public ResponseEntity<FreeLancer> login(String login, String password) {
        try {
            var ref = new Object() {
                FreeLancer searchedFreeLancer = null;
            };
            switch (loginType(login)){
                case 1 -> {
                    if (!freeLancerRepository.findByNumber(parseLong(login)).isEmpty()) {
                        List<FreeLancer> freeLancerList = freeLancerRepository.findByNumber(parseLong(login));
                        freeLancerList.forEach(freeLancer -> {
                            if (freeLancer.getPassword().equals(password)) ref.searchedFreeLancer = freeLancer;
                        });
                    }
                }
                case 2 -> {
                    if (!freeLancerRepository.findByMail(login).isEmpty()) {
                        List<FreeLancer> freeLancerList = freeLancerRepository.findByMail(login);
                        freeLancerList.forEach(freeLancer -> {
                            if (freeLancer.getPassword().equals(password)) ref.searchedFreeLancer = freeLancer;
                        });
                    }
                }
                case 3 -> {
                    if (!freeLancerRepository.findByName(login).isEmpty()) {
                        List<FreeLancer> freeLancerList = freeLancerRepository.findByName(login);
                        freeLancerList.forEach(freeLancer -> {
                            if (freeLancer.getPassword().equals(password)) ref.searchedFreeLancer = freeLancer;
                        });
                    }
                }
                default -> ref.searchedFreeLancer = null;
            }
            System.out.println("searchedFreeLancer" + ref.searchedFreeLancer);
            return new ResponseEntity<>(ref.searchedFreeLancer, HttpStatus.OK);
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

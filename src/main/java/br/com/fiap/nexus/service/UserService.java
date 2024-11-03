package br.com.fiap.nexus.service;

import br.com.fiap.nexus.dto.UserDTO;
import br.com.fiap.nexus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService { // Implement UserDetailsService

    private List<User> userList = new ArrayList<>();

    @Transactional
    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public Optional<User> getUserById(Long id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User user = userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElseThrow();
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setActive(updatedUser.isActive());
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        return user;
    }

    @Transactional
    public void deleteUser(Long id) {
        userList.removeIf(user -> user.getId().equals(id));
    }

    public Optional<User> findByUsername(String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    // Method to create a user (modified to accept UserDTO)
    public User createUser(UserDTO userDTO) {
        User user = new User(null, userDTO.getUsername(), userDTO.getPassword(), true, userDTO.getName(), userDTO.getEmail());
        return saveUser(user);
    }

    // Implementation of loadUserByUsername method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(), user.getPassword(), new ArrayList<>())) // Assuming roles/authorities are empty for now
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}

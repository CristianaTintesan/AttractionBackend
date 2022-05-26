package disi2022.services;

import disi2022.converter.UserConverter;
import disi2022.dtos.CredentialsDTO;
import disi2022.dtos.ResetPasswordDTO;
import disi2022.dtos.UserDTO;
import disi2022.entities.User;
import disi2022.exceptions.UserNotFoundException;
import disi2022.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(UserConverter::userToDto)
                .collect(Collectors.toList());
    }

    public User getOne(int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(User user) {
        Optional<User> userOptionalInDb = userRepository.findById(user.getId());

        userOptionalInDb.ifPresent(
                userAux -> {
                    userAux.setLastName(user.getLastName());
                    userAux.setFirstName(user.getFirstName());
                    userAux.setUsername(user.getUsername());
                    userAux.setPassword(user.getPassword());
                }
        );
        return userOptionalInDb.orElseThrow(() -> new UserNotFoundException(user.getId()));
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){
       return userRepository.findByUsername(username);
    }

    public UserDTO login(CredentialsDTO credentials) {
        User user = userRepository.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword())
                .orElseThrow(() -> new UserNotFoundException(credentials.getUsername()));
        return UserConverter.userToDto(user);

    }

    public boolean resetPassword(ResetPasswordDTO resetPasswordDTO){
        User user = userRepository.findByUsernameAndPassword(resetPasswordDTO.getUsername(), resetPasswordDTO.getOldPassword())
                .orElse(null);
        if(user != null){
            user.setPassword(resetPasswordDTO.getNewPassword());
            userRepository.save(user);
            return true;
        }

        return false;
    }
}

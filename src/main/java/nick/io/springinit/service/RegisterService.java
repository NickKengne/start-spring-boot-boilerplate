package nick.io.springinit.service;


import lombok.RequiredArgsConstructor;
import nick.io.springinit.dto.RegisterDto;
import nick.io.springinit.entity.User;
import nick.io.springinit.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterService  {

    private final UserRepository userRepository;

    public HttpStatus register(RegisterDto registerDto) {
        var user = User.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .build();
        this.userRepository.save(user);
        return HttpStatus.CREATED;
    }

    public List<User> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    public HttpStatus updateUser(Integer id, RegisterDto registerDto) {
        var user = userRepository.findById(id);

        if (user.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        else {
            var current_user = user.get();
            current_user.setEmail(registerDto.getEmail());
            current_user.setName(registerDto.getName());
            userRepository.save(current_user);
            return HttpStatus.OK;
        }

    }

    public HttpStatus deleteUser(Integer id) {
        var user = userRepository.findById(id);

        if (user.isEmpty()) {
            return HttpStatus.NOT_FOUND;
        }
        else {
            userRepository.delete(user.get());
            return HttpStatus.OK;
        }
    }
}

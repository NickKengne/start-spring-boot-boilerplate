package nick.io.springinit.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import nick.io.springinit.dto.RegisterDto;
import nick.io.springinit.entity.User;
import nick.io.springinit.service.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/register/user")
    public HttpStatus registerUser(@RequestBody RegisterDto registerDto){
        return this.registerService.register(registerDto);
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return this.registerService.getAllUsers();
    }

    @PutMapping("/update/user/{id}")
    public HttpStatus updateUser(@PathVariable("id") Integer id, @RequestBody RegisterDto registerDto){
        return this.registerService.updateUser(id, registerDto);
    }
    
    @DeleteMapping("/delete/user/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Integer id){
        return this.registerService.deleteUser(id);
    }

}

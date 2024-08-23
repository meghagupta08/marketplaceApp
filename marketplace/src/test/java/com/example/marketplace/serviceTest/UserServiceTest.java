package com.example.marketplace.serviceTest;

import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import com.example.marketplace.service.UserService;
import com.example.marketplace.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void findUserByIdTest(){

        User user = new User();
        user.setId(1l);;
        user.setAddress("125 E Squire Dr");
        user.setRole("SELLER");
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        Optional<User> user1 = userServiceImpl.findUserById(1l);
        assertTrue(user1.isPresent());
    }



}

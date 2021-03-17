package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test03";
        String password = "Test03";
        String status = "Registered";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u = User.builder().account(account).password(password).status(status).email(email).build();

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println(orderGroup.getRevName());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getTotalPrice());
            System.out.println(orderGroup.getTotalQuantity());

            orderGroup.getOrderDetailList().stream().forEach(orderDetail -> {
                System.out.println(orderDetail.getItem().getPartner().getName());
                System.out.println(orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println(orderDetail.getItem().getName());
                System.out.println(orderDetail.getItem().getPartner().getCallCenter());
                System.out.println(orderDetail.getStatus());
                System.out.println(orderDetail.getArrivalDate());
            });
        });

        Assert.assertNotNull(user);
    }

    @Test
    public void update(){

    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);
        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);
        Assert.assertFalse(deleteUser.isPresent());
    }
}

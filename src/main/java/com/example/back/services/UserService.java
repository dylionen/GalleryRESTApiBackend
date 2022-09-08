package com.example.back.services;

import com.example.back.models.dto.UserDTO;
import com.example.back.models.dto.dtoMapper;
import com.example.back.models.user.Users;
import com.example.back.repositories.RoleRepository;
import com.example.back.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", userName)));
        return new User(user.get().getUserName(), user.get().getPassword(),
                user.get()
                        .getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .toList());
    }

    @Transactional
    public Users createUser(UserDTO userDTO) {
        System.out.println(userDTO);
        Users user = dtoMapper.mapUserDTOToUsers(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(new HashSet<>(List.of(roleRepository.getRoleByRoleName("USER"))));
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserByUsername(String userName){
        Optional<Users> user = userRepository.findByUserName(userName);
        return Optional.of(user).orElseThrow(RuntimeException::new).get();
    }
}

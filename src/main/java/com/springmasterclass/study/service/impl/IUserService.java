package com.springmasterclass.study.service.impl;
import java.util.List;
import java.util.Optional;

// import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springmasterclass.study.dto.record.UserRequest;
import com.springmasterclass.study.dto.record.UserResponse;
// import com.springmasterclass.study.dto.request.UserRq;
// import com.springmasterclass.study.dto.response.UserRp;
import com.springmasterclass.study.entity.User;
import com.springmasterclass.study.mapper.UserMapper;
import com.springmasterclass.study.repository.UserReposetory;
import com.springmasterclass.study.service.UserService;

import lombok.RequiredArgsConstructor;
// import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class IUserService implements UserService {

     private final UserReposetory userRepo;
     // private final ModelMapper modelMapper;
     private final UserMapper userMapper;

     @Override
     public void create(UserRequest rq) {
          if (userRepo.existsByEmail(rq.email())) {
               throw new IllegalArgumentException("email đã tồn tại");
          }

          userRepo.save(mapToEntity(rq));
     }

     @Override
     public void update(Long id, UserRequest rq) {
          Optional<User> user = userRepo.findById(id);

          if (user.isEmpty()) {
              throw new IllegalArgumentException("user not found");
          }

          // email đã tồn tại NHƯNG thuộc user khác mới tính là trùng
          // (id = user đang sửa nên bỏ qua)
          if (userRepo.existsByEmailAndIdNot(rq.email(), id)) {
               throw new IllegalArgumentException("email đã tồn tại");
          }

          User userUpdate = user.get();

          userUpdate.setName(rq.name());
          userUpdate.setAddress(rq.address());
          userUpdate.setEmail(rq.email());
          userUpdate.setUsername(rq.username());
          userUpdate.setPassword(rq.password());

          userRepo.save(userUpdate);
     }

     @Override
     public List<UserResponse> index() {
          List<User> list = userRepo.findAll();

        return list.stream().map(this::mapToResponseOfMapstruct).toList();
     }

     @Override
     public void delete(Long id) {
          Optional<User> user = userRepo.findById(id);

          if (user.isEmpty()) {
              throw new IllegalArgumentException("user not found");
          }
          userRepo.delete(user.get());
     }

     // private User mapToEntity(UserRq rq) {
     //      return User.builder()
     //           .name(rq.getName())
     //           .address(rq.getAddress())
     //           .email(rq.getEmail())
     //           .username(rq.getUsername())
     //           .password(rq.getPassword())
     //           .build();
     // }

     // private UserRp mapToResponse(User user) {

     //      // UserRq userRq = modelMapper.map(user, UserRq.class);


     //      return UserRp.builder()
     //           .id(user.getId())
     //           .name(user.getName())
     //           .address(user.getAddress())
     //           .email(user.getEmail())
     //           .username(user.getUsername())
     //           .build();
     // }

     private User mapToEntity(UserRequest rq) {
          return userMapper.toEntity(rq);
     }

     private UserResponse mapToResponseOfMapstruct(User user) {
          return userMapper.toResponse(user);
     }
}

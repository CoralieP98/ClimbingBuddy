package com.CoralieP98.Climb.Repository;

import com.CoralieP98.Climb.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findUserByEmail(String email);

    public Optional<User> findUserById(int id);


}

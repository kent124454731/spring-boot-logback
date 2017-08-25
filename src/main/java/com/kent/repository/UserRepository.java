package com.kent.repository;

import com.kent.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author Kent.Wang
 * @Date 2017/7/4
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findFirstByUsername(String username);

}

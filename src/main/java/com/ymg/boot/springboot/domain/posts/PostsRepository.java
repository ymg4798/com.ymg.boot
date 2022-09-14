package com.ymg.boot.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

//<EntityClass, PK타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {
}

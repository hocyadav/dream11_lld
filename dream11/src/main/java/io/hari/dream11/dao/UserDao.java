package io.hari.dream11.dao;

import io.hari.dream11.entity.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
@Component
@NoArgsConstructor
public class UserDao implements BaseDao<User> {
    Map<Long, User> userMap = new ConcurrentHashMap<>();
    AtomicLong userPrimaryKey = new AtomicLong(1);

    @Override
    public User saveOrUpdate(User user) {
        user.setId(Optional.ofNullable(user.getId()).orElseGet(() -> userPrimaryKey.getAndIncrement()));
        return userMap.putIfAbsent(user.getId(), user);
    }

    @Override
    public void saveMultiple(User... entities) {
        for (User user : entities) {
            saveOrUpdate(user);
        }
    }

    @Override
    public User findById(Long entityId) {
        return userMap.get(entityId);
    }

    @Override
    public void delete(User entity) {
        userMap.remove(entity);
    }

    @Override
    public List<User> findAll() {
        return userMap.values().stream().collect(Collectors.toList());
    }
}

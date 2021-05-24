package io.hari.dream11.dao;

import io.hari.dream11.entity.Player;
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
public class PlayerDao implements BaseDao<Player> {
    Map<Long, Player> teamMap = new ConcurrentHashMap<>();
    AtomicLong teamPrimaryKey = new AtomicLong(1);

    @Override
    public Player saveOrUpdate(Player player) {
        player.setId(Optional.ofNullable(player.getId()).orElseGet(() -> teamPrimaryKey.getAndIncrement()));
        return teamMap.putIfAbsent(player.getId(), player);
    }

    @Override
    public void saveMultiple(Player... players) {
        for (Player user : players) {
            saveOrUpdate(user);
        }
    }

    @Override
    public Player findById(Long entityId) {
        return teamMap.get(entityId);
    }

    @Override
    public void delete(Player player) {
        teamMap.remove(player);
    }

    @Override
    public List<Player> findAll() {
        return teamMap.values().stream().collect(Collectors.toList());
    }
}

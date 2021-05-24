package io.hari.dream11.dao;

import io.hari.dream11.entity.Tournament;
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
public class TournamentDao implements BaseDao<Tournament> {
    Map<Long, Tournament> teamMap = new ConcurrentHashMap<>();
    AtomicLong teamPrimaryKey = new AtomicLong(1);

    @Override
    public Tournament saveOrUpdate(Tournament tournament) {
        tournament.setId(Optional.ofNullable(tournament.getId()).orElseGet(() -> teamPrimaryKey.getAndIncrement()));
        return teamMap.putIfAbsent(tournament.getId(), tournament);
    }

    @Override
    public void saveMultiple(Tournament... tournaments) {
        for (Tournament user : tournaments) {
            saveOrUpdate(user);
        }
    }

    @Override
    public Tournament findById(Long entityId) {
        return teamMap.get(entityId);
    }

    @Override
    public void delete(Tournament tournament) {
        teamMap.remove(tournament);
    }

    @Override
    public List<Tournament> findAll() {
        return teamMap.values().stream().collect(Collectors.toList());
    }
}

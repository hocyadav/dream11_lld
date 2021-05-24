package io.hari.dream11.dao;

import io.hari.dream11.entity.Team;
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
public class TeamDao implements BaseDao<Team> {
    Map<Long, Team> teamMap = new ConcurrentHashMap<>();
    AtomicLong teamPrimaryKey = new AtomicLong(1);

    @Override
    public Team saveOrUpdate(Team team) {
        team.setId(Optional.ofNullable(team.getId()).orElseGet(() -> teamPrimaryKey.getAndIncrement()));
        return teamMap.putIfAbsent(team.getId(), team);
    }

    @Override
    public void saveMultiple(Team... teams) {
        for (Team user : teams) {
            saveOrUpdate(user);
        }
    }

    @Override
    public Team findById(Long entityId) {
        return teamMap.get(entityId);
    }

    @Override
    public void delete(Team team) {
        teamMap.remove(team);
    }

    @Override
    public List<Team> findAll() {
        return teamMap.values().stream().collect(Collectors.toList());
    }
}

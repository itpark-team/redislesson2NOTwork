package com.example.redislesson2.repository;

import com.example.redislesson2.models.Team;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamsRepository {

    private RedisTemplate redisTemplate;

    public TeamsRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void add(Team team) {
        redisTemplate.opsForHash().put("team", team.getId(), team);
    }

    public Team getById(int id) {
        return (Team) redisTemplate.opsForHash().get("team", id);
    }

    public List<Team> getAll(){
        return redisTemplate.opsForHash().values("team");
    }
}

package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor>findAll();
    Actor findById(Long id);
    Actor update(Long id, Actor actor);
    Actor save(Actor actor);
    void delete(Actor actor);

}

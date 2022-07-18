package com.javafee.darts.back;

import com.javafee.darts.back.domain.Player;
import com.javafee.darts.back.domain.UserPoints;
import com.javafee.darts.back.repository.Dao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dao<Player> playerDao = new Dao<>(Player.class);
        List<Player> players = playerDao.findAll();
        players.forEach(System.out::println);

        Dao<UserPoints> userPointsDao = new Dao<>(UserPoints.class);
        List<UserPoints> userPoints = userPointsDao.findAll();
        userPoints.forEach(System.out::println);
    }
}

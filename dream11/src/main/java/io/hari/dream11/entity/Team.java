package io.hari.dream11.entity;

import lombok.*;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Team extends BaseEntity {
    @Builder.Default
    List<Player> players = new LinkedList<>();
    BigInteger score;
    Player captain;
    Player viceCaptain;
}

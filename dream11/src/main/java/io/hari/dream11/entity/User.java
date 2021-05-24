package io.hari.dream11.entity;

import lombok.*;

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
@ToString(callSuper = true)
public class User extends BaseEntity{
    String name;

    @Builder.Default
    List<Team> teams = new LinkedList<>();
}

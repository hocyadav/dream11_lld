package io.hari.dream11.entity;

import lombok.*;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Player extends BaseEntity{
    String name;
    Integer creditScore;
}

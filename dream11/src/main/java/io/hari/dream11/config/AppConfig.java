package io.hari.dream11.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @Author Hariom Yadav
 * @create 5/24/2021
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "app-config")
public class AppConfig {
    @Size(min = 50, max = 100)
    Integer userDefaultCreditScore;

    @Size(min = 2, max = 11)
    Integer tournamentsTeamSize;

    BigDecimal captainMultiplicativeValue;

    BigDecimal viceCaptainMultiplicativeValue;

    Integer simplePlayerCreditScore;

    Integer mediumPlayerCreditScore;

    Integer advancePlayerCreditScore;
}

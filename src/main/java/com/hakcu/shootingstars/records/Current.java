package com.hakcu.shootingstars.records;

import java.time.LocalDateTime;

public record Current(LocalDateTime last_updated, int temp_c, Condition condition,double wind_kph, int humidity, int cloud) {

}

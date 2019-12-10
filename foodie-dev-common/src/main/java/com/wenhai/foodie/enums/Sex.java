package com.wenhai.foodie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sex {
    MAN(0,"男"),
    WOMAN(1,"女"),
    SECRECY(2, "保密");
    public final Integer type;
    public final  String value;
}

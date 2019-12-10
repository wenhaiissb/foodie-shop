package com.wenhai.foodie.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum YesOrNo {
    No(0, "否"),
    Yes(1, "是"),;
    public final Integer type;
    public final String value;
}

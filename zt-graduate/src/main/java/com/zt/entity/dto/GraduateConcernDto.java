package com.zt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GraduateConcernDto {

    private Long userId;

    private Integer type;

    private Long concernId;
}

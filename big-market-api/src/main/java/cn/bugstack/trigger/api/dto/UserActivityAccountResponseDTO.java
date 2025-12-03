package cn.bugstack.trigger.api.dto;

import lombok.Data;

@Data
public class UserActivityAccountResponseDTO {

    // 总次数
    private Integer totalCount;

    // 剩余总次数
    private Integer totalCountSurplus;

    // 当日次数
    private Integer dayCount;

    // 当日剩余次数
    private Integer dayCountSurplus;

    // 月度次数
    private Integer monthCount;

    // 月度剩余次数
    private Integer monthCountSurplus;
}

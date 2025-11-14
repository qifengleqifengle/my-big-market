package cn.bugstack.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuRechargeEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 商品SKU
     */
    private Long sku;

    /**
     * 幂等单号，外部谁充值的唯一标识，多次充值也能保证幂等
     */
    private String outBusinessNo;
}

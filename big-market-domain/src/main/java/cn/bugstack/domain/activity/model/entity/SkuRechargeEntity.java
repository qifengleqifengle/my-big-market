package cn.bugstack.domain.activity.model.entity;

import cn.bugstack.domain.activity.model.valobj.OrderTradeTypeVO;
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

    /**
     * 订单交易类型
     */
    private OrderTradeTypeVO orderTradeType = OrderTradeTypeVO.rebate_no_pay_trade;
}

package org.pbp.orderservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pbp.orderservice.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private Long customerId;
    private OrderStatus status = OrderStatus.PENDING;

    @Schema(ref = "OrderItemRequest")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderItemRequest> items = new ArrayList<>();
}

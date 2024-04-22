package org.pbp.orderservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pbp.orderservice.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Long id;
    private Long customerId;
    private OrderStatus status;
    private BigDecimal totalPrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderItemResponse> items = new ArrayList<>();
    private LocalDate createdAt;
    private LocalDate updatedAt;
}

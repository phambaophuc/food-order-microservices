package org.pbp.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pbp.orderservice.document.OrderItem;
import org.pbp.orderservice.enums.OrderStatus;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private String id;
    private Integer tableNumber;
    private OrderStatus status;

    @Schema(implementation = OrderItem.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<OrderItem> items;

    private Date createdAt;
    private Date updatedAt;
}

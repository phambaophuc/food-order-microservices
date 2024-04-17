package org.pbp.orderservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pbp.orderservice.enums.OrderStatus;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private String id;
    private OrderStatus status;

    @Schema(ref = "Items")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ItemResponse> items;

    private Date createdAt;
    private Date updatedAt;
}

package com.example.bookingservice.common.base.response;

import com.example.bookingservice.common.base.model.BaseModel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class ResponseByMessage extends BaseModel {
    private String message;
}

package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class Customer {
    private final String customerName;
    private final UUID id;
    private final Integer version;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;
}

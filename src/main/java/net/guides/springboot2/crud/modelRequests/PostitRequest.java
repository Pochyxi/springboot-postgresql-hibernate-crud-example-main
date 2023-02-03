package net.guides.springboot2.crud.modelRequests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostitRequest {

    private Long id;
    private String contenuto;
    private String scadenza;
    private Boolean stato;
    private Long userId;
}

package gk.calculator.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Entity
@Table(name = "operations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String operation;

    private Double result;
}

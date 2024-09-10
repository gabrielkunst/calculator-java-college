package gk.calculator.repositories;

import gk.calculator.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalculatorRepository extends JpaRepository<OperationEntity, UUID> {
}

package gk.calculator.services;

import gk.calculator.entities.OperationEntity;
import gk.calculator.repositories.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;

    private Double roundToTwoDecimals(Double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public OperationEntity sum(Double numberA, Double numberB) {
        Double result = roundToTwoDecimals(numberA + numberB);
        OperationEntity operationEntity = OperationEntity.builder()
                .operation("sum")
                .result(result)
                .build();
        return calculatorRepository.save(operationEntity);
    }

    public OperationEntity subtract(Double numberA, Double numberB) {
        Double result = roundToTwoDecimals(numberA - numberB);
        OperationEntity operationEntity = OperationEntity.builder()
                .operation("subtract")
                .result(result)
                .build();
        return calculatorRepository.save(operationEntity);
    }

    public OperationEntity multiply(Double numberA, Double numberB) {
        Double result = roundToTwoDecimals(numberA * numberB);
        OperationEntity operationEntity = OperationEntity.builder()
                .operation("multiply")
                .result(result)
                .build();
        return calculatorRepository.save(operationEntity);
    }

    public OperationEntity divide(Double numberA, Double numberB) {
        if (numberB == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        Double result = roundToTwoDecimals(numberA / numberB);
        OperationEntity operationEntity = OperationEntity.builder()
                .operation("divide")
                .result(result)
                .build();
        return calculatorRepository.save(operationEntity);
    }
}

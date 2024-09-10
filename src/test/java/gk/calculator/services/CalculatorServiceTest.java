package gk.calculator.services;

import gk.calculator.entities.OperationEntity;
import gk.calculator.repositories.CalculatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CalculatorServiceTest {

    @Mock
    private CalculatorRepository calculatorRepository;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Double roundToTwoDecimals(Double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Test
    public void testSum() {
        Double numberA = 10.123;
        Double numberB = 20.456;
        Double expectedResult = roundToTwoDecimals(numberA + numberB);

        OperationEntity operationEntity = OperationEntity.builder()
                .id(UUID.randomUUID())
                .operation("sum")
                .result(expectedResult)
                .build();

        when(calculatorRepository.save(any(OperationEntity.class))).thenReturn(operationEntity);

        OperationEntity result = calculatorService.sum(numberA, numberB);

        verify(calculatorRepository, times(1)).save(any(OperationEntity.class));
        assertNotNull(result);
        assertEquals("sum", result.getOperation());
        assertEquals(expectedResult, result.getResult());
    }

    @Test
    public void testSubtract() {
        Double numberA = 30.75;
        Double numberB = 10.25;
        Double expectedResult = roundToTwoDecimals(numberA - numberB);

        OperationEntity operationEntity = OperationEntity.builder()
                .id(UUID.randomUUID())
                .operation("subtract")
                .result(expectedResult)
                .build();

        when(calculatorRepository.save(any(OperationEntity.class))).thenReturn(operationEntity);

        OperationEntity result = calculatorService.subtract(numberA, numberB);

        verify(calculatorRepository, times(1)).save(any(OperationEntity.class));
        assertNotNull(result);
        assertEquals("subtract", result.getOperation());
        assertEquals(expectedResult, result.getResult());
    }

    @Test
    public void testMultiply() {
        Double numberA = 5.5;
        Double numberB = 4.4;
        Double expectedResult = roundToTwoDecimals(numberA * numberB);

        OperationEntity operationEntity = OperationEntity.builder()
                .id(UUID.randomUUID())
                .operation("multiply")
                .result(expectedResult)
                .build();

        when(calculatorRepository.save(any(OperationEntity.class))).thenReturn(operationEntity);

        OperationEntity result = calculatorService.multiply(numberA, numberB);

        verify(calculatorRepository, times(1)).save(any(OperationEntity.class));
        assertNotNull(result);
        assertEquals("multiply", result.getOperation());
        assertEquals(expectedResult, result.getResult());
    }

    @Test
    public void testDivide() {
        Double numberA = 9.99;
        Double numberB = 3.33;
        Double expectedResult = roundToTwoDecimals(numberA / numberB);

        OperationEntity operationEntity = OperationEntity.builder()
                .id(UUID.randomUUID())
                .operation("divide")
                .result(expectedResult)
                .build();

        when(calculatorRepository.save(any(OperationEntity.class))).thenReturn(operationEntity);

        OperationEntity result = calculatorService.divide(numberA, numberB);

        verify(calculatorRepository, times(1)).save(any(OperationEntity.class));
        assertNotNull(result);
        assertEquals("divide", result.getOperation());
        assertEquals(expectedResult, result.getResult());
    }

    @Test
    public void testDivideByZero() {
        Double numberA = 10.0;
        Double numberB = 0.0;

        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(numberA, numberB);
        });

        assertEquals("Cannot divide by zero.", thrown.getMessage());
    }
}

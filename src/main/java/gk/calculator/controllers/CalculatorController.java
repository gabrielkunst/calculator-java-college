package gk.calculator.controllers;

import gk.calculator.dtos.OperationDTO;
import gk.calculator.entities.OperationEntity;
import gk.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<OperationEntity> sum(@RequestBody OperationDTO operationDTO) {
        return new ResponseEntity<>(calculatorService.sum(operationDTO.getNumberA(), operationDTO.getNumberB()), HttpStatus.OK);
    }

    @PostMapping("/subtract")
    public ResponseEntity<OperationEntity> subtract(@RequestBody OperationDTO operationDTO) {
        return new ResponseEntity<>(calculatorService.subtract(operationDTO.getNumberA(), operationDTO.getNumberB()), HttpStatus.OK);
    }

    @PostMapping("/multiply")
    public ResponseEntity<OperationEntity> multiply(@RequestBody OperationDTO operationDTO) {
        return new ResponseEntity<>(calculatorService.multiply(operationDTO.getNumberA(), operationDTO.getNumberB()), HttpStatus.OK);
    }

    @PostMapping("/divide")
    public ResponseEntity<OperationEntity> divide(@RequestBody OperationDTO operationDTO) {
        return new ResponseEntity<>(calculatorService.divide(operationDTO.getNumberA(), operationDTO.getNumberB()), HttpStatus.OK);
    }
}

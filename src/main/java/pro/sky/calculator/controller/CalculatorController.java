package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(Exception.class)
    public String missingParams(Exception ex) {
        return "Параметр отсутствует!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return calculatorService.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
            return calculatorService.divide(a, b);
    }
}

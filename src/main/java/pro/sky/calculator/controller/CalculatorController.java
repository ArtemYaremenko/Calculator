package pro.sky.calculator.controller;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String missingParams(MissingServletRequestParameterException ex) {
        return "Введите аргумент!\n" +
                "{" + ex + "}" ;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String argumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return "Введён неправильный тип аргумента!\n" +
                "{" + ex + "}";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " + " + b + " = " + calculatorService.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " - " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + " * " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        if (b == 0) {
            return "Нельзя делить на 0";
        } else {
            return a + " / " + b + " = " + calculatorService.divide(a, b);
        }
    }
}

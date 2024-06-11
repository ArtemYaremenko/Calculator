package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String plus(int a, int b) {
            return a + " + " + b + " = " + (a + b);
    }

    @Override
    public String minus(int a, int b) {
        return a + " - " + b + " = " + (a - b);
    }

    @Override
    public String multiply(int a, int b) {
        return a + " * " + b + " = " + (a * b);
    }

    @Override
    public String divide(int a, int b) {
        try {
            return a + " / " + b + " = " + (a / b);
        } catch (ArithmeticException exception) {
            return "Нельзя делить на " + b + "!";
        }
    }
}

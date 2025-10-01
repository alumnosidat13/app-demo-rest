package pe.edu.idat.app_demo_rest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundamentosService {

    public String validarNumeroPrimo(int numero){
        if(numero < 2){
            return "NO es primo";
        }
        for(int i = 2; i <= Math.sqrt(numero); i++){
            if(numero % i == 0)
                return "No es primo";
        }
        return "Es primo";
    }

    public String calcularFactorial(int numero){
        if(numero < 0){
            return "No se puede calcular factorial";
        }
        long factorial = 1;
        for(int i=1; i <=numero; i++){
            factorial *=i;
        }
        return "El factorial es = " + factorial;
    }


    public List<Long> calcularFibonacci(
            int cantidadNumero){
        List<Long> fibonacci = new ArrayList<>();
        if(cantidadNumero <= 0){
            return fibonacci;
        }
        long num1 = 0, num2 = 1;
        for (long i = 0; i < cantidadNumero; i++){
            fibonacci.add(num1);
            long siguienteValor = num1 + num2;
            num1 = num2;
            num2 = siguienteValor;
        }
        return fibonacci;
    }

}

package pe.edu.idat.app_demo_rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.app_demo_rest.dto.FactorialDto;
import pe.edu.idat.app_demo_rest.dto.FibonacciDto;
import pe.edu.idat.app_demo_rest.dto.PrimoDto;
import pe.edu.idat.app_demo_rest.service.FundamentosService;

@RestController
@RequestMapping("/api/v1/operacion")
public class FundamentosController {
    private final FundamentosService fundamentosService;

    public FundamentosController(FundamentosService fundamentosService) {
        this.fundamentosService = fundamentosService;
    }
    //localhost:8055/api/v1/operacion/primo?numero=5
    @GetMapping("/primo")
    public ResponseEntity<PrimoDto>
            validarNumeroPrimo(
                    @RequestParam Integer numero){
        PrimoDto primoDto = new PrimoDto();
        primoDto.setNumero(numero);
        primoDto.setResultado(
                fundamentosService
                        .validarNumeroPrimo(numero));
        return ResponseEntity.ok(primoDto);
    }

    //localhost:8055/api/v1/operacion/factorial?numero=5
    @GetMapping("/factorial")
    public ResponseEntity<FactorialDto>
    calcularFactorial(@RequestParam(
            required = false,
            defaultValue = "2") Integer numero){
        FactorialDto factorialDto = new FactorialDto();
        factorialDto.setNumero(numero);
        factorialDto.setValorFactorial(
                fundamentosService
                        .calcularFactorial(numero));
        return ResponseEntity.ok(factorialDto);
    }

    @GetMapping({"/fibonacci", "/fibonacci/{numero}"})
    public ResponseEntity<FibonacciDto>
    calcularFibonacci(
            @PathVariable(required = false)
            Integer numero){
        if(numero == null) numero = 1;
        FibonacciDto fibonacciDto = new FibonacciDto();
        fibonacciDto.setCantidadNumero(numero);
        fibonacciDto.setFibonacci(
                fundamentosService
                        .calcularFibonacci(numero)
        );
        return ResponseEntity.ok(fibonacciDto);
    }

}

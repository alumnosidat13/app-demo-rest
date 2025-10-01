package pe.edu.idat.app_demo_rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.app_demo_rest.dto.PrimoDto;
import pe.edu.idat.app_demo_rest.service.FundamentosService;

@RestController
@RequestMapping("/api/v1/operacion")
public class FundamentosController {
    private final FundamentosService fundamentosService;

    public FundamentosController(FundamentosService fundamentosService) {
        this.fundamentosService = fundamentosService;
    }
    //localhost:8055/api/v1/operaciones/primo?numero=5
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

}

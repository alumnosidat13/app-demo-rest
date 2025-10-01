package pe.edu.idat.app_demo_rest.dto;

import java.util.ArrayList;
import java.util.List;

public class FibonacciDto {
    private Integer cantidadNumero;
    private List<Long> fibonacci = new ArrayList<>();

    public List<Long> getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(List<Long> fibonacci) {
        this.fibonacci = fibonacci;
    }

    public Integer getCantidadNumero() {
        return cantidadNumero;
    }

    public void setCantidadNumero(Integer cantidadNumero) {
        this.cantidadNumero = cantidadNumero;
    }
}

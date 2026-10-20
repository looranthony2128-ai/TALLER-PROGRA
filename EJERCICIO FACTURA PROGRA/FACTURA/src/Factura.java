public class Factura {

    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        establecerCantidad(cantidad);
        establecerPrecioPorArticulo(precioPorArticulo);
    }

    public void establecerNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String obtenerNumeroPieza() {
        return numeroPieza;
    }

    public void establecerDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public String obtenerDescripcionPieza() {
        return descripcionPieza;
    }

    /** Si la cantidad no es positiva, se guarda 0. */
    public void establecerCantidad(int cantidad) {
        this.cantidad = (cantidad > 0) ? cantidad : 0;
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    /** Si el precio no es positivo, se guarda 0.0. */
    public void establecerPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = (precioPorArticulo > 0) ? precioPorArticulo : 0.0;
    }

    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    /** Monto de la factura = cantidad * precio por artículo. */
    public double obtenerMontoFactura() {
        return cantidad * precioPorArticulo;
    }
}
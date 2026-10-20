import java.time.LocalDate; // Importamos LocalDate para obtener el año actual de forma automática

//La clase PerfilMedico almacena la información personal y médica básica de un usuario,
// permitiendo calcular su edad, frecuencia cardíaca máxima, rango esperado y el Índice de Masa Corporal (BMI).

public class PerfilMedico {

    // - variables de instancia (atributos)-
    // Son privados (encapsulamiento) para proteger los datos.
    private String primerNombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double alturaCm; // Altura almacenada en centímetros
    private double pesoKg;   // Peso almacenado en kilogramos

    // Constructor
    // Metodo especial que se ejecuta al crear un objeto con new. Inicializa todas las variables.
    public PerfilMedico(String primerNombre, String apellido, String sexo,
                        int diaNacimiento, int mesNacimiento, int anioNacimiento,
                        double alturaCm, double pesoKg) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    // -metodos establecer (setters) y obtener (getters) -
    // Permiten modificar (set) y consultar (get) cada atributo de forma segura.

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerApellido(String apellido) {
        this.apellido = apellido;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerSexo(String sexo) {
        this.sexo = sexo;
    }

    public String obtenerSexo() {
        return sexo;
    }

    public void establecerDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }

    public void establecerMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }

    public void establecerAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAlturaCm(double alturaCm) {
        this.alturaCm = alturaCm;
    }

    public double obtenerAlturaCm() {
        return alturaCm;
    }

    public void establecerPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double obtenerPesoKg() {
        return pesoKg;
    }

    // -metodos de calculo-

    //Calcula la edad actual de la persona restando el año de nacimiento al año actual.

    public int calcularEdad() {
        int anioActual = LocalDate.now().getYear(); // Obtiene el año actual del sistema (2026)
        return anioActual - anioNacimiento;
    }

    // Calcula la frecuencia cardíaca máxima según la AHA: 220 menos la edad.

    public int calcularFrecuenciaMaxima() {
        return 220 - calcularEdad();
    }

    // Calcula el límite inferior del rango de frecuencia cardíaca esperada.

    public double calcularFrecuenciaEsperadaMinima() {
        return calcularFrecuenciaMaxima() * 0.50;
    }

    // Calcula el límite superior del rango de frecuencia cardíaca esperada.

    public double calcularFrecuenciaEsperadaMaxima() {
        return calcularFrecuenciaMaxima() * 0.85;
    }

    //Calcula el Índice de Masa Corporal (BMI).
    //Fórmula: peso (kg) / altura (m)^2.
    //Como la altura se almacena en centímetros, se debe convertir a metros dividiendo entre 100.

    public double calcularBMI() {
        double alturaMetros = alturaCm / 100.0; // Conversión de cm a metros
        return pesoKg / (alturaMetros * alturaMetros);
    }
}
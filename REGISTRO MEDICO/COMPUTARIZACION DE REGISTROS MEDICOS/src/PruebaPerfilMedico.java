import javax.swing.JOptionPane; // Importamos JOptionPane para las ventanas emergentes

public class PruebaPerfilMedico {
    public static void main(String[] args) {

        // 1. Solicitud de datos al usuario mediante cuadros de diálogo (JOptionPane)
        String primerNombre = JOptionPane.showInputDialog("Ingrese el primer nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String sexo = JOptionPane.showInputDialog("Ingrese el sexo (Masculino/Femenino):");

        // Los datos ingresados con JOptionPane son siempre String, por lo que se deben convertir (parsear) a int o double
        int diaNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de nacimiento (ej. 15):"));
        int mesNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes de nacimiento (ej. 7):"));
        int anioNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de nacimiento (ej. 2005):"));

        double alturaCm = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura en centímetros (ej. 175.5):"));
        double pesoKg = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso en kilogramos (ej. 68.5):"));

        // 2. Creación del objeto PerfilMedico pasando los datos al constructor
        PerfilMedico miPerfil = new PerfilMedico(primerNombre, apellido, sexo,
                diaNacimiento, mesNacimiento, anioNacimiento,
                alturaCm, pesoKg);

        // 3. Construcción del mensaje de salida con toda la información y resultados calculados
        String resultado = "Perfil Medico del Paciente \n" +
                "Nombre completo: " + miPerfil.obtenerPrimerNombre() + " " + miPerfil.obtenerApellido() + "\n" +
                "Sexo: " + miPerfil.obtenerSexo() + "\n" +
                "Fecha de nacimiento: " + miPerfil.obtenerDiaNacimiento() + "/" +
                miPerfil.obtenerMesNacimiento() + "/" +
                miPerfil.obtenerAnioNacimiento() + "\n" +
                "Altura: " + miPerfil.obtenerAlturaCm() + " cm\n" +
                "Peso: " + miPerfil.obtenerPesoKg() + " kg\n\n" +
                "RESULTADOS MÉDICOS \n" +
                "Edad: " + miPerfil.calcularEdad() + " años\n" +
                "Frecuencia Cardíaca Máxima: " + miPerfil.calcularFrecuenciaMaxima() + " lpm\n" +
                "Rango Cardíaco Esperado: " + miPerfil.calcularFrecuenciaEsperadaMinima() + " - " +
                miPerfil.calcularFrecuenciaEsperadaMaxima() + " lpm\n" +
                "Índice de Masa Corporal (BMI): " + String.format("%.2f", miPerfil.calcularBMI()) + "\n\n" +
                "Valores de Referencia BMI\n" +
                "Bajo peso: menos de 18.5\n" +
                "Normal: entre 18.5 y 24.9\n" +
                "Sobrepeso: entre 25 y 29.9\n" +
                "Obeso: 30 o más";

        // 4. Mostrar el reporte final en una ventana emergente
        JOptionPane.showMessageDialog(null, resultado, "Registro Médico Digital", JOptionPane.INFORMATION_MESSAGE);

        // Termina la ejecución del programa de forma limpia
        System.exit(0);
    }
}
import java.util.List;
import javax.swing.JOptionPane;

public class ListaMenu {
    public static void main(String[] args) {
        int[] elementosIniciales = { 1, 1, 2, 3, 3, 4, 5, 6, 6, 7, 8, 9, 9, 10, 10, 11 }; // Elementos iniciales de la
                                                                                          // lista
        Lista lsl = new Lista(elementosIniciales);

        int opcion = 0, elemento;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Ingresar un dato al final de la lista\n2. Insertar después de un número en la lista\n3. Calcular promedio\n4. Eliminar nodo máximo\n5. Eliminar elementos mayores que un límite\n6. Mostrar todos los datos de la lista\n7. Generar nueva lista con elementos repetidos de la lista Inicial\n8. Mostrar la lista inversa\n9.Salir "));
            switch (opcion) {
                case 1:
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento"));
                    lsl.insertarAlFinal(elemento);
                    lsl.mostrarLista();
                    break;
                case 2:
                    int numeroExistente = Integer
                            .parseInt(JOptionPane.showInputDialog(null, "Ingrese el número existente"));
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresar el elemento a insertar después de " + numeroExistente));
                    boolean insertado = lsl.insertarDespuesDe(numeroExistente, elemento);
                    if (insertado) {
                        JOptionPane.showMessageDialog(null,
                                "Se ha insertado el elemento después de " + numeroExistente);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El número " + numeroExistente + " no se encontró en la lista.");
                    }
                    lsl.mostrarLista();
                    break;
                case 3:
                    double promedio = lsl.calcularPromedio();
                    JOptionPane.showMessageDialog(null, "El promedio de la lista es: " + promedio);
                    break;
                case 4:
                    lsl.eliminarNodoMaximo();
                    lsl.mostrarLista();
                    break;
                case 5:
                    int limite = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el límite"));
                    lsl.eliminarElementosMayoresQue(limite);
                    lsl.mostrarLista();
                    break;
                case 6:
                    lsl.mostrarLista();
                    break;
                case 7:
                    List<Integer> elementosRepetidos = lsl.encontrarElementosRepetidos();
                    System.out.print("ListaElementosRepetidos: " + elementosRepetidos);
                    break;
                case 8:
                    List<Integer> listaInversa = lsl.obtenerListaInversa();
                    JOptionPane.showMessageDialog(null, "Lista inversa: " + listaInversa);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Incorrecta");
            }
        } while (opcion != 9);
    }
}

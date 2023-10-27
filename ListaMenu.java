import java.util.List;

import javax.swing.JOptionPane;

public class ListaMenu {
    public static void main(String[] args) {
        int[] elementosIniciales = {10,7,7,10,10, 20,30,40,40,10,20}; // Elementos iniciales de la lista
        Lista lsl = new Lista(elementosIniciales);

        
        int opcion = 0, elemento;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Ingresar un dato al final de la lista\n2. Insertar después de un número en la lista\n3. Calcular promedio\n4. Eliminar nodo máximo\n5. Eliminar elementos mayores que un límite\n6. Mostrar todos los datos de la lista\n7. Encontrar elementos repetidos de la lista \n8. Salir"));
            switch (opcion) {
                case 1:
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el elemento"));
                    lsl.insertarAlFinal(elemento);
                    lsl.mostrarLista();
                    break;
                case 2:
                    int numeroExistente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número existente"));
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el elemento a insertar después de " + numeroExistente));
                    boolean insertado = lsl.insertarDespuesDe(numeroExistente, elemento);
                    if (insertado) {
                        JOptionPane.showMessageDialog(null, "Se ha insertado el elemento después de " + numeroExistente);
                    } else {
                        JOptionPane.showMessageDialog(null, "El número " + numeroExistente + " no se encontró en la lista.");
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
                    JOptionPane.showMessageDialog(null, "Elementos repetidos: " + elementosRepetidos);
                    break;
                case 8:
                    List<Integer> listaInversa = lsl.obtenerListaInversa();
                    System.out.println("Lista inversa: " + listaInversa);
                    break;
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción Incorrecta");
            }
        } while (opcion != 7);
    }
}

package org.programacionFuncional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP Para <b>ejecutar</b> el código, presione <shortcut actionId="Run"/> o
// Haga clic en el icono <icon src="AllIcons.Actions.Execute"/> en el margen del editor.
public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Alice", 30, 50000, "IT"),
                new Empleado("Bob", 25, 45000, "HR"),
                new Empleado("Charlie", 35, 70000, "Finance"),
                new Empleado("David", 40, 60000, "IT"),
                new Empleado("Eve", 28, 48000, "HR")
        );

        // Filtrar empleados de IT
        List<Empleado> empleadosIT = empleados.stream()
                .filter(e -> "IT".equals(e.getDepartamento()))
                .collect(Collectors.toList());
        empleadosIT.forEach(System.out::println);

        // Obtener una lista de nombres de empleados
        List<String> nombres = empleados.stream()
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        nombres.forEach(System.out::println);

        // Calcular el salario promedio
        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0);
        System.out.println("Salario Promedio: " + salarioPromedio);

        // Aumentar el salario en un 10% a todos los empleados
        List<Empleado> empleadosConAumento = empleados.stream()
                .map(e -> new Empleado(e.getNombre(), e.getEdad(), e.getSalario() * 1.10, e.getDepartamento()))
                .collect(Collectors.toList());
        empleadosConAumento.forEach(System.out::println);

        // Agrupar empleados por departamento
        Map<String, List<Empleado>> empleadosPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));
        empleadosPorDepto.forEach((departamento, emps) -> {
            System.out.println(departamento);
            emps.forEach(System.out::println);
        });
    }
}
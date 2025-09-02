public class App {
    public static void main(String[] args) throws Exception {
        AVL<Integer> avl = new AVL<>();
        avl.insertar(12);
        avl.insertar(15);
        avl.insertar(1);
        avl.inOrder();
        AVL<Empleado> avlEmpleados = new AVL<>();
        avlEmpleados.insertar(new Empleado(12, "Juan"));
        avlEmpleados.insertar(new Empleado(8, "Pedro"));
        avlEmpleados.insertar(new Empleado(1, "Carlos"));
        avlEmpleados.inOrder();
    }
}

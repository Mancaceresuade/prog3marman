import java.util.ArrayList;
import java.util.List;

public class AVL<T extends Comparable<? super T>> {
	private Nodo raiz;
	private int tamanio;

	private class Nodo {
		T elem;
		Nodo izq;
		Nodo der;
		int altura;

		Nodo(T elem) {
			this.elem = elem;
			this.altura = 1; // altura de hoja = 1
		}
	}

	public boolean estaVacio() {
		return tamanio == 0;
	}

	public int size() {
		return tamanio;
	}

	public void limpiar() {
		raiz = null;
		tamanio = 0;
	}

	public int altura() {
		return altura(raiz);
	}

	public boolean contiene(T elemento) {
		if (elemento == null) throw new IllegalArgumentException("Elemento null no permitido");
		return contiene(raiz, elemento);
	}

	public void insertar(T elemento) {
		if (elemento == null) throw new IllegalArgumentException("Elemento null no permitido");
		int antes = tamanio;
		raiz = insertar(raiz, elemento);
		// solo incrementar si realmente se insertó (no duplicado)
		if (tamanio == antes) {
			// si no cambió en insertar recursivo (duplicado), no alterar tamaño
		} else {
			// tamanio ya incrementado dentro de insertar cuando crea nodo
		}
	}

	public void eliminar(T elemento) {
		if (elemento == null) throw new IllegalArgumentException("Elemento null no permitido");
		int antes = tamanio;
		raiz = eliminar(raiz, elemento);
		// si no estaba, tamanio no cambia
	}

	public T minimo() {
		if (estaVacio()) throw new IllegalStateException("Árbol vacío");
		Nodo n = raiz;
		while (n.izq != null) n = n.izq;
		return n.elem;
	}

	public T maximo() {
		if (estaVacio()) throw new IllegalStateException("Árbol vacío");
		Nodo n = raiz;
		while (n.der != null) n = n.der;
		return n.elem;
	}

	public List<T> inOrden() {
		List<T> resultado = new ArrayList<>();
		inOrden(raiz, resultado);
		return resultado;
	}

	public List<T> preOrden() {
		List<T> resultado = new ArrayList<>();
		preOrden(raiz, resultado);
		return resultado;
	}

	public List<T> postOrden() {
		List<T> resultado = new ArrayList<>();
		postOrden(raiz, resultado);
		return resultado;
	}

	// =========================
	// Implementación interna
	// =========================

	private boolean contiene(Nodo nodo, T elemento) {
		if (nodo == null) return false;
		int cmp = elemento.compareTo(nodo.elem);
		if (cmp == 0) return true;
		if (cmp < 0) return contiene(nodo.izq, elemento);
		return contiene(nodo.der, elemento);
	}

	private Nodo insertar(Nodo nodo, T elemento) {
		if (nodo == null) {
			tamanio++;
			return new Nodo(elemento);
		}
		int cmp = elemento.compareTo(nodo.elem);
		if (cmp < 0) {
			nodo.izq = insertar(nodo.izq, elemento);
		} else if (cmp > 0) {
			nodo.der = insertar(nodo.der, elemento);
		} else {
			// duplicado: no insertar; podría actualizar valor si fuera par clave/valor
			return nodo;
		}
		actualizarAltura(nodo);
		return equilibrar(nodo);
	}

	private Nodo eliminar(Nodo nodo, T elemento) {
		if (nodo == null) return null;
		int cmp = elemento.compareTo(nodo.elem);
		if (cmp < 0) {
			nodo.izq = eliminar(nodo.izq, elemento);
		} else if (cmp > 0) {
			nodo.der = eliminar(nodo.der, elemento);
		} else {
			// nodo a eliminar
			if (nodo.izq == null || nodo.der == null) {
				Nodo reemplazo = (nodo.izq != null) ? nodo.izq : nodo.der;
				if (reemplazo == null) {
					// hoja
					nodo = null;
				} else {
					// un hijo
					nodo = reemplazo;
				}
				tamanio--;
			} else {
				// dos hijos: tomar sucesor (mínimo del subárbol derecho)
				Nodo sucesor = minNodo(nodo.der);
				nodo.elem = sucesor.elem;
				// eliminar el sucesor en el subárbol derecho
				nodo.der = eliminar(nodo.der, sucesor.elem);
				// NO decrementar tamanio aquí porque eliminar(sucesor) ya lo hizo
			}
		}

		if (nodo == null) return null;
		actualizarAltura(nodo);
		return equilibrar(nodo);
	}

	private Nodo minNodo(Nodo nodo) {
		Nodo actual = nodo;
		while (actual.izq != null) actual = actual.izq;
		return actual;
	}

	private void inOrden(Nodo nodo, List<T> out) {
		if (nodo == null) return;
		inOrden(nodo.izq, out);
		out.add(nodo.elem);
		inOrden(nodo.der, out);
	}

	private void preOrden(Nodo nodo, List<T> out) {
		if (nodo == null) return;
		out.add(nodo.elem);
		preOrden(nodo.izq, out);
		preOrden(nodo.der, out);
	}

	private void postOrden(Nodo nodo, List<T> out) {
		if (nodo == null) return;
		postOrden(nodo.izq, out);
		postOrden(nodo.der, out);
		out.add(nodo.elem);
	}

	// =========================
	// Balanceo AVL
	// =========================
	private int altura(Nodo n) {
		return (n == null) ? 0 : n.altura;
	}

	private void actualizarAltura(Nodo n) {
		n.altura = 1 + Math.max(altura(n.izq), altura(n.der));
	}

	private int factorBalance(Nodo n) {
		return (n == null) ? 0 : altura(n.izq) - altura(n.der);
	}

	private Nodo equilibrar(Nodo n) {
		int fb = factorBalance(n);
		// Caso Izq-Izq
		if (fb > 1 && factorBalance(n.izq) >= 0) {
			return rotarDerecha(n);
		}
		// Caso Izq-Der
		if (fb > 1 && factorBalance(n.izq) < 0) {
			n.izq = rotarIzquierda(n.izq);
			return rotarDerecha(n);
		}
		// Caso Der-Der
		if (fb < -1 && factorBalance(n.der) <= 0) {
			return rotarIzquierda(n);
		}
		// Caso Der-Izq
		if (fb < -1 && factorBalance(n.der) > 0) {
			n.der = rotarDerecha(n.der);
			return rotarIzquierda(n);
		}
		return n;
	}

	private Nodo rotarDerecha(Nodo y) {
		Nodo x = y.izq;
		Nodo T2 = x.der;
		x.der = y;
		y.izq = T2;
		actualizarAltura(y);
		actualizarAltura(x);
		return x;
	}

	private Nodo rotarIzquierda(Nodo x) {
		Nodo y = x.der;
		Nodo T2 = y.izq;
		y.izq = x;
		x.der = T2;
		actualizarAltura(x);
		actualizarAltura(y);
		return y;
	}

    
}

package fanglab.framework;

public class SlRef<T> {
	private T value;

	public SlRef(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}

	public void set(T anotherValue) {
		value = anotherValue;
	}

	public String toString() {
		return value.toString();
	}

	public boolean equals(Object obj) {
		return value.equals(obj);
	}

	public int hashCode() {
		return value.hashCode();
	}
}

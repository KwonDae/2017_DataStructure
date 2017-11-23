package Work01_1;

public class ArrayStack implements Stack {
	
	Object[] arr = new Object[2];
	int size=2, top=-1;
	
	
	@Override
	public void push(Object object) {
		if(arr.length >= size ) {
			this.resize();
		}
		arr[++top] = object;
		System.out.println("PUSH: "+object);
	}

	@Override
	public Object pop() {
		if( top == -1) {
			System.out.println("Stack is empty");
			return -1;
		} 
		Object temp = arr[top];
		arr[top--] = 0;
		System.out.println("POP: "+temp);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if(arr.length == 0) {
			System.out.println("Stack is empty");
			return true;
		} else {
			System.out.println("Stack isn't empty");
			return false;
		}
	}

	@Override
	public Object peek() {
		return arr[top];
	}

	@Override
	public void resize() {
		
		Object[] temp = new Object[2*arr.length];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr=temp;
		
	}

}

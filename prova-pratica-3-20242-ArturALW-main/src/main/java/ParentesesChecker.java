public class ParentesesChecker {
	private LinkedList listaParenteses;

	public ParentesesChecker(){
		this.listaParenteses = new LinkedList();
	}

	public boolean checkParenteses(String parenteses) {
		LinkedList listaParenteses = new LinkedList();

		for(int i = 0; i < parenteses.length(); i++) {
			String atual = parenteses.substring(i, i+1);
			if(listaParenteses.isEmpty()) {
				if(atual.equals(")")) {
					return false;
				} else {
					listaParenteses.addLast(atual);
				}
			} else {
				if(atual.equals(")")) {
					listaParenteses.removeLast();
				} else {
					listaParenteses.addLast(atual);
				}
			}
		}

		if(listaParenteses.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}


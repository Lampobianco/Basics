package com.betacom.objects;

public class Inner {
	private String fatherClass;
	private int numero;
	private Figlio f;

	public class Figlio {
		private int numero2;
		private String figlioClass;
		private Nipote n;

		public class Nipote extends User{
			private int numero3;
			private String nipoteClass;
			public int getNumero3() {
				return numero3;
			}
			public void setNumero3(int numero3) {
				this.numero3 = numero3;
			}
			public String getNipoteClass() {
				return nipoteClass;
			}
			public void setNipoteClass(String nipoteClass) {
				this.nipoteClass = nipoteClass;
			}

			public String displayNumberNipote() {
				return "numero padre -> " + numero + " Figlio Numero -> " + numero2 + " Nipote numero -> " + numero3;
			}
		}

		public int getNumero2() {
			return numero2;
		}
		public void setNumero2(int numero2) {
			this.numero2 = numero2;
		}
		public String getFiglioClass() {
			return figlioClass;
		}
		public void setFiglioClass(String figlioClass) {
			this.figlioClass = figlioClass;
		}
		public Nipote getN() {
			return n;
		}
		public void setN(Nipote n) {
			this.n = n;
		}
		
		public Nipote setInstane() {
			n = new Nipote();
			return n;
		}

		public Nipote setInstanceNipote() {
			n = new Nipote();
			return n;
		}

		public String displayNumber() {
			return "numero padre -> " + numero + " Figlio Numero -> " + numero2;
		}
		
		
	}

	public String getFatherClass() {
		return fatherClass;
	}
	public void setFatherClass(String fatherClass) {
		this.fatherClass = fatherClass;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Figlio getF() {
		return f;
	}
	public void setF(Figlio f) {
		this.f = f;
	}

	public Figlio setInstanceFiglio() {
		f = new Figlio();
		return f;
	}
}

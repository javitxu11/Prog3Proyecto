package clasesNoVisuales;

import estructuras.JLabelMario;


/**
 * Clase heredera de personaje que define las instancias l�gicas de Mario
 * hola
 */

public class Mario extends Personaje{
	
	private JLabelMario Grafico; // Atributo de etiqueta gr�fica para mario
	public boolean salto; // Atributo que guarda si Mario ha realizado un salto
	public boolean caida; // Atributo que guarda si ha habido o no una caida
	public boolean cont; // Atributo contador
	public int velY;
	public int velX;
	
	/**  Crea un nuevo personaje de juego (Mario)
	 */
	
	public Mario() {
		salto = false;
		caida = false;
		cont = true;
		Grafico = new JLabelMario();
		velY = 0;
		velX = 1;
	}
	
	/** Devuelve el JLabel gr�fico asociado al Mario de juego
	 * @return	Etiqueta gr�fica del Mario
	 */
	
	public JLabelMario getGrafico() {
		return Grafico;
	}

	/**
	 * Getters y setters de los atributos de Mario
	 * @return el atributo en cuestion
	 */
	
	public void setPosX(double posX) {
		super.setPosX(posX);
		Grafico.setLocation((int) posX, Grafico.getY());

	}

	public void setPosY(double posY) {
		super.setPosY(posY);
		Grafico.setLocation((Grafico.getX()), (int) posY);
	}
	
	
	public boolean isCaida() {
		return caida;
	}



	public boolean isCont() {
		return cont;
	}



	public void setCaida(boolean caida) {
		this.caida = caida;
	}



	public void setCont(boolean cont) {
		this.cont = cont;
	}
	


	public boolean isSalto() {
		return salto;
	}



	public void setSalto(boolean salto) {
		this.salto = salto;
	}

	public void setGrafico(JLabelMario grafico) {
		Grafico = grafico;
	}	

	/**
	 * M�todo que implementa el salto de este personaje 
	 */

	public void saltoMario() {
		getGrafico().setComponentOrientationSalto();
		salto=true;
		velY=-1;
	}
}


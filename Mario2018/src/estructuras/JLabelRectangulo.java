package estructuras;

import java.awt.Color;
import javax.swing.JLabel;

public class JLabelRectangulo extends JLabel {
	private static final long serialVersionUID = 1L; // Para serializaci�n
	
	public static final int TAMANYO_BLOQUE = 32; // p�xels (igual ancho que largo)
	
	

	/**
	 * Construye y devuelve el JLabel del Bloque con su gr�fico y tama�o
	 */
	
	public JLabelRectangulo() {
		setOpaque(false);
		setBackground(Color.YELLOW);
		setBounds(0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE);

	}


}
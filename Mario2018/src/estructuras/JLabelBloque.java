package estructuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelBloque extends JLabel {
	private static final long serialVersionUID = 1L; // Para serializaci�n
	
	public static final int TAMANYO_BLOQUE = 28; // p�xels (igual ancho que largo)
	
	

	/**
	 * Construye y devuelve el JLabel del Bloque con su gr�fico y tama�o
	 */
	
	public JLabelBloque() {
		
		try {

			setIcon(new ImageIcon(JLabelBloque.class.getResource("/Imagenes/bloqueMario.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: bloqueMario.jpg no encontrado");
			e.printStackTrace();
		}
		setVisible(true);
		setBounds(0, 0, TAMANYO_BLOQUE+1, TAMANYO_BLOQUE+1);

	}
	
	/**
	 * M�todo para pintar el componente de Bloque
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado
		// normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado m�s fino con estos 3 par�metros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotaci�n (siguientes operaciones se rotar�n)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE, null);
	
	}
}

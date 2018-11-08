
package estructuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelPersonaje2 extends JLabel {
	private static final long serialVersionUID = 8L; // Para serializaci�n
	
	public static final int TAMANYO_PERSONAJE2x = 23; // p�xels (igual ancho que largo)
	public static final int TAMANYO_PERSONAJE2y = 31; // p�xels (igual ancho que largo)
	
	
	public static final int ARISTA_RECTANGULO_PERSONAJE2 = 30; // Radio en p�xels del rectangulo del Mario(para choques)
	
	private static final boolean DIBUJAR_RECTANGULO_PERSONAJE2= false; // Dibujado (paradepuraci�n)del bounding rectangle de choque de Mario
	
	private boolean Espejo = false; //Atributo para saber si hay que aplicarle el m�todo de espejo a la imagen de Mario
	

	/**
	 * Construye y devuelve el JLabel del Mario con su gr�fico y tama�o
	 */
	
	public JLabelPersonaje2() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2Quieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2Quieto.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);

	}
	
	/**
	 * M�todo para pintar el componente de Mario
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado m�s fino con estos 3 par�metros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotaci�n (siguientes operaciones se rotar�n)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y, null);
		if (DIBUJAR_RECTANGULO_PERSONAJE2)
			g2.drawRect(0,0,ARISTA_RECTANGULO_PERSONAJE2,ARISTA_RECTANGULO_PERSONAJE2);	
			}
	
	/**
	 * M�todo para Obtener la imagen de Mario corriendo en Modo espejo
	 */

	public void setComponentOrientationEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2Espejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2Espejo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);
		Espejo = true;

	}
	
	/**
	 * M�todo para Obtener la imagen de Mario corriendo en Modo normal
	 */

	public void setComponentOrientationNormal() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2Andando.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2Andando.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);
		Espejo = false;

	}
	
	/**
	 * M�todo para Obtener la imagen de Mario Saltando en Modo normal
	 */

	public void setComponentOrientationSalto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2Salto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2Salto.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);
		Espejo = false;

	}
	
	/**
	 * M�todo para Obtener la imagen de Mario Saltando en Modo espejo
	 */

	public void setComponentOrientationSaltoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2SaltandoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2SaltandoEspejo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x,TAMANYO_PERSONAJE2y );
		Espejo = true;
	}
	
	public void setComponentOrientationMarioQuieto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/Personaje2Quieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Personaje2Quieto.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);
		Espejo = false;
	}
	
	public void setComponentOrientationMarioQuietoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioQuietoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_PERSONAJE2x, TAMANYO_PERSONAJE2y);
		Espejo = true;
	}
	
	/**
	 * M�todo get que sirve para saber si el componente est� en espejo
	 * @return si es o no espejo
	 */
	
	public boolean EsEspejo() {
		return Espejo;
	}

}
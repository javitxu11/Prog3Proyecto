package estructuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import clasesNoVisuales.Mario;
import clasesNoVisuales.Mundo;

public class JLabelMario extends JLabel {
	private static final long serialVersionUID = 8L; // Para serializaci�n
	
	public static final int TAMANYO_MARIOx = 23; // p�xels (igual ancho que largo)
	public static final int TAMANYO_MARIOy = 31; // p�xels (igual ancho que largo)
	
	public String Npersonaje="MARIO";
	public static final int ARISTA_RECTANGULO_MARIO = 30; // Radio en p�xels del rectangulo del Mario(para choques)
	
	private static final boolean DIBUJAR_RECTANGULO_MARIO = false; // Dibujado (paradepuraci�n)del bounding rectangle de choque de Mario
	
	private boolean Espejo = false; //Atributo para saber si hay que aplicarle el m�todo de espejo a la imagen de Mario
	public static int estadoDerecha=0;
	public static int estadoIzquierda=0;
	public static int personaje;

	/**
	 * Construye y devuelve el JLabel del Mario con su gr�fico y tama�o
	 */
	
	public JLabelMario() {
		
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Quieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioQuieto.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIOx, TAMANYO_MARIOy);

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
		g2.drawImage(img, 0, 0, TAMANYO_MARIOx, TAMANYO_MARIOy, null);
		if (DIBUJAR_RECTANGULO_MARIO)
			g2.drawRect(0,0,ARISTA_RECTANGULO_MARIO,ARISTA_RECTANGULO_MARIO);	
			}
	
	/**
	 * M�todo para Obtener la imagen de Mario corriendo en Modo espejo
	 */

	public void setComponentOrientationEspejo() {
		
		if(estadoIzquierda==0 && Mario.velY ==0  ) {
			try {
				setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Espejo.png").toURI().toURL()));
			} catch (Exception e) {
				System.err.println("Error en carga de recurso: MarioEspejo.png no encontrado");
				e.printStackTrace();
			}
			setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
			Espejo = true;
			
			}else if (estadoIzquierda==1 &&Mario.velY ==0  ) {
				try {
					setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"QuietoEspejo.png").toURI().toURL()));
					
				} catch (Exception e) {
					System.err.println("Error en carga de recurso: MarioQuietoEspejo.png no encontrado");
					e.printStackTrace();
				}
				setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
				Espejo = true;
				
				
			}
	}
	
	
	/**
	 * M�todo para Obtener la imagen de Mario corriendo en Modo normal
	 */

	public void setComponentOrientationNormal() {
		if(estadoDerecha==0 && Mario.velY ==0   ) {
		try {
			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Andando.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioAndando.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;
		
		}else if (estadoDerecha==1 && Mario.velY ==0   ) {
			try {
				setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Quieto.png").toURI().toURL()));
			
			} catch (Exception e) {
				System.err.println("Error en carga de recurso: MarioQuieto.png no encontrado");
				e.printStackTrace();
			}
			setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
			Espejo = false;
			
			
		}
	}
	/**
	 * M�todo para Obtener la imagen de Mario Saltando en Modo normal
	 */

	public void setComponentOrientationSalto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Salto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioSalto.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;

	}
	
	/**
	 * M�todo para Obtener la imagen de Mario Saltando en Modo espejo
	 */

	public void setComponentOrientationSaltoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"SaltoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioSaltoEspejo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = true;
	}
	
	public void setComponentOrientationMarioQuieto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"Quieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;
	}
	
	public void setComponentOrientationMarioQuietoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/"+Npersonaje+"QuietoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
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
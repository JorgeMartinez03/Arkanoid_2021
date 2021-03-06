package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola(double width, double height) {
		super(width, height);
	}

	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}

	public void muevete(Arkanoid ark){
		//rebote con el suelo y techo
		if (getY() > ark.getHeight() || getY() < 0){
			dy = dy * -1;
		}

		//rebote con la pared dcha e izqda
		if (getX() > ark.getWidth() || getX() < 0){
			dx = dx * -1;
		}   
		if (chequeaColision(getX(),getY(), ark)){
			if (chequeaColision(getX() + getWidth(), getY(), ark)){
				if (chequeaColision(getX(),getY()+ getHeight(), ark)){
					if (chequeaColision(getX()+getWidth(),getY()+ getHeight(), ark)){

					}
				}
			}
		}


		//mueve la bola en la direcci?n correcta
		this.move(dx,dy);
	}
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy);

		if(auxiliar == ark.miCursor){
			dy = dy * -1;
			noHaChocado = false;
		}else if(auxiliar == null){
		}else if (auxiliar instanceof Ladrillo){
			if(auxiliar.getY() + getHeight() == posy || auxiliar.getY() == posy ){
				dy = dy * -1;
			}
			else if(auxiliar.getY() + getWidth() == posx || auxiliar.getX() == posx ){
				dx = dx * -1;
			}
			ark.remove(auxiliar);
			noHaChocado = false;
		}

		return noHaChocado;

	}
}

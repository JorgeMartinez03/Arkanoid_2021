package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram{

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;

	Bola bola1 = new Bola(10,10, Color.BLUE);
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.GREEN);
	public void init(){
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);

	}

	public void run(){
		creaPiramide();
		while(true){	
			//acciones que cambian el contenido de la pantalla
			bola1.muevete(this);
			pause(1);
			miCursor.muevete(getWidth(), (int)bola1.getX());
		}
	}

	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(getWidth(), evento.getX());
	}



	private void creaPiramide(){
		int numeroLadrillos=14;

		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j,ALTO_LADRILLO*j,ANCHO_LADRILLO,ALTO_LADRILLO,Color.BLUE);
				add(miLadrillo);
			}
		}
	}


}

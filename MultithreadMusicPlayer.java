 /**************************************************************************
**
**    Handles separate music thread for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    When provided a complex number, this thread will play a chord
**    progression based on the real and imaginary components.
**************************************************************************/


import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;

public class MultithreadMusicPlayer extends Thread{

	private ComplexNumber input;
	private Player musicPlayer;
	
	public MultithreadMusicPlayer(ComplexNumber c) {
		input = c;
		musicPlayer = new Player();
	}
	
	public void run(){
    
        try {
            
        	double real = input.getRealComponent();
        	double imag = input.getImagComponent();
	    	        	
        	Rhythm percussion = new Rhythm().addLayer("..X...X...X...XO");
        	
        	//top right corner
        	if(real >= 0 && imag >= 0) {
        		Pattern bass = new ChordProgression("I").eachChordAs("$!i $!i Ri $!i").getPattern().setInstrument("Acoustic_Bass");
            	musicPlayer.play(bass,percussion);
        	} 
        	
        	//bottom right corner
        	if(real >= 0 && imag < 0) {
        		Pattern bass = new ChordProgression("IV").eachChordAs("$!i $!i Ri $!i").getPattern().setInstrument("Acoustic_Bass");
            	musicPlayer.play(bass,percussion);
        	} 
        	
        	//top left corner
        	if(real < 0 && imag >= 0) {
        		Pattern bass = new ChordProgression("vi").eachChordAs("$!i $!i Ri $!i").getPattern().setInstrument("Acoustic_Bass");
            	musicPlayer.play(bass,percussion);
        	}
        	
        	//bottom left corner
        	if(real < 0 && imag < 0) {
        		Pattern bass = new ChordProgression("V").eachChordAs("$!i $!i Ri $!i").getPattern().setInstrument("Acoustic_Bass");
            	musicPlayer.play(bass,percussion);
        	}
        	
        }catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }

	
	
}

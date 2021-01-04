import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyboardInput implements KeyListener 
{
     private static final int KEY_COUNT = 522;
     private enum State 
     {
         RELEASED,
         PRESSED,  
         ONCE      
     }
     private boolean[] currentKeys = null;
     private static int keyPressed = 0;
     private State[] keys = null;
     static char val = ' '; 
     static char val2 = ' '; 
     static boolean check = true;
     static boolean check2 = true;
     static boolean check3 = true;
  public KeyboardInput() {
    currentKeys = new boolean[ KEY_COUNT ];
    keys = new State[ KEY_COUNT ];
    for( int i = 0; i < KEY_COUNT; ++i ) 
    {
       keys[ i ] = State.RELEASED;
    }
  }
        
  public synchronized void poll() {
    for( int i = 0; i < KEY_COUNT; ++i ) {
      // Set the key state 
      if( currentKeys[ i ] ) {
        // If the key is down now, but was not
        // down last frame, set it to ONCE,
        // otherwise, set it to PRESSED
        if( keys[ i ] == State.RELEASED )
          keys[ i ] = State.ONCE;
        else
          keys[ i ] = State.PRESSED;
      } else {
        keys[ i ] = State.RELEASED;
      }
    }
  }
        
  public boolean keyDown( int keyCode ) 
  {
     check = false;
    return keys[ keyCode ] == State.ONCE ||keys[ keyCode ] == State.PRESSED;
  }
        
  public boolean keyDownOnce( int keyCode ) 
  {
    check = true;
    return keys[ keyCode ] == State.ONCE;
  }
        
  public synchronized void keyPressed( KeyEvent e ) {
    int keyCode = e.getKeyCode();
    if( keyCode >= 0 && keyCode < KEY_COUNT ) {
      currentKeys[ keyCode ] = true;
    }
    check2 = true;
  }

  public synchronized void keyReleased( KeyEvent e ) {
    int keyCode = e.getKeyCode();
    if( keyCode >= 0 && keyCode < KEY_COUNT ) {
      currentKeys[ keyCode ] = false;
    }
    check2 = false;
  }

  public void keyTyped( KeyEvent e ) 
  {
      check3 = true;
      val = e.getKeyChar(); 
  }
}
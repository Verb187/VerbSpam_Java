import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.awt.AWTException;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Robot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jnativehook.dispatcher.SwingDispatchService;

public class GlobalKeyListenerExample implements NativeKeyListener, Runnable {
        Robot robot = null;
        private boolean running = false;
        
          static int keyInput[] = { 
              KeyEvent.VK_X, 
              KeyEvent.VK_ENTER, 
              KeyEvent.VK_X,
              KeyEvent.VK_ENTER, 
              KeyEvent.VK_X,
              KeyEvent.VK_ENTER,
              KeyEvent.VK_X,
              KeyEvent.VK_ENTER,

          
          
          };
        
    
	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
                   System.out.println("wsh fdp");
                   if(!running) {
                        running = true;
                        new Thread(this).start();
                    }
                        else {
                        running = false;

                    } 
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
	}

	public static void main(String[] args) {
                    JFrame frame = new JFrame();
                    JPanel panel = new JPanel(new FlowLayout());
                    JTextArea textArea = new JTextArea(5, 20);
                    panel.add(textArea);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(500, 500);
                    frame.setVisible(true);
                    
		try {
			GlobalScreen.registerNativeHook();
                        
		}
		catch (NativeHookException ex) {
			System.err.println("");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
	}


    public void run() {
         JTextArea textArea = new JTextArea(5, 20);
         textArea.setText("x\n" +
"x\n" +
"x\n" +
"x\n" +
".doliprqne\n" +
"x\n" +
"x\n" +
"x\n" +
".boire cocq\n" +
"\n" +
"");
    Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(GlobalKeyListenerExample.class.getName()).log(Level.SEVERE, null, ex);
        }    
            int[] keys = new int[textArea.getText().length()];
                for(int i = 0; i < keys.length; i++) {
            keys[i] = KeyEvent.getExtendedKeyCodeForChar(textArea.getText().charAt(i));
        }
            while(running) {
                
                for(int i = 0; i < keys.length; i++) {
                robot.keyPress(keys[i]);
            }
            }
    }
}
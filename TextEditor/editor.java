package TextEditor;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.text.BadLocationException;
public class editor {
	public static JTextPane code;
	public static String codeText = "";
	public static void syntax(){
		System.out.println(codeText);
		code.setText("<div style='color:white; font-size:14px; font-family: Courier New'>"+codeText.replace(" ","&nbsp;").replace("\n","<br>").replace("def","<a style='color:purple'>def</a>")+"</div>");
	}
    public static void buildFrame(){
    	JFrame frame = new JFrame("Code Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	frame.setSize(screenSize.width, screenSize.height);
		frame.setBounds(0, 0, screenSize.width, screenSize.height);
		
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 24);

        JTextPane filePath = new JTextPane();

		filePath.setMargin(new Insets(10,10,10,10));
		filePath.setBackground(new Color(40,40,40));
        filePath.setForeground(Color.WHITE);
        filePath.setCaretColor(Color.RED);

        code = new JTextPane();

		code.setMargin(new Insets(10,10,10,10));
		code.setBackground(new Color(10,10,10));
        code.setForeground(Color.WHITE);
        code.setCaretColor(Color.RED);
        code.setContentType("text/html");
        code.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {


	        }
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	
	        	switch (e.getKeyChar()) {
	        		case KeyEvent.VK_BACK_SPACE: 
	        			if(codeText.length()>0) {
	        				codeText=codeText.substring(0,codeText.length()-1);
	        			}
	        			break;
	        		case KeyEvent.VK_ENTER: 
	        			codeText+='\n';
	        			break;
	        		case KeyEvent.VK_TAB: 
	        			codeText+="  ";
	        			break;
	        		default:
	       				codeText+=e.getKeyChar();
	        			break;
	        	}
	        	
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	        	syntax();
	        }
	    });
   		//code.getDocument().addDocumentListener(new codeChanged());

        JTextPane terminal = new JTextPane();

		terminal.setPreferredSize(new Dimension(0,100));

		terminal.setMargin(new Insets(10,10,10,10));
        terminal.setForeground(Color.WHITE);
		terminal.setBackground(new Color(40,40,40));
        terminal.setCaretColor(Color.RED);


        JButton nothing = new JButton("");
        nothing.setPreferredSize(new Dimension(0, 0));

        frame.getContentPane().add(filePath,BorderLayout.PAGE_START);
        frame.getContentPane().add(code,BorderLayout.CENTER);
        frame.getContentPane().add(terminal,BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
    	buildFrame();
    }
}
/*
class codeChanged implements DocumentListener {
    String newline = "\n";
 
    public void insertUpdate(DocumentEvent e) {
    	if(!editor.autoChanging) {
    		editor.syntax();
    	} else {
    		editor.autoChanging = false;
    	}
    }
    public void removeUpdate(DocumentEvent e) {
        System.out.println(e.getType());
    }
    public void changedUpdate(DocumentEvent e) {
    	System.out.println(e.getType());
    }
}*/
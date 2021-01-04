/**
 *  Written by Enay Bhatnagar
 * 
 *  Updated on Nov 11, 2020 
 * 
 *  Version NO. 1.0.0
 */
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import java.awt.datatransfer.*;
public class HTML extends JFrame
{
    KeyboardInput keyboard = new KeyboardInput();
    MouseInput1 mouse; 
    
    Canvas canvas;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static int HEIGHT = screenSize.height-14;
    static int WIDTH = screenSize.width;
    static ArrayList<String> lines = new ArrayList<String>();
    static Point bar = new Point(0, 0);
    
    static Point end = new Point(0, 0);
    File file = new File("untitled.html");
    int endCom = 15;
    int high = 0;
    double barPercent=1;
    int shift = 0;
    public static void main(String[] args) throws InterruptedException, UnsupportedFlavorException
    {  
        HTML program = new HTML();
        program.setTitle( "HTML" );
        program.setVisible( true );
        program.run();
        System.exit( 0 );
    } 
    
    public HTML() 
    {
        setIgnoreRepaint( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        canvas = new Canvas();
        canvas.setIgnoreRepaint( true );
        canvas.setSize( WIDTH, HEIGHT );
        add( canvas );
        pack();
        
        addKeyListener( keyboard );
        canvas.addKeyListener( keyboard );
        
        mouse = new MouseInput1();
        addMouseListener( mouse );
        addMouseMotionListener( mouse );
        canvas.addMouseListener( mouse );
        canvas.addMouseMotionListener( mouse );
    }
    public void run() throws InterruptedException, UnsupportedFlavorException
    { 
        canvas.createBufferStrategy( 2 );
        BufferStrategy buffer = canvas.getBufferStrategy();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        BufferedImage bi = gc.createCompatibleImage( WIDTH, HEIGHT );
        
        Graphics graphics = null;
        Graphics2D draw = null;
        Color background = Color.WHITE;
        
        
        lines.add("<!DOCTYPE html>");
        lines.add("<!-- Useful IDE Hints: -->");
        lines.add("<!-- F1→<p> -->");
        lines.add("<!-- F2→<b> -->");
        lines.add("<!-- F3→<i> -->");
        lines.add("<!-- F4→<u> -->");
        lines.add("<!-- F5→<h1> -->");
        lines.add("<!-- F6→<h2> -->");
        lines.add("<!-- F7→<h3> -->");
        lines.add("<!-- F8→<h4> -->");
        lines.add("<!-- F9→<a> -->");
        lines.add("<!-- F10→<img> -->");
        lines.add("<!-- F11→<table> -->");
        lines.add("<!-- F12→Opens HTML File in Browser -->");
        lines.add("<html>");
        lines.add("   <head>");
        lines.add("      <meta charset=\"utf-8\"/>");
        lines.add("      <meta name=\"description\" content=\"\">");
        lines.add("      <meta name=\"keywords\" content=\"\">");
        lines.add("      <meta name=\"author\" content=\"\">");
        lines.add("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        lines.add("      <title></title>");
        lines.add("");
        lines.add("   </head>");
        lines.add("   <body>");
        lines.add("");
        lines.add("   </body>");
        lines.add("</html>");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        lines.add("");
        while(keyboard.keyDown( KeyEvent.VK_ESCAPE ) == false) 
        {
            try { 
                keyboard.poll();
                mouse.poll();
                draw = bi.createGraphics();
                draw.setColor( background );
                draw.fillRect( 0, 0, WIDTH, HEIGHT );
                draw.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
                
                draw.setColor(new Color(230,230,230));
                draw.fillRect(WIDTH- 20, 0, 20, HEIGHT);
                
                draw.setColor(Color.GRAY);
                draw.fillRect(WIDTH-16,5,12,(int)barPercent);
                
                draw.setColor(Color.BLACK);
                draw.drawLine(0,0,WIDTH,0);
                for (int i = 0; i < lines.size() + 1;i++)
                {
                    if (i < 10)
                    {
                        draw.drawString(i+"", 28, i*14 - shift);
                    }
                    else if (i < 100)
                    {
                        draw.drawString(i+"", 20, i*14 - shift);
                    }
                    else if (i < 1000)
                    {
                        draw.drawString(i+"", 12, i*14 - shift);
                    }
                }
                draw.drawLine(38, 0, 38, HEIGHT);
                
                
                for (int i = 0; i<lines.size();i++)
                {
                    /*
                    if (lines.get(i).indexOf("<table>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("<table>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("<table>"))*8,14);
                    }
                    if (lines.get(i).indexOf("</table>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("</table>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("</table>"))*8,14);
                    }
                    if (lines.get(i).indexOf("<tr>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("<tr>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("<tr>"))*8,14);
                    }
                    if (lines.get(i).indexOf("<td>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("<td>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("<td>"))*8,14);
                    }
                    if (lines.get(i).indexOf("<th>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("<th>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("<th>"))*8,14);
                    }
                    if (lines.get(i).indexOf("</tr>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("</tr>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("</tr>"))*8,14);
                    }
                    if (lines.get(i).indexOf("</td>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("</td>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("</td>"))*8,14);
                    }
                    if (lines.get(i).indexOf("</th>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(242,219,222));
                        draw.fillRect(46 + lines.get(i).indexOf("</th>")*8, 14*i +2,(lines.get(i).length()-lines.get(i).indexOf("</th>"))*8,14);
                    }
                    
                    if (lines.get(i).indexOf("<ul>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("<ul>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<ol>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("<ol>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<li>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("<li>")*8,14*i+2, 32,14);
                    }
                    if (lines.get(i).indexOf("</ul>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("</ul>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</ol>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("</ol>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</li>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(209,237,242));
                        draw.fillRect(46 + lines.get(i).indexOf("</li>")*8,14*i+2, 40,14);
                    }
                    
                    if (lines.get(i).indexOf("<p>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<p>")*8, 14*i +2,24,14);
                    }
                    if (lines.get(i).indexOf("<b>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<b>")*8, 14*i +2,24,14);
                    }
                    if (lines.get(i).indexOf("<i>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<i>")*8, 14*i +2,24,14);
                    }
                    if (lines.get(i).indexOf("<u>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<u>")*8, 14*i +2,24,14);
                    }
                    if (lines.get(i).indexOf("</p>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</p>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("</b>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</b>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("</i>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</i>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("</u>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(159,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</u>")*8, 14*i +2,32,14);
                    }
                    
                    if (lines.get(i).indexOf("<h1>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h1>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<h2>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h2>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<h3>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h3>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<h4>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h4>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<h5>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h5>")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf("<h6>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("<h6>")*8, 14*i +2,32,14);
                    }
                    
                    if (lines.get(i).indexOf("</h1>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h1>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</h2>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h2>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</h3>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h3>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</h4>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h4>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</h5>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h5>")*8, 14*i +2,40,14);
                    }
                    if (lines.get(i).indexOf("</h6>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(255,255,191));
                        draw.fillRect(46 + lines.get(i).indexOf("</h6>")*8, 14*i +2,40,14);
                    }
                    
                    if (lines.get(i).indexOf("<img ")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(208,184,218));
                        draw.fillRect(46 + lines.get(i).indexOf("<img ")*8, 14*i +2,32,14);
                    }
                    if (lines.get(i).indexOf(" />")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(208,184,218));
                        draw.fillRect(54 + lines.get(i).indexOf(" />")*8, 14*i +2,16,14);
                    }
                    if (lines.get(i).indexOf("<a ")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(208,184,218));
                        draw.fillRect(46 + lines.get(i).indexOf("<a ")*8, 14*i +2,16,14);
                    }
                    if (lines.get(i).indexOf("</a>")!= -1 && i > endCom)
                    {
                        draw.setColor(new Color(208,184,218));
                        draw.fillRect(46 + lines.get(i).indexOf("</a>")*8, 14*i +2,32,14);
                    }
                    */
                    draw.setColor(Color.BLACK);
                    draw.drawString(lines.get(i), 46, 14*i+14  - shift);
                }
                draw.drawLine((int)bar.getX()*8 + 46, (int)bar.getY()*14, (int)bar.getX()*8 + 46, (int)bar.getY()*14 +15);
                
                processInput();
               
                graphics = buffer.getDrawGraphics();
                graphics.drawImage( bi, 0, 0, null );
                if( !buffer.contentsLost() )
                buffer.show();
            
                Thread.sleep(15);
            
            }
                finally 
            {
            
                if( graphics != null ) 
                  graphics.dispose();
                if( draw != null ) 
                  draw.dispose();
              
            }
          
        }
        save();
    }
    public String getClipBoard() throws UnsupportedFlavorException{
        try {
            return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (HeadlessException e) {
            e.printStackTrace();            
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public void save()
    {
        try {
            FileWriter myWriter = new FileWriter("Untitled.html");
            for (int i = 0; i < lines.size();i++)
            {
                myWriter.write(lines.get(i));
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void processInput() throws InterruptedException, UnsupportedFlavorException
    {
       barPercent = HEIGHT*HEIGHT/(lines.size()*1+HEIGHT);  
        
        
        
        if (keyboard.keyDown( KeyEvent.VK_CONTROL) && keyboard.keyDownOnce( KeyEvent.VK_V))//fix bugs of using when program starts
        {
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + getClipBoard() + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            bar = new Point ((int)bar.getX() + getClipBoard().length(), (int)bar.getY()); 
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()-1) + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            bar = new Point((int)bar.getX()-1, (int)bar.getY());
        }
        
        if (keyboard.keyDown( KeyEvent.VK_CONTROL) && keyboard.keyDownOnce( KeyEvent.VK_S))
        {
            save();
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()-1) + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            bar = new Point((int)bar.getX()-1, (int)bar.getY());
        }
        
        
        if (keyboard.keyDownOnce( KeyEvent.VK_END ))
        {
            bar = new Point (lines.get((int)bar.getY()).length(), (int)bar.getY());
        }
        if (keyboard.keyDownOnce( KeyEvent.VK_HOME ))
        {
            bar = new Point (0, (int)bar.getY());
        }
        if (bar.getX() == 0)
        {
            if (keyboard.keyDownOnce( KeyEvent.VK_F1 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <p></p>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F2 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <b></b>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F3 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <i></i>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F4 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <u></u>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            
            if (keyboard.keyDownOnce( KeyEvent.VK_F5 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <h1></h1>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F6 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <h2></h2>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F7 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <h3></h3>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F8 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <h4></h4>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            
            if (keyboard.keyDownOnce( KeyEvent.VK_F9 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <a href=\"\" target=\"_blank\"></a>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point (lines.get((int)bar.getY()).indexOf("\"")+1, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F10 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "      <img src=\"\" alt=\"\" width=\"\" height=\"\" />" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point (lines.get((int)bar.getY()).indexOf("\"")+1, (int)bar.getY());
            }
        }
        else
        {
            if (keyboard.keyDownOnce( KeyEvent.VK_F1 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<p></p>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F2 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<b></b>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F3 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<i></i>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F4 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<u></u>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 3, (int)bar.getY());
            }
            
            if (keyboard.keyDownOnce( KeyEvent.VK_F5 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<h1></h1>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F6 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<h2></h2>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F7 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<h3></h3>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F8 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<h4></h4>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point ((int)bar.getX() + 4, (int)bar.getY());
            }
            
            if (keyboard.keyDownOnce( KeyEvent.VK_F9 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<a href=\"\" target=\"_blank\"></a>" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point (lines.get((int)bar.getY()).indexOf("\"")+1, (int)bar.getY());
            }
            if (keyboard.keyDownOnce( KeyEvent.VK_F10 ))
            {
                lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + "<img src=\"\" alt=\"\" width=\"\" height=\"\" />" + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
                bar = new Point (lines.get((int)bar.getY()).indexOf("\"")+1, (int)bar.getY());
            }
        }
        if (keyboard.keyDownOnce( KeyEvent.VK_F12 ))
        {
            lines.add((int)bar.getY(), "      <table>");
            lines.add((int)bar.getY()+1, "         <tr>");
            lines.add((int)bar.getY()+2, "            <th></th>");
            lines.add((int)bar.getY()+3, "            <th></th>");
            lines.add((int)bar.getY()+4, "         </tr>");
            lines.add((int)bar.getY()+5, "         <tr>");
            lines.add((int)bar.getY()+6, "            <td></td>");
            lines.add((int)bar.getY()+7, "            <td></td>");
            lines.add((int)bar.getY()+8, "         </tr>");
            lines.add((int)bar.getY()+9, "         <tr>");
            lines.add((int)bar.getY()+10, "            <td></td>");
            lines.add((int)bar.getY()+11, "            <td></td>");
            lines.add((int)bar.getY()+12, "         </tr>");
            lines.add((int)bar.getY()+13, "      </table>");
            bar = new Point ((int)bar.getX(), (int)bar.getY()+13);
        }
        if (keyboard.keyDownOnce( KeyEvent.VK_F12 ) && keyboard.keyDownOnce( KeyEvent.VK_ALT ))
        {
            save();
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        if (keyboard.keyDownOnce( KeyEvent.VK_RIGHT ))
        {
            bar = new Point ((int)bar.getX() + 1, (int)bar.getY());
        }
        if (keyboard.keyDownOnce( KeyEvent.VK_LEFT) && bar.getX() > 0)
        {
            bar = new Point ((int)bar.getX() - 1, (int)bar.getY());
        }
        if (keyboard.keyDownOnce( KeyEvent.VK_DOWN ) && bar.getY() < lines.size()-1)
        {
            bar = new Point ((int)bar.getX(), (int)bar.getY() + 1);
        } 
        if (keyboard.keyDownOnce( KeyEvent.VK_UP) && bar.getY() > 0)
        {
            bar = new Point ((int)bar.getX(), (int)bar.getY() - 1);
        }
        
        if (KeyboardInput.check == true && KeyboardInput.check2 == true && KeyboardInput.check3 == true && !(KeyboardInput.val == KeyEvent.VK_BACK_SPACE))
        {
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()) + KeyboardInput.val + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            bar = new Point ((int)bar.getX()+1, (int)bar.getY());
            KeyboardInput.check3 = false;
        }
        
        
        if (keyboard.keyDownOnce( KeyEvent.VK_BACK_SPACE) && bar.getX() == 0 && bar.getY() > 1)
        {
            int x = lines.get((int)bar.getY()- 1).length();
            lines.set((int)bar.getY()- 1, lines.get((int)bar.getY()-1) + lines.get((int)bar.getY()));
            bar = new Point(x, (int)bar.getY()- 1);
            lines.remove((int)bar.getY()+1);
        }
        else if (keyboard.keyDownOnce( KeyEvent.VK_BACK_SPACE) && bar.getX() > 0)
        {
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()-1) + lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            bar = new Point((int)bar.getX()-1, (int)bar.getY());
        }
        
        if (keyboard.keyDownOnce( KeyEvent.VK_ENTER))// && bar.getY()*14 -shift != HEIGHT)
        {
            lines.add((int)bar.getY()+1, lines.get((int)bar.getY()).substring((int)bar.getX(), lines.get((int)bar.getY()).length()));
            lines.set((int)bar.getY(),lines.get((int)bar.getY()).substring(0, (int)bar.getX()));
            if (bar.getY() < HEIGHT/14 -4)
            {
                bar = new Point(0, (int)bar.getY()+ 1);
            }
            else
            {
                shift = shift + 14;
                bar = new Point(0, (int)bar.getY());
            }
        }
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        
        if (mouse.buttonDownOnce( 1 ) && x > 46  && y > 28 && y < lines.size()*14 + 28)
        {
            bar = new Point((int)(x-46)/8 , (int)(y-28)/14 );
        }
        else if(mouse.buttonDownOnce( 1 ) && x <= 46 && y > 28  && y < lines.size()*14 + 28)
        {
            bar = new Point(0 , (int)(y-28)/14 );
        }
        else if(mouse.buttonDownOnce( 1 ) && x > 46 && y <= 28)
        {
            bar = new Point((int)(x-46)/8 , 0 );
        }
        
        if ((int)bar.getX() > lines.get((int)bar.getY()).length())
        {
            bar = new Point(lines.get((int)bar.getY()).length(), (int)bar.getY() );
        }
        if ((int)bar.getY()*14 >= HEIGHT)
        {
            bar = new Point(lines.get((int)bar.getY()).length(), (int)bar.getY()*14 );
        }
    }
}

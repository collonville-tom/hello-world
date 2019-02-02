package jProgressBarTest;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame
{
    public ProgressBarTest()
    {
        super();
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        final JProgressBar filesProgress=new JProgressBar();
        filesProgress.setMinimum(0);
        filesProgress.setStringPainted(true);
        filesProgress.setBounds(80, 92, 360, 15);
        this.add(filesProgress);
        filesProgress.setValue(0);
        filesProgress.setMaximum(10);
        this.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                filesProgress.setValue(filesProgress.getValue()+1);
            }

            public void mousePressed(MouseEvent e)
            {
            // TODO Auto-generated method stub
            }

            public void mouseReleased(MouseEvent e)
            {
            // TODO Auto-generated method stub
            }

            public void mouseEntered(MouseEvent e)
            {
            // TODO Auto-generated method stub
            }

            public void mouseExited(MouseEvent e)
            {
            // TODO Auto-generated method stub
            }
        });
    }

    public static void main(String[] args)
    {
        ProgressBarTest test=new ProgressBarTest();
        test.setVisible(true);
        test.pack();
    }
}

package lookAndFeelTest;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class LookView extends JPanel
{
    final private String[] lookFeel={"default","system","motif","synth"};
    private JComboBox cb;
    private JLabel lab;
    private JLabel leb;
    private JFrame frame;

    public LookView(final JFrame frame)
    {
        super();
        this.frame=frame;
        leb=new JLabel();
        leb.setName("tata");
        leb.setFont(new Font("Dialog", 0, 11));
        leb.setText("And Feel");
        this.add(leb);
        lab=new JLabel();
        lab.setName("tutu");
        lab.setFont(new Font("Dialog", 0, 11));
        lab.setText("look :");
        this.add(lab);
        cb=new JComboBox(lookFeel);
        cb.setName("toto");
        cb.setFont(new Font("Dialog", 0, 11));
        cb.setSelectedIndex(0);
        this.add(cb);
        cb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    JComboBox cb=(JComboBox) e.getSource();
                    String lookFeel=(String) cb.getSelectedItem();
                    if (lookFeel.equals("default"))
                    {
                        UIManager.setLookAndFeel(UIManager
                            .getCrossPlatformLookAndFeelClassName());
                    }
                    if (lookFeel.equals("system"))
                    {
                        UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                    }
                    if (lookFeel.equals("motif"))
                    {
                        UIManager
                            .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    }
                    if (lookFeel.equals("synth"))
                    {
                        SynthLookAndFeel synth=new SynthLookAndFeel();
                        Class classe=LookView.class;
                        InputStream is=classe.getResourceAsStream("synth.xml");
                        synth.load(is, classe);
                        UIManager.setLookAndFeel(synth);
                    }
                    SwingUtilities.updateComponentTreeUI(frame);
                    frame.pack();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        LookView panel=new LookView(frame);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        UIManager.LookAndFeelInfo[] inf=UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info: inf)
        {
            System.out.println(info);
        }
    }
}

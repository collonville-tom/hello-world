package jTableTest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestJTable extends JFrame
{
    private JTable table;

    public TestJTable()
    {
        super();
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        MaTable maTable=new MaTable();
        maTable.getNom().add("toto");
        maTable.getNom().add("tata");
        maTable.getAge().add(12);
        maTable.getAge().add(14);
        table=new JTable(maTable);
        JScrollPane scrollpane=new JScrollPane(table);
        // table.setBorder(new BevelBorder(BevelBorder.LOWERED));
        // scrollpane.setPreferredSize(new Dimension(430, 200));
        this.add(scrollpane);
        ;
    }

    public static void main(String[] args)
    {
        TestJTable frame=new TestJTable();
        frame.setVisible(true);
        frame.pack();
    }
}

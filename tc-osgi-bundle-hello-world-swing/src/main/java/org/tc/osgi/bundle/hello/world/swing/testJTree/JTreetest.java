package testJTree;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class JTreetest extends JFrame
{
    public JTreetest()
    {
        super();
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("root");
        final DefaultMutableTreeNode feuille1=new DefaultMutableTreeNode(
                "feuille1");
        DefaultMutableTreeNode feuille2=new DefaultMutableTreeNode("feuille2");
        feuille1.setAllowsChildren(true);
        feuille2.setAllowsChildren(false);
        root.add(feuille1);
        root.add(feuille2);
        final DefaultTreeModel model=new DefaultTreeModel(root);
        model.setAsksAllowsChildren(true);
        final JTree tree=new JTree(model);
        tree.setShowsRootHandles(true);
        tree.setEditable(true);
        tree.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton()==MouseEvent.BUTTON1)
                {
                    TreePath path=tree.getSelectionPath();
                    System.out.println(path.getLastPathComponent().toString());
                }
                // tree.getLastSelectedPathComponent(); // peut etre utiliser a
                // la place de ce qu'il y a avant
                if (e.getButton()==MouseEvent.BUTTON3)
                {
                    DefaultMutableTreeNode nouveau=new DefaultMutableTreeNode(
                            "nouveuNoeud");
                    model.insertNodeInto(nouveau, (MutableTreeNode) tree
                        .getLastSelectedPathComponent(), 0);
                    System.out.println("toto");
                    TreePath path=new TreePath(model.getPathToRoot(nouveau));
                    tree.makeVisible(path);
                    tree.scrollPathToVisible(path);
                    // model.removeNodeFromParent(/*bleble*/);
                    // model.nodeChanged(/*bleble*/);
                }
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
        JScrollPane pane=new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(430, 200));
        this.add(pane);
    }

    public static void main(String[] args)
    {
        JTreetest test=new JTreetest();
        test.setVisible(true);
        test.pack();
    }
}

package jTableTest;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MaTable extends AbstractTableModel
{
    private String[] columnsNames={"Nom","Age"};
    private ArrayList<String> nom=new ArrayList<String>();
    private ArrayList<Integer> age=new ArrayList<Integer>();

    public int getRowCount()
    {
        return nom.size();
    }

    public int getColumnCount()
    {
        return 2;
    }

    public Object getValueAt(int rowIndex,
                             int columnIndex)
    {
        if (columnIndex==0)
        {
            return nom.get(rowIndex);
        }
        if (columnIndex==1)
        {
            return age.get(rowIndex);
        }
        return null;
    }

    public String getColumnName(int column)
    {
        if (column==0)
        {
            return columnsNames[0];
        }
        if (column==1)
        {
            return columnsNames[1];
        }
        return "";
    }

    public Class getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row,
                                  int col)
    {
        return true;
    }

    public void setValueAt(Object aValue,
                           int row,
                           int column)
    {
        System.out.println("Setting value to: "+aValue);
        if (column==0)
        {
            this.nom.set(row, (String) aValue);
        }
        if (column==1)
        {
            this.age.set(row, (Integer) aValue);
        }
    }

    /**
     * @return Returns the age.
     */
    public ArrayList<Integer> getAge()
    {
        return age;
    }

    /**
     * @param age
     *        The age to set.
     */
    public void setAge(ArrayList<Integer> age)
    {
        this.age=age;
    }

    /**
     * @return Returns the columnsNames.
     */
    public String[] getColumnsNames()
    {
        return columnsNames;
    }

    /**
     * @param columnsNames
     *        The columnsNames to set.
     */
    public void setColumnsNames(String[] columnsNames)
    {
        this.columnsNames=columnsNames;
    }

    /**
     * @return Returns the nom.
     */
    public ArrayList<String> getNom()
    {
        return nom;
    }

    /**
     * @param nom
     *        The nom to set.
     */
    public void setNom(ArrayList<String> nom)
    {
        this.nom=nom;
    }
}

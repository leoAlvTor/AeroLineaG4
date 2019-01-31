package modelo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class IconTextField extends JTextField {
    private Border mBorder;
    private Icon mIcon;

    public IconTextField(){}

    public void setBorder(Border border){
        mBorder = border;

        if (mIcon == null) {
            super.setBorder(border);
        } else {
            Border margin = BorderFactory.createEmptyBorder(0, 20, 0, -7);
            Border compoud = BorderFactory.createCompoundBorder(border, margin);
            super.setBorder(compoud);
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        if(mIcon != null){
            Insets insets = mBorder.getBorderInsets(this);
            mIcon.paintIcon(this, graphics, insets.right, insets.right);
        }
    }

    public void setmIcon(Icon icon){
        mIcon = icon;
        resetBorder();
    }

    public void resetBorder(){
        setBorder(mBorder);
    }
}

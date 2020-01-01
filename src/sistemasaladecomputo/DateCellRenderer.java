/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasaladecomputo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Miguel
 */
public class DateCellRenderer extends DefaultTableCellRenderer {
    public DateCellRenderer() { super(); }

    @Override
    public void setValue(Object value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = null;
        try {
            date = inputFormat.parse(value.toString());
        } catch (ParseException ex) {
            Logger.getLogger(DateCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }

        setText((value == null) ? "" : sdf.format(date));
    }
}

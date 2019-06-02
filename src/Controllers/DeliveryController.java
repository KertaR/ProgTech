package Controllers;

import Models.DeliveryModel;
import Views.DeliveryView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryController {
    private DeliveryView view;
    private DeliveryModel model;
    public DeliveryController(DeliveryView view, DeliveryModel model)
    {
        this.view = view;
        this.model = model;
        model.GetData(view.GetModel());
        view.EditingActionListener(new EditingListener());
    }
    class EditingListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int i = view.GetDatas().getSelectedRow();
            String process = "";
            DefaultTableModel tablemodel = view.GetModel();
            process = view.GetProcess();
            model.UpdateData(i, process, tablemodel);
        }
    }
}

package Controllers;

import Models.DeliveryModel;
import Views.DeliveryView;

import javax.swing.*;
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
        view.ElkeszitesActionListener(new ElkeszitListener());
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
    class ElkeszitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            DefaultTableModel tablemodel = view.GetModel();
            int i = view.GetDatas().getSelectedRow();
            JTextArea szoveg;
            szoveg = view.GetSzovegdoboz();
            model.Elkeszites(szoveg, i, tablemodel);
        }
    }
}
